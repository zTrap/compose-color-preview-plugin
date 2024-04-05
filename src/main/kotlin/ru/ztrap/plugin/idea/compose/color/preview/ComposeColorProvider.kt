package ru.ztrap.plugin.idea.compose.color.preview

import androidx.compose.ui.graphics.Color as ComposeColor
import androidx.compose.ui.graphics.colorspace.ColorSpace as ComposeColorSpace
import androidx.compose.ui.graphics.colorspace.ColorSpaces as ComposeColorSpaces
import java.awt.Color as AwtColor
import com.intellij.openapi.application.runWriteAction
import com.intellij.openapi.editor.ElementColorProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.psi.tree.IElementType
import org.jetbrains.kotlin.KtNodeTypes
import org.jetbrains.kotlin.idea.KotlinLanguage
import org.jetbrains.kotlin.idea.caches.resolve.analyze
import org.jetbrains.kotlin.idea.references.mainReference
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.KtCallExpression
import org.jetbrains.kotlin.psi.KtConstantExpression
import org.jetbrains.kotlin.psi.KtDotQualifiedExpression
import org.jetbrains.kotlin.psi.KtNameReferenceExpression
import org.jetbrains.kotlin.psi.KtPrefixExpression
import org.jetbrains.kotlin.psi.KtPsiFactory
import org.jetbrains.kotlin.psi.KtReferenceExpression
import org.jetbrains.kotlin.psi.KtValueArgument
import org.jetbrains.kotlin.psi.psiUtil.astReplace
import org.jetbrains.kotlin.psi.psiUtil.getParentOfType
import org.jetbrains.kotlin.resolve.constants.evaluate.ConstantExpressionEvaluator
import org.jetbrains.kotlin.resolve.lazy.BodyResolveMode
import org.jetbrains.kotlin.types.TypeUtils

private const val COMPOSE_COLOR_FQ_NAME = "androidx.compose.ui.graphics.Color"
private const val COMPOSE_COLOR_SPACE_ARG_NAME = "colorSpace"

internal const val COMPOSE_RED_ARG_NAME = "red"
internal const val COMPOSE_GREEN_ARG_NAME = "green"
internal const val COMPOSE_BLUE_ARG_NAME = "blue"
internal const val COMPOSE_ALPHA_ARG_NAME = "alpha"

internal const val HEX_FORMAT_PREFIX = "0x"
internal const val HEX_FORMAT_RADIX = 16

internal const val MAX_FLOAT_COMPONENT = 1f
internal const val MAX_HEX_COMPONENT = 0xFF

class ComposeColorProvider : ElementColorProvider {

    override fun getColorFrom(element: PsiElement): AwtColor? {
        if (element.language != KotlinLanguage.INSTANCE) return null
        if (element !is LeafPsiElement) return null
        if (element.elementType != KtTokens.IDENTIFIER) return null

        var parent = element.parent
        if (parent !is KtNameReferenceExpression) return null
        if (parent.getIdentifier() != element) return null

        parent = parent.parent
        if (parent !is KtCallExpression) return null

        return parent.getColor()?.toAwtColor()
    }

    override fun setColorTo(element: PsiElement, color: AwtColor) {
        val expression = element.getParentOfType<KtCallExpression>(true) ?: return
        val currentComposeColor = expression.getColor() ?: return
        val composeColor = ComposeColor(color.red, color.green, color.red, color.alpha)
            .convert(currentComposeColor.colorSpace)

        if (currentComposeColor == composeColor) return

        val factory = KtPsiFactory(expression.project, true)

        when (expression.valueArguments.getConstructorType()) {
            ColorConstructors.ULONG -> {
                val argument = expression.valueArguments.single()
                val newArgument = factory.createNewULongExpression(argument = argument, value = composeColor.value)
                runWriteAction { argument.lastChild.astReplace(newArgument) }
            }

            ColorConstructors.LONG -> {
                val argument = expression.valueArguments.single()
                val newArgument = factory.createNewLongExpression(argument = argument, value = color.rgb)
                runWriteAction { argument.lastChild.astReplace(newArgument) }
            }

            ColorConstructors.INT -> {
                val argument = expression.valueArguments.single()
                val newArgument = factory.createNewIntExpression(argument = argument, value = color.rgb)
                runWriteAction { argument.lastChild.astReplace(newArgument) }
            }

            ColorConstructors.INT_x3 -> {
                val arguments = expression.valueArguments
                val argumentsPack = arguments.getPackedRGB()
                val expressionsPack = factory.createNewIntExpressionsPack(argumentsPack, color)

                runWriteAction {
                    argumentsPack.replace(expressionsPack)

                    if (color.alpha != MAX_HEX_COMPONENT) {
                        val newAlphaArg = if (arguments.all(KtValueArgument::isNamed)) {
                            factory.createAlphaIntArgument(name = COMPOSE_ALPHA_ARG_NAME, value = color.alpha)
                        } else {
                            factory.createAlphaIntArgument(value = color.alpha)
                        }

                        expression.valueArgumentList?.addArgument(newAlphaArg)
                    }
                }
            }

            ColorConstructors.INT_x4 -> {
                val argumentsPack = expression.valueArguments.getPackedARGB()
                val expressionsPack = factory.createNewIntExpressionsPack(argumentsPack, color)
                runWriteAction { argumentsPack.replace(expressionsPack) }
            }

            ColorConstructors.FLOAT_x3,
            ColorConstructors.FLOAT_x3_SPACE,
            -> {
                val arguments = expression.valueArguments
                val argumentsPack = arguments.getPackedRGB()
                val expressionsPack = factory.createNewFloatExpressionsPack(argumentsPack, composeColor)

                runWriteAction {
                    argumentsPack.replace(expressionsPack)

                    if (composeColor.alpha != MAX_FLOAT_COMPONENT) {
                        val newAlphaArg = if (arguments.all(KtValueArgument::isNamed)) {
                            factory.createAlphaFloatArgument(name = COMPOSE_ALPHA_ARG_NAME, value = composeColor.alpha)
                        } else {
                            factory.createAlphaFloatArgument(value = composeColor.alpha)
                        }

                        expression.valueArgumentList?.addArgumentAfter(newAlphaArg, argumentsPack.blue)
                    }
                }
            }

            ColorConstructors.FLOAT_x4,
            ColorConstructors.FLOAT_x4_SPACE,
            -> {
                val arguments = expression.valueArguments
                val argumentsPack = arguments.getPackedARGB()
                val expressionsPack = factory.createNewFloatExpressionsPack(argumentsPack, composeColor)
                runWriteAction { argumentsPack.replace(expressionsPack) }
            }

            null -> Unit
        }
    }

    private fun KtCallExpression.getColor(): ComposeColor? {
        return valueArguments.takeIf { isComposeColorFun() }?.getColor()
    }

    private fun KtCallExpression.isComposeColorFun(): Boolean {
        return children.firstOrNull()
            ?.safeCast<KtNameReferenceExpression>()
            ?.mainReference
            ?.resolve()
            ?.kotlinFqOrConstructorName
            ?.asString() == COMPOSE_COLOR_FQ_NAME
    }

    private fun List<KtValueArgument>.getColor(): ComposeColor? {
        if (isEmpty()) return null
        if (getValidCount() != size) return null

        return when (getConstructorType()) {
            ColorConstructors.ULONG -> {
                val colorULong = single().getULong()
                ComposeColor(value = colorULong)
            }

            ColorConstructors.LONG -> {
                val colorLong = single().getLong()
                ComposeColor(color = colorLong)
            }

            ColorConstructors.INT -> {
                val colorInt = single().getInt()
                ComposeColor(color = colorInt)
            }

            ColorConstructors.INT_x3 -> {
                val pack = getPackedRGB()
                ComposeColor(
                    red = pack.red.getInt(),
                    green = pack.green.getInt(),
                    blue = pack.blue.getInt(),
                )
            }

            ColorConstructors.INT_x4 -> {
                val pack = getPackedARGB()
                ComposeColor(
                    red = pack.red.getInt(),
                    green = pack.green.getInt(),
                    blue = pack.blue.getInt(),
                    alpha = pack.alpha.getInt(),
                )
            }

            ColorConstructors.FLOAT_x3 -> {
                val pack = getPackedRGB()
                ComposeColor(
                    red = pack.red.getFloat(),
                    green = pack.green.getFloat(),
                    blue = pack.blue.getFloat(),
                )
            }

            ColorConstructors.FLOAT_x3_SPACE -> {
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

            ColorConstructors.FLOAT_x4 -> {
                val pack = getPackedARGB()
                ComposeColor(
                    red = pack.red.getFloat(),
                    green = pack.green.getFloat(),
                    blue = pack.blue.getFloat(),
                    alpha = pack.alpha.getFloat(),
                )
            }

            ColorConstructors.FLOAT_x4_SPACE -> {
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
            else -> error("Unexpected type ${lastChild?.javaClass?.canonicalName}")
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

    private fun List<KtValueArgument>.getConstructorType(): ColorConstructors? {
        val firstArgument = first()
        if (size == 1) {
            val firstArgumentText = firstArgument.lastChild.text
            val isULong = firstArgument.isTyped(KtNodeTypes.INTEGER_CONSTANT) && firstArgumentText.contains("u", true)
            val isInt = firstArgument.isTyped(KtNodeTypes.INTEGER_CONSTANT) && firstArgumentText.toIntOrNull() != null

            return when {
                isULong -> ColorConstructors.ULONG
                isInt -> ColorConstructors.INT
                else -> ColorConstructors.LONG
            }
        }

        val isFloat = firstArgument.isTyped(KtNodeTypes.FLOAT_CONSTANT)
        if (size == 3) {
            return if (isFloat) ColorConstructors.FLOAT_x3 else ColorConstructors.INT_x3
        }

        if (size == 4) {
            val haveSpace = findColorSpace().let {
                it?.lastChild is KtReferenceExpression || it?.lastChild is KtDotQualifiedExpression
            }

            return when {
                isFloat && haveSpace -> ColorConstructors.FLOAT_x3_SPACE
                isFloat -> ColorConstructors.FLOAT_x4
                else -> ColorConstructors.INT_x4
            }
        }

        if (size == 5) {
            return ColorConstructors.FLOAT_x4_SPACE
        }

        return null
    }

    private fun KtValueArgument?.getSpace(): ComposeColorSpace? {
        val constantName = when (val child = this?.lastChild) {
            is KtDotQualifiedExpression -> child.lastChild.text
            is KtReferenceExpression -> child.text
            else -> return null
        }

        return when (constantName) {
            "Srgb" -> ComposeColorSpaces.Srgb
            "LinearSrgb" -> ComposeColorSpaces.LinearSrgb
            "ExtendedSrgb" -> ComposeColorSpaces.ExtendedSrgb
            "LinearExtendedSrgb" -> ComposeColorSpaces.LinearExtendedSrgb
            "Bt709" -> ComposeColorSpaces.Bt709
            "Bt2020" -> ComposeColorSpaces.Bt2020
            "DciP3" -> ComposeColorSpaces.DciP3
            "DisplayP3" -> ComposeColorSpaces.DisplayP3
            "Ntsc1953" -> ComposeColorSpaces.Ntsc1953
            "SmpteC" -> ComposeColorSpaces.SmpteC
            "AdobeRgb" -> ComposeColorSpaces.AdobeRgb
            "ProPhotoRgb" -> ComposeColorSpaces.ProPhotoRgb
            "Aces" -> ComposeColorSpaces.Aces
            "Acescg" -> ComposeColorSpaces.Acescg
            "CieXyz" -> ComposeColorSpaces.CieXyz
            "CieLab" -> ComposeColorSpaces.CieLab
            "Unspecified" -> ComposeColorSpaces.Unspecified
            "Oklab" -> ComposeColorSpaces.Oklab
            else -> null
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
}