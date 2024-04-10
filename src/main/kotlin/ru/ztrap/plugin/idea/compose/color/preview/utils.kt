package ru.ztrap.plugin.idea.compose.color.preview

import androidx.compose.ui.graphics.Color as ComposeColor
import java.awt.Color as AwtColor
import androidx.compose.ui.graphics.colorspace.ColorSpace
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiMember
import com.intellij.psi.PsiPackage
import com.intellij.psi.tree.IElementType
import org.jetbrains.kotlin.KtNodeTypes
import org.jetbrains.kotlin.asJava.namedUnwrappedElement
import org.jetbrains.kotlin.idea.caches.resolve.analyze
import org.jetbrains.kotlin.idea.references.mainReference
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.psi.KtCallExpression
import org.jetbrains.kotlin.psi.KtConstantExpression
import org.jetbrains.kotlin.psi.KtConstructor
import org.jetbrains.kotlin.psi.KtDeclaration
import org.jetbrains.kotlin.psi.KtDeclarationWithInitializer
import org.jetbrains.kotlin.psi.KtDotQualifiedExpression
import org.jetbrains.kotlin.psi.KtExpression
import org.jetbrains.kotlin.psi.KtNamedDeclaration
import org.jetbrains.kotlin.psi.KtPrefixExpression
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.psi.KtReferenceExpression
import org.jetbrains.kotlin.psi.KtSimpleNameExpression
import org.jetbrains.kotlin.psi.KtValueArgument
import org.jetbrains.kotlin.psi.psiUtil.astReplace
import org.jetbrains.kotlin.resolve.constants.evaluate.ConstantExpressionEvaluator
import org.jetbrains.kotlin.resolve.lazy.BodyResolveMode
import org.jetbrains.kotlin.types.TypeUtils

private const val COMPOSE_COLOR_SPACE_ARG_NAME = "colorSpace"

internal const val COMPOSE_COLOR_FQ_NAME = "androidx.compose.ui.graphics.Color"

internal val PsiElement.kotlinFqOrConstructorName: FqName?
    get() = when (val element = namedUnwrappedElement) {
        is KtConstructor<*> -> element.containingKtFile.packageFqName.child(element.nameAsName)
        is PsiPackage -> FqName(element.qualifiedName)
        is PsiClass -> element.qualifiedName?.let(::FqName)
        is PsiMember -> element.getName()?.let { name ->
            val prefix = element.containingClass?.qualifiedName
            FqName(if (prefix != null) "$prefix.$name" else name)
        }

        is KtNamedDeclaration -> element.fqName
        else -> null
    }

@Suppress("UseJBColor")
internal fun ComposeColor.toAwtColor(): AwtColor? {
    return convert(ColorSpaces.Srgb)
        .runCatching { AwtColor(red, green, blue, alpha) }
        .onFailure { it.printStackTrace() }
        .getOrNull()
}

internal fun List<KtValueArgument>.findByNameOrIndex(name: String, index: Int): KtValueArgument? {
    val guess = get(index)
    val guessName = guess.getArgumentName()

    return if (guessName == null || guessName.text == name) {
        guess
    } else {
        find { it.getArgumentName()?.text == name }
    }
}

internal fun List<KtValueArgument>.getPackedARGB(): ColorsValueArgumentsPack.ARGB {
    return ColorsValueArgumentsPack.ARGB(
        red = findByNameOrIndex(COMPOSE_RED_ARG_NAME, 0).requireNotNull(),
        green = findByNameOrIndex(COMPOSE_GREEN_ARG_NAME, 1).requireNotNull(),
        blue = findByNameOrIndex(COMPOSE_BLUE_ARG_NAME, 2).requireNotNull(),
        alpha = findByNameOrIndex(COMPOSE_ALPHA_ARG_NAME, 3).requireNotNull(),
    )
}

internal fun List<KtValueArgument>.getPackedRGB(): ColorsValueArgumentsPack.RGB {
    return ColorsValueArgumentsPack.RGB(
        red = findByNameOrIndex(COMPOSE_RED_ARG_NAME, 0).requireNotNull(),
        green = findByNameOrIndex(COMPOSE_GREEN_ARG_NAME, 1).requireNotNull(),
        blue = findByNameOrIndex(COMPOSE_BLUE_ARG_NAME, 2).requireNotNull(),
    )
}

internal fun ColorsValueArgumentsPack.replace(pack: ColorsExpressionsPack) {
    red.lastChild.astReplace(pack.red)
    green.lastChild.astReplace(pack.green)
    blue.lastChild.astReplace(pack.blue)

    if (this is ColorsValueArgumentsPack.ARGB && pack is ColorsExpressionsPack.ARGB) {
        alpha.lastChild.astReplace(pack.alpha)
    }
}

internal inline fun <reified T : Any> Any.safeCast(): T? = this as? T

internal inline fun <reified T : Any> Any.cast(): T = this as T

internal fun KtCallExpression.getColor(): ComposeColor? {
    return valueArguments.runCatching { getColor() }.getOrNull()
}

internal fun List<KtValueArgument>.getConstructorType(): ColorConstructorType? {
    val firstArgument = first()
    if (size == 1) {
        val firstArgumentText = firstArgument.lastChild.text
        val isULong = firstArgument.isTyped(KtNodeTypes.INTEGER_CONSTANT) && firstArgumentText.contains("u", true)
        val isInt = firstArgument.isTyped(KtNodeTypes.INTEGER_CONSTANT) && firstArgumentText.toIntOrNull() != null

        return when {
            isULong -> ColorConstructorType.ULONG
            isInt -> ColorConstructorType.INT
            else -> ColorConstructorType.LONG
        }
    }

    val isFloat = firstArgument.isTyped(KtNodeTypes.FLOAT_CONSTANT)
    if (size == 3) {
        return if (isFloat) ColorConstructorType.FLOAT_x3 else ColorConstructorType.INT_x3
    }

    if (size == 4) {
        val haveSpace = findColorSpace().let {
            it?.lastChild is KtReferenceExpression || it?.lastChild is KtDotQualifiedExpression
        }

        return when {
            isFloat && haveSpace -> ColorConstructorType.FLOAT_x3_SPACE
            isFloat -> ColorConstructorType.FLOAT_x4
            else -> ColorConstructorType.INT_x4
        }
    }

    if (size == 5) {
        return ColorConstructorType.FLOAT_x4_SPACE
    }

    return null
}

internal fun KtSimpleNameExpression.resolveMainReference(): PsiElement? = mainReference.resolve()

internal fun KtDeclaration.getInitializerOrGetterInitializer(): KtExpression? {
    if (this is KtDeclarationWithInitializer && initializer != null) return initializer
    return (this as? KtProperty)?.getter?.initializer
}

private fun List<KtValueArgument>.getColor(): ComposeColor? {
    if (isEmpty()) return null
    if (getValidCount() != size) return null

    return when (getConstructorType()) {
        ColorConstructorType.ULONG -> {
            val colorULong = single().getULong()
            ComposeColor(value = colorULong)
        }

        ColorConstructorType.LONG -> {
            val colorLong = single().getLong()
            ComposeColor(color = colorLong)
        }

        ColorConstructorType.INT -> {
            val colorInt = single().getInt()
            ComposeColor(color = colorInt)
        }

        ColorConstructorType.INT_x3 -> {
            val pack = getPackedRGB()
            ComposeColor(
                red = pack.red.getInt(),
                green = pack.green.getInt(),
                blue = pack.blue.getInt(),
            )
        }

        ColorConstructorType.INT_x4 -> {
            val pack = getPackedARGB()
            ComposeColor(
                red = pack.red.getInt(),
                green = pack.green.getInt(),
                blue = pack.blue.getInt(),
                alpha = pack.alpha.getInt(),
            )
        }

        ColorConstructorType.FLOAT_x3 -> {
            val pack = getPackedRGB()
            ComposeColor(
                red = pack.red.getFloat(),
                green = pack.green.getFloat(),
                blue = pack.blue.getFloat(),
            )
        }

        ColorConstructorType.FLOAT_x3_SPACE -> {
            val pack = getPackedRGB()
            val space = findColorSpace().getSpace()
            space?.let {
                ComposeColor(
                    red = pack.red.getFloat(),
                    green = pack.green.getFloat(),
                    blue = pack.blue.getFloat(),
                    colorSpace = space,
                )
            }
        }

        ColorConstructorType.FLOAT_x4 -> {
            val pack = getPackedARGB()
            ComposeColor(
                red = pack.red.getFloat(),
                green = pack.green.getFloat(),
                blue = pack.blue.getFloat(),
                alpha = pack.alpha.getFloat(),
            )
        }

        ColorConstructorType.FLOAT_x4_SPACE -> {
            val pack = getPackedARGB()
            val space = findColorSpace().getSpace()
            space?.let {
                ComposeColor(
                    red = pack.red.getFloat(),
                    green = pack.green.getFloat(),
                    blue = pack.blue.getFloat(),
                    alpha = pack.alpha.getFloat(),
                    colorSpace = space,
                )
            }
        }

        null -> null
    }
}

private fun PsiElement.isTyped(type: IElementType): Boolean {
    return when (val lastChild = lastChild) {
        is KtConstantExpression -> lastChild.elementType == type
        is KtPrefixExpression -> lastChild.isTyped(type)
        else -> false
    }
}

private fun List<KtValueArgument>.findColorSpace(): KtValueArgument? {
    return when (size) {
        4 -> findByNameOrIndex(COMPOSE_COLOR_SPACE_ARG_NAME, 3)
        5 -> findByNameOrIndex(COMPOSE_COLOR_SPACE_ARG_NAME, 4)
        else -> null
    }
}

private fun KtValueArgument?.getSpace(): ColorSpace? {
    val constantName = when (val child = this?.lastChild) {
        is KtDotQualifiedExpression -> child.lastChild.text
        is KtReferenceExpression -> child.text
        else -> return null
    }

    return when (constantName) {
        "Srgb" -> ColorSpaces.Srgb
        "LinearSrgb" -> ColorSpaces.LinearSrgb
        "ExtendedSrgb" -> ColorSpaces.ExtendedSrgb
        "LinearExtendedSrgb" -> ColorSpaces.LinearExtendedSrgb
        "Bt709" -> ColorSpaces.Bt709
        "Bt2020" -> ColorSpaces.Bt2020
        "DciP3" -> ColorSpaces.DciP3
        "DisplayP3" -> ColorSpaces.DisplayP3
        "Ntsc1953" -> ColorSpaces.Ntsc1953
        "SmpteC" -> ColorSpaces.SmpteC
        "AdobeRgb" -> ColorSpaces.AdobeRgb
        "ProPhotoRgb" -> ColorSpaces.ProPhotoRgb
        "Aces" -> ColorSpaces.Aces
        "Acescg" -> ColorSpaces.Acescg
        "CieXyz" -> ColorSpaces.CieXyz
        "CieLab" -> ColorSpaces.CieLab
        "Unspecified" -> ColorSpaces.Unspecified
        "Oklab" -> ColorSpaces.Oklab
        else -> null
    }
}

private fun List<KtValueArgument>.getValidCount(): Int {
    return asSequence()
        .mapNotNull { it.children.lastOrNull() }
        .count {
            it is KtConstantExpression
                    || it is KtPrefixExpression
                    || it is KtReferenceExpression
                    || it is KtDotQualifiedExpression
        }
}

private fun PsiElement?.getULong(): ULong = getNumber { toLong() }.toULong()
private fun PsiElement?.getLong(): Long = getNumber { toLong() }
private fun PsiElement?.getInt(): Int = getNumber { toInt() }
private fun PsiElement?.getFloat(): Float = getNumber { toFloat() }

private fun <T : Number> PsiElement?.getNumber(converter: String.() -> T): T {
    return when (val lastChild = this?.lastChild) {
        is KtConstantExpression -> converter(lastChild.getConstantValue().toString())
        is KtPrefixExpression -> -lastChild.getNumber(converter)
        else -> error("Unexpected type ${lastChild?.javaClass?.canonicalName}. Last child for $this(${this?.text})")
    }
}

private fun KtConstantExpression.getConstantValue(): Any? {
    return ConstantExpressionEvaluator
        .getConstant(
            expression = this,
            bindingContext = analyze(BodyResolveMode.PARTIAL),
        )
        ?.getValue(TypeUtils.NO_EXPECTED_TYPE)
}

@Suppress("UNCHECKED_CAST")
private operator fun <T : Number> T.unaryMinus(): T {
    return when (this) {
        is Double -> unaryMinus() as T
        is Float -> unaryMinus() as T
        is Long -> unaryMinus() as T
        is Int -> unaryMinus() as T
        else -> error("Unexpected type ${javaClass.canonicalName}")
    }
}

private fun <T : Any> T?.requireNotNull(): T {
    return requireNotNull(this)
}