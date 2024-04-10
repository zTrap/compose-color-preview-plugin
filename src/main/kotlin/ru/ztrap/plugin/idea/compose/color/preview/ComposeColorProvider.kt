package ru.ztrap.plugin.idea.compose.color.preview

import androidx.compose.ui.graphics.Color as ComposeColor
import java.awt.Color as AwtColor
import com.intellij.openapi.application.runWriteAction
import com.intellij.openapi.editor.ElementColorProvider
import com.intellij.openapi.util.Key
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import org.jetbrains.kotlin.idea.KotlinLanguage
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.KtBlockExpression
import org.jetbrains.kotlin.psi.KtCallExpression
import org.jetbrains.kotlin.psi.KtNameReferenceExpression
import org.jetbrains.kotlin.psi.KtParameter
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.psi.KtPropertyAccessor
import org.jetbrains.kotlin.psi.KtPsiFactory
import org.jetbrains.kotlin.psi.KtValueArgument
import org.jetbrains.kotlin.psi.psiUtil.astReplace
import org.jetbrains.kotlin.psi.psiUtil.getChildOfType
import org.jetbrains.kotlin.psi.psiUtil.getParentOfType

private val COMPOSE_COLOR_SOURCE = Key.create<KtCallExpression>("COMPOSE_COLOR_SOURCE")

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

        val colorSource = findColorSource(element) ?: return null
        val color = colorSource.getColor() ?: return null
        element.putUserData(COMPOSE_COLOR_SOURCE, colorSource)

        return color.toAwtColor()
    }

    override fun setColorTo(element: PsiElement, color: AwtColor) {
        val colorSource = element.getUserData(COMPOSE_COLOR_SOURCE) ?: return
        val arguments = colorSource.valueArguments
        val argumentList = colorSource.valueArgumentList
        val currentComposeColor = colorSource.getColor() ?: return
        val newComposeColor = ComposeColor(color.red, color.green, color.red, color.alpha)
            .convert(currentComposeColor.colorSpace)

        if (currentComposeColor == newComposeColor) return

        val factory = KtPsiFactory(colorSource.project, true)

        when (arguments.getConstructorType()) {
            ColorConstructorType.ULONG -> {
                val argument = arguments.single()
                val newArgument = factory.createNewULongExpression(argument = argument, value = newComposeColor.value)
                runWriteAction { argument.lastChild.astReplace(newArgument) }
            }

            ColorConstructorType.LONG -> {
                val argument = arguments.single()
                val newArgument = factory.createNewLongExpression(argument = argument, value = color.rgb)
                runWriteAction { argument.lastChild.astReplace(newArgument) }
            }

            ColorConstructorType.INT -> {
                val argument = arguments.single()
                val newArgument = factory.createNewIntExpression(argument = argument, value = color.rgb)
                runWriteAction { argument.lastChild.astReplace(newArgument) }
            }

            ColorConstructorType.INT_x3 -> {
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

                        argumentList?.addArgument(newAlphaArg)
                    }
                }
            }

            ColorConstructorType.INT_x4 -> {
                val argumentsPack = arguments.getPackedARGB()
                val expressionsPack = factory.createNewIntExpressionsPack(argumentsPack, color)
                runWriteAction { argumentsPack.replace(expressionsPack) }
            }

            ColorConstructorType.FLOAT_x3,
            ColorConstructorType.FLOAT_x3_SPACE,
            -> {
                val argumentsPack = arguments.getPackedRGB()
                val expressionsPack = factory.createNewFloatExpressionsPack(argumentsPack, newComposeColor)

                runWriteAction {
                    argumentsPack.replace(expressionsPack)

                    if (newComposeColor.alpha != MAX_FLOAT_COMPONENT) {
                        val newAlphaArg = if (arguments.all(KtValueArgument::isNamed)) {
                            factory.createAlphaFloatArgument(
                                name = COMPOSE_ALPHA_ARG_NAME,
                                value = newComposeColor.alpha
                            )
                        } else {
                            factory.createAlphaFloatArgument(value = newComposeColor.alpha)
                        }

                        argumentList?.addArgumentAfter(newAlphaArg, argumentsPack.blue)
                    }
                }
            }

            ColorConstructorType.FLOAT_x4,
            ColorConstructorType.FLOAT_x4_SPACE,
            -> {
                val argumentsPack = arguments.getPackedARGB()
                val expressionsPack = factory.createNewFloatExpressionsPack(argumentsPack, newComposeColor)
                runWriteAction { argumentsPack.replace(expressionsPack) }
            }

            null -> Unit
        }
    }

    private fun isComposeColorFun(callExpression: KtCallExpression): Boolean {
        return callExpression.firstChild
            ?.safeCast<KtNameReferenceExpression>()
            ?.resolveMainReference()
            ?.kotlinFqOrConstructorName
            ?.asString() == COMPOSE_COLOR_FQ_NAME
    }

    private fun findColorSource(element: LeafPsiElement): KtCallExpression? {
        val callExpression = when (val parent = element.parent) {
            is KtParameter -> parent.getChildOfType<KtCallExpression>()
            is KtProperty -> parent.getChildOfType<KtCallExpression>()
            is KtNameReferenceExpression -> parent.getParentOfType<KtCallExpression>(strict = true)
                ?.takeIf { it.parent is KtBlockExpression || it.parent is KtPropertyAccessor }

            else -> null
        }

        return callExpression?.takeIf(::isComposeColorFun)
    }
}