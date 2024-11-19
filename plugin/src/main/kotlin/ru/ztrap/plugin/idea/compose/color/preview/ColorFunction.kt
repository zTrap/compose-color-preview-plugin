package ru.ztrap.plugin.idea.compose.color.preview

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.Rgb
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.graphics.getComponents
import androidx.compose.ui.graphics.isSpecified
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.graphics.toArgb
import com.intellij.openapi.application.runWriteAction
import org.jetbrains.kotlin.psi.KtCallExpression
import org.jetbrains.kotlin.psi.KtPsiFactory
import org.jetbrains.kotlin.psi.KtValueArgument
import org.jetbrains.kotlin.psi.KtValueArgumentList
import org.jetbrains.kotlin.psi.psiUtil.astReplace
import ru.ztrap.plugin.idea.compose.color.preview.utils.ARGB_NAMES
import ru.ztrap.plugin.idea.compose.color.preview.utils.LERP_NAMES
import ru.ztrap.plugin.idea.compose.color.preview.utils.createAlphaFloatArgument
import ru.ztrap.plugin.idea.compose.color.preview.utils.createAlphaIntArgument
import ru.ztrap.plugin.idea.compose.color.preview.utils.createFloatArgument
import ru.ztrap.plugin.idea.compose.color.preview.utils.createIntArgument
import ru.ztrap.plugin.idea.compose.color.preview.utils.createNewFloatExpressionsPack
import ru.ztrap.plugin.idea.compose.color.preview.utils.createNewIntExpression
import ru.ztrap.plugin.idea.compose.color.preview.utils.createNewIntExpressionsPack
import ru.ztrap.plugin.idea.compose.color.preview.utils.createNewLongExpression
import ru.ztrap.plugin.idea.compose.color.preview.utils.createNewULongExpression
import ru.ztrap.plugin.idea.compose.color.preview.utils.find
import ru.ztrap.plugin.idea.compose.color.preview.utils.findColorSpaceArg
import ru.ztrap.plugin.idea.compose.color.preview.utils.getColor
import ru.ztrap.plugin.idea.compose.color.preview.utils.getFloat
import ru.ztrap.plugin.idea.compose.color.preview.utils.getInt
import ru.ztrap.plugin.idea.compose.color.preview.utils.getLong
import ru.ztrap.plugin.idea.compose.color.preview.utils.getParentReceiverColor
import ru.ztrap.plugin.idea.compose.color.preview.utils.getSpaceOrNull
import ru.ztrap.plugin.idea.compose.color.preview.utils.getULong
import ru.ztrap.plugin.idea.compose.color.preview.utils.isMaxComponent
import ru.ztrap.plugin.idea.compose.color.preview.utils.modifyIfNotNull
import ru.ztrap.plugin.idea.compose.color.preview.utils.replace
import ru.ztrap.plugin.idea.compose.color.preview.utils.safeCast
import ru.ztrap.plugin.idea.compose.color.preview.utils.toHsl
import ru.ztrap.plugin.idea.compose.color.preview.utils.toHsv

internal sealed class ColorFunction(protected val callExpression: KtCallExpression) {

    abstract fun setNewColor(color: Color, factory: KtPsiFactory)

    fun getColor(): Color? = runCatching { getColorInternal()?.takeIf { it.isSpecified } }.getOrNull()

    protected abstract fun getColorInternal(): Color?

    protected val arguments: List<KtValueArgument>
        get() = callExpression.valueArguments

    protected val argumentList: KtValueArgumentList?
        get() = callExpression.valueArgumentList

    class ULong(callExpression: KtCallExpression) : ColorFunction(callExpression) {
        override fun getColorInternal(): Color {
            val colorULong = arguments.single().getULong()
            return Color(value = colorULong)
        }

        override fun setNewColor(color: Color, factory: KtPsiFactory) {
            val argument = arguments.single()
            val newArgument = factory.createNewULongExpression(argument = argument, value = color.value)
            runWriteAction { argument.lastChild.astReplace(newArgument) }
        }
    }

    class Long(callExpression: KtCallExpression) : ColorFunction(callExpression) {
        override fun getColorInternal(): Color {
            val colorLong = arguments.single().getLong()
            return Color(color = colorLong)
        }

        override fun setNewColor(color: Color, factory: KtPsiFactory) {
            val argument = arguments.single()
            val newArgument = factory.createNewLongExpression(argument = argument, value = color.toArgb())
            runWriteAction { argument.lastChild.astReplace(newArgument) }
        }
    }

    class Int(callExpression: KtCallExpression) : ColorFunction(callExpression) {
        override fun getColorInternal(): Color {
            val colorInt = arguments.single().getInt()
            return Color(color = colorInt)
        }

        override fun setNewColor(color: Color, factory: KtPsiFactory) {
            val argument = arguments.single()
            val newArgument = factory.createNewIntExpression(argument = argument, value = color.toArgb())
            runWriteAction { argument.lastChild.astReplace(newArgument) }
        }
    }

    class Int3(callExpression: KtCallExpression) : ColorFunction(callExpression) {
        override fun getColorInternal(): Color {
            val pack = arguments.getPackedRGB()
            return Color(
                red = pack.red.getInt(),
                green = pack.green.getInt(),
                blue = pack.blue.getInt(),
            )
        }

        override fun setNewColor(color: Color, factory: KtPsiFactory) {
            val argumentsPack = arguments.getPackedRGB()
            val expressionsPack = factory.createNewIntExpressionsPack(argumentsPack, color.getComponents())

            runWriteAction {
                argumentsPack.replace(expressionsPack)

                if (!color.alpha.isMaxComponent()) {
                    val newAlphaArg = if (arguments.all(KtValueArgument::isNamed)) {
                        factory.createAlphaIntArgument(value = color.alpha)
                    } else {
                        factory.createIntArgument(value = color.alpha)
                    }

                    argumentList?.addArgument(newAlphaArg)
                }
            }
        }
    }

    class Int4(callExpression: KtCallExpression) : ColorFunction(callExpression) {
        override fun getColorInternal(): Color {
            val pack = arguments.getPackedARGB()
            return Color(
                red = pack.red.getInt(),
                green = pack.green.getInt(),
                blue = pack.blue.getInt(),
                alpha = pack.alpha.getInt(),
            )
        }

        override fun setNewColor(color: Color, factory: KtPsiFactory) {
            val argumentsPack = arguments.getPackedARGB()
            val expressionsPack = factory.createNewIntExpressionsPack(argumentsPack, color.getComponents())
            runWriteAction {
                argumentsPack.replace(expressionsPack)

                if (color.alpha.isMaxComponent()) {
                    argumentList?.removeArgument(argumentsPack.alpha)
                }
            }
        }
    }

    open class Float3(callExpression: KtCallExpression) : ColorFunction(callExpression) {
        override fun getColorInternal(): Color? {
            val pack = arguments.getPackedRGB()
            return Color(
                red = pack.red.getFloat(),
                green = pack.green.getFloat(),
                blue = pack.blue.getFloat(),
            )
        }

        override fun setNewColor(color: Color, factory: KtPsiFactory) {
            val argumentsPack = arguments.getPackedRGB()
            val expressionsPack = factory.createNewFloatExpressionsPack(argumentsPack, color.getComponents())

            runWriteAction {
                argumentsPack.replace(expressionsPack)

                if (!color.alpha.isMaxComponent()) {
                    val newAlphaArg = if (arguments.all(KtValueArgument::isNamed)) {
                        factory.createAlphaFloatArgument(value = color.alpha)
                    } else {
                        factory.createFloatArgument(value = color.alpha)
                    }

                    argumentList?.addArgumentAfter(newAlphaArg, argumentsPack.blue)
                }
            }
        }
    }

    class Float3Space(callExpression: KtCallExpression) : Float3(callExpression) {
        override fun getColorInternal(): Color? {
            val pack = arguments.getPackedRGB()
            val space = arguments.findColorSpaceArg().getSpaceOrNull()
            return space?.let {
                Color(
                    red = pack.red.getFloat(),
                    green = pack.green.getFloat(),
                    blue = pack.blue.getFloat(),
                    colorSpace = space,
                )
            }
        }
    }

    class Float4(callExpression: KtCallExpression) : ColorFunction(callExpression) {
        override fun getColorInternal(): Color {
            val pack = arguments.getPackedARGB()
            return Color(
                red = pack.red.getFloat(),
                green = pack.green.getFloat(),
                blue = pack.blue.getFloat(),
                alpha = pack.alpha.getFloat(),
            )
        }

        override fun setNewColor(color: Color, factory: KtPsiFactory) {
            val argumentsPack = arguments.getPackedARGB()
            val expressionsPack = factory.createNewFloatExpressionsPack(argumentsPack, color.getComponents())
            runWriteAction {
                argumentsPack.replace(expressionsPack)

                if (color.alpha.isMaxComponent()) {
                    argumentList?.removeArgument(argumentsPack.alpha)
                }
            }
        }
    }

    class Float4Space(callExpression: KtCallExpression) : ColorFunction(callExpression) {
        override fun getColorInternal(): Color? {
            val pack = arguments.getPackedARGB()
            val space = arguments.findColorSpaceArg().getSpaceOrNull()
            return space?.let {
                Color(
                    red = pack.red.getFloat(),
                    green = pack.green.getFloat(),
                    blue = pack.blue.getFloat(),
                    alpha = pack.alpha.getFloat(),
                    colorSpace = space,
                )
            }
        }

        override fun setNewColor(color: Color, factory: KtPsiFactory) {
            val argumentsPack = arguments.getPackedARGB()
            val expressionsPack = factory.createNewFloatExpressionsPack(argumentsPack, color.getComponents())
            runWriteAction { argumentsPack.replace(expressionsPack) }
        }
    }

    open class Hsl3(callExpression: KtCallExpression) : ColorFunction(callExpression) {
        override fun getColorInternal(): Color? {
            val pack = arguments.getPackedHSL()
            return Color.hsl(
                hue = pack.red.getFloat(),
                saturation = pack.green.getFloat(),
                lightness = pack.blue.getFloat(),
            )
        }

        override fun setNewColor(color: Color, factory: KtPsiFactory) {
            val argumentsPack = arguments.getPackedHSL()
            val expressionsPack = factory.createNewFloatExpressionsPack(argumentsPack, color.getComponents().toHsl())

            runWriteAction {
                argumentsPack.replace(expressionsPack)

                if (!color.alpha.isMaxComponent()) {
                    val newAlphaArg = if (arguments.all(KtValueArgument::isNamed)) {
                        factory.createAlphaFloatArgument(value = color.alpha)
                    } else {
                        factory.createFloatArgument(value = color.alpha)
                    }

                    argumentList?.addArgumentAfter(newAlphaArg, argumentsPack.blue)
                }
            }
        }
    }

    class Hsl3Space(callExpression: KtCallExpression) : Hsl3(callExpression) {
        override fun getColorInternal(): Color? {
            val pack = arguments.getPackedHSL()
            val space = arguments.findColorSpaceArg().getSpaceOrNull()?.safeCast<Rgb>()
            return space?.let {
                Color.hsl(
                    hue = pack.red.getFloat(),
                    saturation = pack.green.getFloat(),
                    lightness = pack.blue.getFloat(),
                    colorSpace = space,
                )
            }
        }
    }

    class Hsl4(callExpression: KtCallExpression) : ColorFunction(callExpression) {
        override fun getColorInternal(): Color {
            val pack = arguments.getPackedHSLA()
            return Color.hsl(
                hue = pack.red.getFloat(),
                saturation = pack.green.getFloat(),
                lightness = pack.blue.getFloat(),
                alpha = pack.alpha.getFloat(),
            )
        }

        override fun setNewColor(color: Color, factory: KtPsiFactory) {
            val argumentsPack = arguments.getPackedHSLA()
            val expressionsPack = factory.createNewFloatExpressionsPack(argumentsPack, color.getComponents().toHsl())
            runWriteAction {
                argumentsPack.replace(expressionsPack)

                if (color.alpha.isMaxComponent()) {
                    argumentList?.removeArgument(argumentsPack.alpha)
                }
            }
        }
    }

    class Hsl4Space(callExpression: KtCallExpression) : ColorFunction(callExpression) {
        override fun getColorInternal(): Color? {
            val pack = arguments.getPackedHSLA()
            val space = arguments.findColorSpaceArg().getSpaceOrNull()?.safeCast<Rgb>()
            return space?.let {
                Color.hsl(
                    hue = pack.red.getFloat(),
                    saturation = pack.green.getFloat(),
                    lightness = pack.blue.getFloat(),
                    alpha = pack.alpha.getFloat(),
                    colorSpace = space,
                )
            }
        }

        override fun setNewColor(color: Color, factory: KtPsiFactory) {
            val argumentsPack = arguments.getPackedHSLA()
            val expressionsPack = factory.createNewFloatExpressionsPack(argumentsPack, color.getComponents().toHsl())
            runWriteAction { argumentsPack.replace(expressionsPack) }
        }
    }

    open class Hsv3(callExpression: KtCallExpression) : ColorFunction(callExpression) {
        override fun getColorInternal(): Color? {
            val pack = arguments.getPackedHSV()
            return Color.hsv(
                hue = pack.red.getFloat(),
                saturation = pack.green.getFloat(),
                value = pack.blue.getFloat(),
            )
        }

        override fun setNewColor(color: Color, factory: KtPsiFactory) {
            val argumentsPack = arguments.getPackedHSV()
            val expressionsPack = factory.createNewFloatExpressionsPack(argumentsPack, color.getComponents().toHsv())

            runWriteAction {
                argumentsPack.replace(expressionsPack)

                if (!color.alpha.isMaxComponent()) {
                    val newAlphaArg = if (arguments.all(KtValueArgument::isNamed)) {
                        factory.createAlphaFloatArgument(value = color.alpha)
                    } else {
                        factory.createFloatArgument(value = color.alpha)
                    }

                    argumentList?.addArgumentAfter(newAlphaArg, argumentsPack.blue)
                }
            }
        }
    }

    class Hsv3Space(callExpression: KtCallExpression) : Hsv3(callExpression) {
        override fun getColorInternal(): Color? {
            val pack = arguments.getPackedHSV()
            val space = arguments.findColorSpaceArg().getSpaceOrNull()?.safeCast<Rgb>()
            return space?.let {
                Color.hsv(
                    hue = pack.red.getFloat(),
                    saturation = pack.green.getFloat(),
                    value = pack.blue.getFloat(),
                    colorSpace = space,
                )
            }
        }
    }

    class Hsv4(callExpression: KtCallExpression) : ColorFunction(callExpression) {
        override fun getColorInternal(): Color {
            val pack = arguments.getPackedHSVA()
            return Color.hsv(
                hue = pack.red.getFloat(),
                saturation = pack.green.getFloat(),
                value = pack.blue.getFloat(),
                alpha = pack.alpha.getFloat(),
            )
        }

        override fun setNewColor(color: Color, factory: KtPsiFactory) {
            val argumentsPack = arguments.getPackedHSVA()
            val expressionsPack = factory.createNewFloatExpressionsPack(argumentsPack, color.getComponents().toHsv())
            runWriteAction {
                argumentsPack.replace(expressionsPack)

                if (color.alpha.isMaxComponent()) {
                    argumentList?.removeArgument(argumentsPack.alpha)
                }
            }
        }
    }

    class Hsv4Space(callExpression: KtCallExpression) : ColorFunction(callExpression) {
        override fun getColorInternal(): Color? {
            val pack = arguments.getPackedHSVA()
            val space = arguments.findColorSpaceArg().getSpaceOrNull()?.safeCast<Rgb>()
            return space?.let {
                Color.hsv(
                    hue = pack.red.getFloat(),
                    saturation = pack.green.getFloat(),
                    value = pack.blue.getFloat(),
                    alpha = pack.alpha.getFloat(),
                    colorSpace = space,
                )
            }
        }

        override fun setNewColor(color: Color, factory: KtPsiFactory) {
            val argumentsPack = arguments.getPackedHSVA()
            val expressionsPack = factory.createNewFloatExpressionsPack(argumentsPack, color.getComponents().toHsv())
            runWriteAction { argumentsPack.replace(expressionsPack) }
        }
    }

    class Lerp(callExpression: KtCallExpression) : ColorFunction(callExpression) {
        override fun setNewColor(color: Color, factory: KtPsiFactory) = Unit
        override fun getColorInternal(): Color? {
            val (start, stop, fraction) = arguments.find(LERP_NAMES)
            val startColor = start?.getArgumentExpression()?.getColor()
            val stopColor = stop?.getArgumentExpression()?.getColor()
            val fractionFloat = fraction?.getFloat()

            return if (startColor != null && stopColor != null && fractionFloat != null) {
                lerp(startColor, stopColor, fractionFloat)
            } else {
                null
            }
        }
    }

    class Convert(callExpression: KtCallExpression) : ColorFunction(callExpression) {
        override fun setNewColor(color: Color, factory: KtPsiFactory) = Unit
        override fun getColorInternal(): Color? {
            val colorSpace = arguments.single().getSpaceOrNull()
            val receiverColor = callExpression.getParentReceiverColor()
            return if (receiverColor != null && colorSpace != null) {
                receiverColor.convert(colorSpace)
            } else {
                null
            }
        }
    }

    class CompositeOver(callExpression: KtCallExpression) : ColorFunction(callExpression) {
        override fun setNewColor(color: Color, factory: KtPsiFactory) = Unit
        override fun getColorInternal(): Color? {
            val argumentColor = arguments.single().getArgumentExpression()?.getColor()
            val receiverColor = callExpression.getParentReceiverColor()
            return if (receiverColor != null && argumentColor != null) {
                receiverColor.compositeOver(argumentColor)
            } else {
                null
            }
        }
    }

    class Copy(callExpression: KtCallExpression) : ColorFunction(callExpression) {
        override fun setNewColor(color: Color, factory: KtPsiFactory) = Unit
        override fun getColorInternal(): Color? {
            val (alpha, red, green, blue) = arguments.find(ARGB_NAMES).map { it?.getFloat() }
            val receiverColor = callExpression.getParentReceiverColor()

            return receiverColor
                ?.modifyIfNotNull(alpha) { copy(alpha = it) }
                ?.modifyIfNotNull(red) { copy(red = it) }
                ?.modifyIfNotNull(green) { copy(green = it) }
                ?.modifyIfNotNull(blue) { copy(blue = it) }
        }
    }
}