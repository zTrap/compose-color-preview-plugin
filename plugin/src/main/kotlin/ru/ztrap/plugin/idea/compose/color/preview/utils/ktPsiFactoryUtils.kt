package ru.ztrap.plugin.idea.compose.color.preview.utils

import com.intellij.openapi.application.runReadAction
import org.jetbrains.kotlin.psi.KtExpression
import org.jetbrains.kotlin.psi.KtPsiFactory
import org.jetbrains.kotlin.psi.KtValueArgument
import ru.ztrap.plugin.idea.compose.color.preview.ColorsExpressionsPack
import ru.ztrap.plugin.idea.compose.color.preview.ColorsValueArgumentsPack

internal fun KtPsiFactory.createNewIntExpressionsPack(
    pack: ColorsValueArgumentsPack,
    colorComponents: FloatArray,
): ColorsExpressionsPack {
    val (red, green, blue, alpha) = colorComponents
    return when (pack) {
        is ColorsValueArgumentsPack.ARGB -> ColorsExpressionsPack.ARGB(
            red = createNewIntExpression(argument = pack.red, value = red),
            green = createNewIntExpression(argument = pack.green, value = green),
            blue = createNewIntExpression(argument = pack.blue, value = blue),
            alpha = createNewIntExpression(argument = pack.alpha, value = alpha),
        )

        is ColorsValueArgumentsPack.RGB -> ColorsExpressionsPack.RGB(
            red = createNewIntExpression(argument = pack.red, value = red),
            green = createNewIntExpression(argument = pack.green, value = green),
            blue = createNewIntExpression(argument = pack.blue, value = blue),
        )
    }
}

internal fun KtPsiFactory.createNewFloatExpressionsPack(
    pack: ColorsValueArgumentsPack,
    colorComponents: FloatArray,
): ColorsExpressionsPack {
    val (red, green, blue, alpha) = colorComponents
    return when (pack) {
        is ColorsValueArgumentsPack.ARGB -> ColorsExpressionsPack.ARGB(
            red = createNewFloatExpression(value = red),
            green = createNewFloatExpression(value = green),
            blue = createNewFloatExpression(value = blue),
            alpha = createNewFloatExpression(value = alpha),
        )

        is ColorsValueArgumentsPack.RGB -> ColorsExpressionsPack.RGB(
            red = createNewFloatExpression(value = red),
            green = createNewFloatExpression(value = green),
            blue = createNewFloatExpression(value = blue),
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
    return createExpressionInReadAction(text)
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
        createExpressionInReadAction(HEX_FORMAT.format(result.toLong()))
    } else {
        createExpressionInReadAction(result.toLong().toString())
    }
}

internal fun KtPsiFactory.createNewIntExpression(argument: KtValueArgument, value: Float): KtExpression {
    return createNewIntExpression(argument, fractionToHex(value))
}

internal fun KtPsiFactory.createNewIntExpression(argument: KtValueArgument, value: Int): KtExpression {
    val argumentText = argument.lastChild.text

    val text = if (argumentText.startsWith(HEX_FORMAT_PREFIX, true)) {
        HEX_FORMAT.format(value)
    } else {
        value.toString()
    }

    return createExpressionInReadAction(text)
}

internal fun KtPsiFactory.createAlphaIntArgument(value: Float): KtValueArgument {
    return createArgumentInReadAction(createIntString(COMPOSE_ARG_NAME_ALPHA, value))
}

internal fun KtPsiFactory.createIntArgument(value: Float): KtValueArgument {
    return createArgumentInReadAction(createIntString(value = value))
}

internal fun KtPsiFactory.createAlphaFloatArgument(value: Float): KtValueArgument {
    return createArgumentInReadAction(createFloatString(COMPOSE_ARG_NAME_ALPHA, value))
}

internal fun KtPsiFactory.createFloatArgument(value: Float): KtValueArgument {
    return createArgumentInReadAction(createFloatString(value = value))
}

private fun KtPsiFactory.createNewFloatExpression(name: String? = null, value: Float): KtExpression {
    return createExpressionInReadAction(createFloatString(name, value))
}

private fun createFloatString(name: String? = null, value: Float): String = buildString {
    name?.let {
        append(it)
        append(" = ")
    }
    append(value)
    append("f")
}

private fun createIntString(name: String? = null, value: Float): String = buildString {
    name?.let {
        append(it)
        append(" = ")
    }
    append(HEX_FORMAT_PREFIX)
    append(fractionToHex(value).toUInt().toString(HEX_FORMAT_RADIX))
}

private fun KtPsiFactory.createExpressionInReadAction(text: String): KtExpression {
    return runReadAction { createExpression(text) }
}

private fun KtPsiFactory.createArgumentInReadAction(text: String): KtValueArgument {
    return runReadAction { createArgument(text) }
}