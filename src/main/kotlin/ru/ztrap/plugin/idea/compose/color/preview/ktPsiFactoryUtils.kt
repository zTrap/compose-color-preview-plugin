package ru.ztrap.plugin.idea.compose.color.preview

import androidx.compose.ui.graphics.Color as ComposeColor
import java.awt.Color as AwtColor
import org.jetbrains.kotlin.psi.KtExpression
import org.jetbrains.kotlin.psi.KtPsiFactory
import org.jetbrains.kotlin.psi.KtValueArgument

internal fun KtPsiFactory.createNewIntExpressionsPack(
    pack: ColorsValueArgumentsPack,
    color: AwtColor,
): ColorsExpressionsPack {
    return when (pack) {
        is ColorsValueArgumentsPack.ARGB -> ColorsExpressionsPack.ARGB(
            red = createNewIntExpression(argument = pack.red, value = color.red),
            green = createNewIntExpression(argument = pack.green, value = color.green),
            blue = createNewIntExpression(argument = pack.blue, value = color.blue),
            alpha = createNewIntExpression(argument = pack.alpha, value = color.alpha),
        )

        is ColorsValueArgumentsPack.RGB -> ColorsExpressionsPack.RGB(
            red = createNewIntExpression(argument = pack.red, value = color.red),
            green = createNewIntExpression(argument = pack.green, value = color.green),
            blue = createNewIntExpression(argument = pack.blue, value = color.blue),
        )
    }
}

internal fun KtPsiFactory.createNewFloatExpressionsPack(
    pack: ColorsValueArgumentsPack,
    color: ComposeColor,
): ColorsExpressionsPack {
    return when (pack) {
        is ColorsValueArgumentsPack.ARGB -> ColorsExpressionsPack.ARGB(
            red = createNewFloatExpression(value = color.red),
            green = createNewFloatExpression(value = color.green),
            blue = createNewFloatExpression(value = color.blue),
            alpha = if (pack.alpha.isNamed()) {
                createNewFloatExpression(name = COMPOSE_ALPHA_ARG_NAME, value = color.alpha)
            } else {
                createNewFloatExpression(value = color.alpha)
            }
        )

        is ColorsValueArgumentsPack.RGB -> ColorsExpressionsPack.RGB(
            red = createNewFloatExpression(value = color.red),
            green = createNewFloatExpression(value = color.green),
            blue = createNewFloatExpression(value = color.blue),
        )
    }
}

internal fun KtPsiFactory.createNewULongExpression(argument: KtValueArgument, value: ULong): KtExpression {
    val argumentText = argument.lastChild.text

    val text = buildString {
        if (argumentText.startsWith(HEX_FORMAT_PREFIX, true)) {
            append(HEX_FORMAT_PREFIX)
            append(value.toString(HEX_FORMAT_RADIX))
        } else {
            append(value)
        }

        when {
            argumentText.endsWith("ul", true) -> append(argumentText.takeLast(2))
            argumentText.endsWith("u", true) -> append(argumentText.takeLast(1))
        }
    }
    return createExpression(text)
}

internal fun KtPsiFactory.createNewLongExpression(argument: KtValueArgument, value: Int): KtExpression {
    val argumentText = argument.lastChild.text

    val hex = argumentText.startsWith(HEX_FORMAT_PREFIX, true)

    val ulongValue = if (hex) {
        argumentText.substring(HEX_FORMAT_PREFIX.length).toULong(HEX_FORMAT_RADIX)
    } else {
        argumentText.toULong()
    }

    val result = ((ulongValue shr 32) shl 32) or value.toUInt().toULong()

    return if (hex) {
        createExpression("$HEX_FORMAT_PREFIX${result.toString(HEX_FORMAT_RADIX)}")
    } else {
        createExpression(result.toLong().toString())
    }
}

internal fun KtPsiFactory.createNewIntExpression(argument: KtValueArgument, value: Int): KtExpression {
    val argumentText = argument.lastChild.text

    val text = buildString {
        if (argumentText.startsWith(HEX_FORMAT_PREFIX, true)) {
            append(HEX_FORMAT_PREFIX)
            append(value.toUInt().toString(HEX_FORMAT_RADIX))
        } else {
            append(value)
        }
    }

    return createExpression(text)
}

internal fun KtPsiFactory.createAlphaIntArgument(name: String? = null, value: Int): KtValueArgument {
    val newValue = buildString {
        name?.let {
            append(it)
            append(" = ")
        }

        append(HEX_FORMAT_PREFIX)
        append(value.toUInt().toString(HEX_FORMAT_RADIX))
    }
    return createArgument(newValue)
}

internal fun KtPsiFactory.createAlphaFloatArgument(name: String? = null, value: Float): KtValueArgument {
    return createArgument(createFloatString(name, value))
}

private fun KtPsiFactory.createNewFloatExpression(name: String? = null, value: Float): KtExpression {
    return createExpression(createFloatString(name, value))
}

private fun createFloatString(name: String? = null, value: Float): String = buildString {
    name?.let {
        append(it)
        append(" = ")
    }
    append(value)
    append("f")
}