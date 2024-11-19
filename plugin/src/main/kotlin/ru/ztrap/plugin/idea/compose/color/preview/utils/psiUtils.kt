package ru.ztrap.plugin.idea.compose.color.preview.utils

import androidx.compose.ui.graphics.colorspace.ColorSpace
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import com.intellij.openapi.util.Key
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.siblings
import org.jetbrains.kotlin.KtNodeTypes
import org.jetbrains.kotlin.analysis.api.analyze
import org.jetbrains.kotlin.analysis.api.base.KaConstantValue
import org.jetbrains.kotlin.asJava.namedUnwrappedElement
import org.jetbrains.kotlin.idea.base.psi.kotlinFqName
import org.jetbrains.kotlin.idea.references.mainReference
import org.jetbrains.kotlin.lexer.KtTokens
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
import ru.ztrap.plugin.idea.compose.color.preview.ColorFunction
import ru.ztrap.plugin.idea.compose.color.preview.ColorsExpressionsPack
import ru.ztrap.plugin.idea.compose.color.preview.ColorsValueArgumentsPack

internal val KEY_COMPOSE_COLOR_FQ = Key.create<ColorFunction>("COMPOSE_COLOR_FQ")

internal inline fun <reified T : PsiElement> PsiElement.firstSiblingOfTypeOrNull(forward: Boolean = true): T? {
    return siblings(forward).filterIsInstance<T>().firstOrNull()
}

internal fun LeafPsiElement.isInFileHeader(): Boolean {
    return haveParentOfType<KtFileAnnotationList>() ||
            haveParentOfType<KtPackageDirective>() ||
            haveParentOfType<KtImportList>()
}

internal fun KtCallExpression.isComposeColorFun(): Boolean {
    return getGetComposeColorFqName()?.let { it in COMPOSE_COLOR_CREATOR_FUNCTIONS } ?: false
}

internal fun KtCallExpression.isComposeColorModifierFun(): Boolean {
    return getGetComposeColorFqName()?.let { it in COMPOSE_COLOR_MODIFIER_FUNCTIONS } ?: false
}

internal fun List<KtValueArgument>.find(argNames: Array<String>): List<KtValueArgument?> {
    return argNames.mapIndexed { index, name -> findByNameOrIndex(name, index) }
}

internal fun ColorsValueArgumentsPack.replace(pack: ColorsExpressionsPack) {
    red.lastChild.astReplace(pack.red)
    green.lastChild.astReplace(pack.green)
    blue.lastChild.astReplace(pack.blue)

    if (this is ColorsValueArgumentsPack.ARGB && pack is ColorsExpressionsPack.ARGB) {
        alpha.lastChild.astReplace(pack.alpha)
    }
}

internal fun KtCallExpression.createColorFunction(): ColorFunction? {
    val arguments = valueArguments
    if (arguments.isEmpty() || arguments.getValidCount() != arguments.size) return null
    val fqName = getGetComposeColorFqName()

    val firstArgument = arguments.first()
    if (arguments.size == 1) {
        val firstArgumentText = firstArgument.lastChild.text
        val isULong = firstArgument.isTyped(KtNodeTypes.INTEGER_CONSTANT) && firstArgumentText.contains("u", true)
        val isInt = firstArgument.isTyped(KtNodeTypes.INTEGER_CONSTANT) && firstArgumentText.toIntOrNull() != null

        return when (fqName) {
            COMPOSE_COLOR_FQ_NAME_CTOR -> when {
                isULong -> ColorFunction.ULong(this)
                isInt -> ColorFunction.Int(this)
                else -> ColorFunction.Long(this)
            }

            COMPOSE_COLOR_FQ_NAME_COPY -> ColorFunction.Copy(this)
            COMPOSE_COLOR_FQ_NAME_COMPOSITE_OVER -> ColorFunction.CompositeOver(this)
            COMPOSE_COLOR_FQ_NAME_CONVERT -> ColorFunction.Convert(this)
            else -> null
        }
    }

    if (arguments.size == 2) {
        return when (fqName) {
            COMPOSE_COLOR_FQ_NAME_COPY -> ColorFunction.Copy(this)
            else -> null
        }
    }

    val isFloat = firstArgument.isTyped(KtNodeTypes.FLOAT_CONSTANT)
    if (arguments.size == 3) {
        return when (fqName) {
            COMPOSE_COLOR_FQ_NAME_CTOR -> if (isFloat) {
                ColorFunction.Float3(this)
            } else {
                ColorFunction.Int3(this)
            }

            COMPOSE_COLOR_FQ_NAME_COPY -> ColorFunction.Copy(this)
            COMPOSE_COLOR_FQ_NAME_HSL -> ColorFunction.Hsl3(this)
            COMPOSE_COLOR_FQ_NAME_HSV -> ColorFunction.Hsv3(this)
            COMPOSE_COLOR_FQ_NAME_LERP -> ColorFunction.Lerp(this)
            else -> null
        }
    }

    if (arguments.size == 4) {
        val haveSpace = arguments.findColorSpaceArg().let {
            it?.lastChild is KtReferenceExpression || it?.lastChild is KtDotQualifiedExpression
        }

        return when {
            isFloat && haveSpace -> when (fqName) {
                COMPOSE_COLOR_FQ_NAME_CTOR -> ColorFunction.Float3Space(this)
                COMPOSE_COLOR_FQ_NAME_COPY -> ColorFunction.Copy(this)
                COMPOSE_COLOR_FQ_NAME_HSL -> ColorFunction.Hsl3Space(this)
                COMPOSE_COLOR_FQ_NAME_HSV -> ColorFunction.Hsv3Space(this)
                else -> null
            }

            isFloat -> when (fqName) {
                COMPOSE_COLOR_FQ_NAME_CTOR -> ColorFunction.Float4(this)
                COMPOSE_COLOR_FQ_NAME_COPY -> ColorFunction.Copy(this)
                COMPOSE_COLOR_FQ_NAME_HSL -> ColorFunction.Hsl4(this)
                COMPOSE_COLOR_FQ_NAME_HSV -> ColorFunction.Hsv4(this)
                else -> null
            }

            else -> ColorFunction.Int4(this)
        }
    }

    if (arguments.size == 5) {
        return when (fqName) {
            COMPOSE_COLOR_FQ_NAME_CTOR -> ColorFunction.Float4Space(this)
            COMPOSE_COLOR_FQ_NAME_COPY -> ColorFunction.Copy(this)
            COMPOSE_COLOR_FQ_NAME_HSL -> ColorFunction.Hsl4Space(this)
            COMPOSE_COLOR_FQ_NAME_HSV -> ColorFunction.Hsv4Space(this)
            else -> null
        }
    }

    return null
}

internal fun KtReferenceExpression.resolveMainReference(): PsiElement? = mainReference.resolve()

internal fun KtDeclaration.getInitializerOrGetterInitializer(): KtExpression? {
    return safeCast<KtDeclarationWithInitializer>()?.initializer
        ?: safeCast<KtProperty>()?.getter?.initializer
}

internal fun List<KtValueArgument>.findColorSpaceArg(): KtValueArgument? {
    return when (size) {
        4 -> findByNameOrIndex(COMPOSE_ARG_NAME_COLOR_SPACE, 3)
        5 -> findByNameOrIndex(COMPOSE_ARG_NAME_COLOR_SPACE, 4)
        else -> null
    }
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

private fun PsiElement.getKotlinFqOrCtorName(): FqName? {
    val element = namedUnwrappedElement
    return if (element is KtConstructor<*>) {
        element.containingKtFile.packageFqName.child(element.nameAsName)
    } else {
        kotlinFqName
    }
}

private fun KtCallExpression.getGetComposeColorFqName(): String? {
    return getCallNameExpression()
        ?.resolveMainReference()
        ?.getKotlinFqOrCtorName()
        ?.asString()
}

private fun List<KtValueArgument>.findByNameOrIndex(name: String, index: Int): KtValueArgument? {
    val guess = getOrNull(index)
    val guessName = guess?.getArgumentName()

    return if (guess != null && (guessName == null || guessName.text == name)) {
        guess
    } else {
        find { it.getArgumentName()?.text == name }
    }
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
        is KtPrefixExpression -> when (lastChild.operationToken) {
            KtTokens.MINUS -> -lastChild.getNumber(converter)
            KtTokens.PLUS -> +lastChild.getNumber(converter)
            else -> error("Unexpected type operation token ${lastChild.operationToken}")
        }

        else -> error("Unexpected type ${lastChild?.javaClass?.canonicalName}. Last child for $this(${this?.text})")
    }
}

private fun KtConstantExpression.getConstantValue(): Any {
    return analyze(this) {
        when (val evaluated = evaluate()) {
            is KaConstantValue.DoubleValue -> evaluated.value
            is KaConstantValue.FloatValue -> evaluated.value
            is KaConstantValue.LongValue -> evaluated.value
            is KaConstantValue.IntValue -> evaluated.value
            is KaConstantValue.ULongValue -> evaluated.value
            else -> error("Unexpected const type $evaluated")
        }
    }
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

@Suppress("UNCHECKED_CAST")
private operator fun <T : Number> T.unaryPlus(): T {
    return when (this) {
        is Double -> unaryPlus() as T
        is Float -> unaryPlus() as T
        is Long -> unaryPlus() as T
        is Int -> unaryPlus() as T
        else -> error("Unexpected type ${javaClass.canonicalName}")
    }
}