package ru.ztrap.plugin.idea.compose.color.preview.utils

import androidx.compose.ui.graphics.Color as ComposeColor
import java.awt.Color as AwtColor
import androidx.compose.ui.graphics.colorspace.ColorSpace
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.ui.scale.JBUIScale
import com.intellij.util.ui.ColorsIcon
import javax.swing.Icon
import org.jetbrains.kotlin.KtNodeTypes
import org.jetbrains.kotlin.asJava.namedUnwrappedElement
import org.jetbrains.kotlin.idea.base.psi.kotlinFqName
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
import org.jetbrains.kotlin.psi.KtFileAnnotationList
import org.jetbrains.kotlin.psi.KtImportList
import org.jetbrains.kotlin.psi.KtPackageDirective
import org.jetbrains.kotlin.psi.KtPrefixExpression
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.psi.KtReferenceExpression
import org.jetbrains.kotlin.psi.KtValueArgument
import org.jetbrains.kotlin.psi.psiUtil.astReplace
import org.jetbrains.kotlin.psi.psiUtil.getCallNameExpression
import org.jetbrains.kotlin.psi.psiUtil.getParentOfType
import org.jetbrains.kotlin.resolve.constants.evaluate.ConstantExpressionEvaluator
import org.jetbrains.kotlin.resolve.lazy.BodyResolveMode
import org.jetbrains.kotlin.types.TypeUtils
import ru.ztrap.plugin.idea.compose.color.preview.ColorFunction
import ru.ztrap.plugin.idea.compose.color.preview.ColorsExpressionsPack
import ru.ztrap.plugin.idea.compose.color.preview.ColorsValueArgumentsPack
import ru.ztrap.plugin.idea.compose.color.preview.line.marker.provider.ColorAwareLineMarkerInfo

private const val COMPOSE_COLOR_PACKAGE = "androidx.compose.ui.graphics"
private const val COMPOSE_COLOR_CTOR_FQ_NAME = "$COMPOSE_COLOR_PACKAGE.Color"
private const val COMPOSE_COLOR_COPY_FQ_NAME = "$COMPOSE_COLOR_CTOR_FQ_NAME.copy"
private const val COMPOSE_COLOR_CONVERT_FQ_NAME = "$COMPOSE_COLOR_CTOR_FQ_NAME.convert"
private const val COMPOSE_COLOR_HSV_FQ_NAME = "$COMPOSE_COLOR_CTOR_FQ_NAME.Companion.hsv"
private const val COMPOSE_COLOR_HSL_FQ_NAME = "$COMPOSE_COLOR_CTOR_FQ_NAME.Companion.hsl"
private const val COMPOSE_COLOR_LERP_FQ_NAME = "$COMPOSE_COLOR_PACKAGE.lerp"
private const val COMPOSE_COLOR_COMPOSITE_OVER_FQ_NAME = "$COMPOSE_COLOR_PACKAGE.compositeOver"

private const val MAX_FLOAT_COMPONENT = 1f
private const val MAX_HEX_COMPONENT = 0xFF

private const val COMPOSE_COLOR_SPACE_ARG_NAME = "colorSpace"
private const val COMPOSE_HUE_ARG_NAME = "hue"
private const val COMPOSE_SATURATION_ARG_NAME = "saturation"
private const val COMPOSE_LIGHTNESS_ARG_NAME = "lightness"
private const val COMPOSE_VALUE_ARG_NAME = "value"

internal const val COMPOSE_ALPHA_ARG_NAME = "alpha"
internal const val COMPOSE_RED_ARG_NAME = "red"
internal const val COMPOSE_GREEN_ARG_NAME = "green"
internal const val COMPOSE_BLUE_ARG_NAME = "blue"

private val COMPOSE_COLOR_CREATOR_FUNCTIONS = arrayOf(
    COMPOSE_COLOR_CTOR_FQ_NAME,
    COMPOSE_COLOR_HSL_FQ_NAME,
    COMPOSE_COLOR_HSV_FQ_NAME,
)

private val COMPOSE_COLOR_MODIFIER_FUNCTIONS = arrayOf(
    COMPOSE_COLOR_COMPOSITE_OVER_FQ_NAME,
    COMPOSE_COLOR_LERP_FQ_NAME,
    COMPOSE_COLOR_CONVERT_FQ_NAME,
    COMPOSE_COLOR_COPY_FQ_NAME,
)

private val PsiElement.kotlinFqOrCtorName: FqName?
    get() {
        val element = namedUnwrappedElement
        return if (element is KtConstructor<*>) {
            element.containingKtFile.packageFqName.child(element.nameAsName)
        } else {
            kotlinFqName
        }
    }

private val KtCallExpression.composeColorFqName: String?
    get() = getCallNameExpression()
        ?.resolveMainReference()
        ?.kotlinFqOrCtorName
        ?.asString()

@Suppress("UnusedReceiverParameter") // limit the scope of usage
internal inline fun <reified T : ColorAwareLineMarkerInfo> T.getPreScaledCommonIcon(
    infos: List<MergeableLineMarkerInfo<*>>,
): Icon = JBUIScale.scaleIcon(ColorsIcon(12, *Array(infos.size) { infos[it].cast<T>().color }))

internal val PsiElement.isInFileHeader: Boolean
    get() = haveParentOfType<KtFileAnnotationList>() ||
            haveParentOfType<KtPackageDirective>() ||
            haveParentOfType<KtImportList>()

internal fun Float.isMaxComponent(): Boolean = this == MAX_FLOAT_COMPONENT

internal fun fractionToHex(fraction: Float): Int {
    return (MAX_HEX_COMPONENT * fraction).toInt()
}

internal fun isComposeColorFun(element: KtCallExpression): Boolean {
    return element.composeColorFqName?.let { it in COMPOSE_COLOR_CREATOR_FUNCTIONS } ?: false
}

internal fun isComposeColorModifierFun(element: KtCallExpression): Boolean {
    return element.composeColorFqName?.let { it in COMPOSE_COLOR_MODIFIER_FUNCTIONS } ?: false
}

@Suppress("UseJBColor")
internal fun ComposeColor.toAwtColor(): AwtColor? {
    return convert(ColorSpaces.Srgb)
        .runCatching { AwtColor(red, green, blue, alpha) }
        .onFailure { it.printStackTrace() }
        .getOrNull()
}

internal fun List<KtValueArgument>.findByNameOrIndex(name: String, index: Int): KtValueArgument? {
    val guess = getOrNull(index)
    val guessName = guess?.getArgumentName()

    return if (guess != null && (guessName == null || guessName.text == name)) {
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

internal fun List<KtValueArgument>.getPackedHSLA(): ColorsValueArgumentsPack.ARGB {
    return ColorsValueArgumentsPack.ARGB(
        red = findByNameOrIndex(COMPOSE_HUE_ARG_NAME, 0).requireNotNull(),
        green = findByNameOrIndex(COMPOSE_SATURATION_ARG_NAME, 1).requireNotNull(),
        blue = findByNameOrIndex(COMPOSE_LIGHTNESS_ARG_NAME, 2).requireNotNull(),
        alpha = findByNameOrIndex(COMPOSE_ALPHA_ARG_NAME, 3).requireNotNull(),
    )
}

internal fun List<KtValueArgument>.getPackedHSL(): ColorsValueArgumentsPack.RGB {
    return ColorsValueArgumentsPack.RGB(
        red = findByNameOrIndex(COMPOSE_HUE_ARG_NAME, 0).requireNotNull(),
        green = findByNameOrIndex(COMPOSE_SATURATION_ARG_NAME, 1).requireNotNull(),
        blue = findByNameOrIndex(COMPOSE_LIGHTNESS_ARG_NAME, 2).requireNotNull(),
    )
}

internal fun List<KtValueArgument>.getPackedHSVA(): ColorsValueArgumentsPack.ARGB {
    return ColorsValueArgumentsPack.ARGB(
        red = findByNameOrIndex(COMPOSE_HUE_ARG_NAME, 0).requireNotNull(),
        green = findByNameOrIndex(COMPOSE_SATURATION_ARG_NAME, 1).requireNotNull(),
        blue = findByNameOrIndex(COMPOSE_VALUE_ARG_NAME, 2).requireNotNull(),
        alpha = findByNameOrIndex(COMPOSE_ALPHA_ARG_NAME, 3).requireNotNull(),
    )
}

internal fun List<KtValueArgument>.getPackedHSV(): ColorsValueArgumentsPack.RGB {
    return ColorsValueArgumentsPack.RGB(
        red = findByNameOrIndex(COMPOSE_HUE_ARG_NAME, 0).requireNotNull(),
        green = findByNameOrIndex(COMPOSE_SATURATION_ARG_NAME, 1).requireNotNull(),
        blue = findByNameOrIndex(COMPOSE_VALUE_ARG_NAME, 2).requireNotNull(),
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

internal fun KtCallExpression.createColorFunction(): ColorFunction? {
    val arguments = valueArguments
    if (arguments.isEmpty() || arguments.getValidCount() != arguments.size) return null
    val fqName = composeColorFqName

    val firstArgument = arguments.first()
    if (arguments.size == 1) {
        val firstArgumentText = firstArgument.lastChild.text
        val isULong = firstArgument.isTyped(KtNodeTypes.INTEGER_CONSTANT) && firstArgumentText.contains("u", true)
        val isInt = firstArgument.isTyped(KtNodeTypes.INTEGER_CONSTANT) && firstArgumentText.toIntOrNull() != null

        return when (fqName) {
            COMPOSE_COLOR_CTOR_FQ_NAME -> when {
                isULong -> ColorFunction.ULong(this)
                isInt -> ColorFunction.Int(this)
                else -> ColorFunction.Long(this)
            }

            COMPOSE_COLOR_COPY_FQ_NAME -> ColorFunction.Copy(this)
            COMPOSE_COLOR_COMPOSITE_OVER_FQ_NAME -> ColorFunction.CompositeOver(this)
            COMPOSE_COLOR_CONVERT_FQ_NAME -> ColorFunction.Convert(this)
            else -> null
        }
    }

    if (arguments.size == 2) {
        return when (fqName) {
            COMPOSE_COLOR_COPY_FQ_NAME -> ColorFunction.Copy(this)
            else -> null
        }
    }

    val isFloat = firstArgument.isTyped(KtNodeTypes.FLOAT_CONSTANT)
    if (arguments.size == 3) {
        return when (fqName) {
            COMPOSE_COLOR_CTOR_FQ_NAME -> if (isFloat) {
                ColorFunction.Float3(this)
            } else {
                ColorFunction.Int3(this)
            }

            COMPOSE_COLOR_COPY_FQ_NAME -> ColorFunction.Copy(this)
            COMPOSE_COLOR_HSL_FQ_NAME -> ColorFunction.Hsl3(this)
            COMPOSE_COLOR_HSV_FQ_NAME -> ColorFunction.Hsv3(this)
            COMPOSE_COLOR_LERP_FQ_NAME -> ColorFunction.Lerp(this)
            else -> null
        }
    }

    if (arguments.size == 4) {
        val haveSpace = arguments.findColorSpace().let {
            it?.lastChild is KtReferenceExpression || it?.lastChild is KtDotQualifiedExpression
        }

        return when {
            isFloat && haveSpace -> when (fqName) {
                COMPOSE_COLOR_CTOR_FQ_NAME -> ColorFunction.Float3Space(this)
                COMPOSE_COLOR_COPY_FQ_NAME -> ColorFunction.Copy(this)
                COMPOSE_COLOR_HSL_FQ_NAME -> ColorFunction.Hsl3Space(this)
                COMPOSE_COLOR_HSV_FQ_NAME -> ColorFunction.Hsv3Space(this)
                else -> null
            }

            isFloat -> when (fqName) {
                COMPOSE_COLOR_CTOR_FQ_NAME -> ColorFunction.Float4(this)
                COMPOSE_COLOR_COPY_FQ_NAME -> ColorFunction.Copy(this)
                COMPOSE_COLOR_HSL_FQ_NAME -> ColorFunction.Hsl4(this)
                COMPOSE_COLOR_HSV_FQ_NAME -> ColorFunction.Hsv4(this)
                else -> null
            }

            else -> ColorFunction.Int4(this)
        }
    }

    if (arguments.size == 5) {
        return when (fqName) {
            COMPOSE_COLOR_CTOR_FQ_NAME -> ColorFunction.Float4Space(this)
            COMPOSE_COLOR_COPY_FQ_NAME -> ColorFunction.Copy(this)
            COMPOSE_COLOR_HSL_FQ_NAME -> ColorFunction.Hsl4Space(this)
            COMPOSE_COLOR_HSV_FQ_NAME -> ColorFunction.Hsv4Space(this)
            else -> null
        }
    }

    return null
}

internal fun KtReferenceExpression.resolveMainReference(): PsiElement? = mainReference.resolve()

internal fun KtDeclaration.getInitializerOrGetterInitializer(): KtExpression? {
    if (this is KtDeclarationWithInitializer && initializer != null) return initializer
    return (this as? KtProperty)?.getter?.initializer
}

internal fun <T : Any, P : Any> T.modifyIfNotNull(param: P?, modifier: T.(P) -> T): T {
    return if (param != null) modifier(param) else this
}

private inline fun <reified T : PsiElement> PsiElement.haveParentOfType(strict: Boolean = false): Boolean {
    return getParentOfType<T>(strict) != null
}

private fun PsiElement.isTyped(type: IElementType): Boolean {
    return when (val lastChild = lastChild) {
        is KtConstantExpression -> lastChild.elementType == type
        is KtPrefixExpression -> lastChild.isTyped(type)
        else -> false
    }
}

internal fun List<KtValueArgument>.findColorSpace(): KtValueArgument? {
    return when (size) {
        4 -> findByNameOrIndex(COMPOSE_COLOR_SPACE_ARG_NAME, 3)
        5 -> findByNameOrIndex(COMPOSE_COLOR_SPACE_ARG_NAME, 4)
        else -> null
    }
}

internal fun KtValueArgument?.getSpace(): ColorSpace {
    return getSpaceOrNull().requireNotNull()
}

internal fun KtValueArgument?.getSpaceOrNull(): ColorSpace? {
    val constantName = this?.lastLeaf()?.text

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

internal fun PsiElement?.getULong(): ULong = getNumber { toLong() }.toULong()
internal fun PsiElement?.getLong(): Long = getNumber { toLong() }
internal fun PsiElement?.getInt(): Int = getNumber { toInt() }
internal fun PsiElement?.getFloat(): Float = getNumber { toFloat() }

private fun PsiElement.lastLeaf(): PsiElement = PsiTreeUtil.lastChild(this)

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

internal inline fun <reified T : Any> T?.requireNotNull(): T {
    return requireNotNull(this)
}