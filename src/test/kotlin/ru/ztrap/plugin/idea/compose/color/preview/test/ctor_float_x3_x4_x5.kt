@file:Suppress("RemoveRedundantQualifierName", "unused", "UNUSED_VARIABLE", "UNREACHABLE_CODE", "UNUSED_PARAMETER")

package ru.ztrap.plugin.idea.compose.color.preview.test

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.ColorSpaces

//region floatX3X4X5KtPropertyAccessor
val floatX3X4X5P1 get() = Color(red = 0.18039216f, green = 0.18039216f, blue = 0.6f, alpha = 1.0f, ColorSpaces.Srgb)
val floatX3X4X5P2 get() = Color(red = 0.18039216f, 0.18039216f, blue = 0.6f, 1.0f, ColorSpaces.Srgb)
val floatX3X4X5P3 get() = Color(0.18039216f, 0.18039216f, 0.6f, 1.0f, ColorSpaces.Srgb)

val floatX3X4X5P4 get() = Color(red = 0.18039216f, green = 0.18039216f, blue = 0.6f, alpha = 1.0f)
val floatX3X4X5P5 get() = Color(red = 0.18039216f, 0.18039216f, blue = 0.6f, 1.0f)
val floatX3X4X5P6 get() = Color(0.18039216f, 0.18039216f, 0.6f, 1.0f)

val floatX3X4X5P7 get() = Color(red = 0.18039216f, green = 0.18039216f, blue = 0.6f, colorSpace = ColorSpaces.Srgb)
val floatX3X4X5P8 get() = Color(red = 0.18039216f, 0.18039216f, blue = 0.6f, colorSpace = ColorSpaces.Srgb)

val floatX3X4X5P9 get() = Color(red = 0.18039216f, green = 0.18039216f, blue = 0.6f)
val floatX3X4X5P10 get() = Color(red = 0.18039216f, 0.18039216f, blue = 0.6f)
val floatX3X4X5P11 get() = Color(0.18039216f, 0.18039216f, 0.6f)
//endregion

fun floatX3X4X5KtBlockExpression() {
    Color(red = 0.18039216f, green = 0.18039216f, blue = 0.6f, alpha = 1.0f, ColorSpaces.Srgb)
    Color(red = 0.18039216f, 0.18039216f, blue = 0.6f, 1.0f, ColorSpaces.Srgb)
    Color(0.18039216f, 0.18039216f, 0.6f, 1.0f, ColorSpaces.Srgb)

    Color(red = 0.18039216f, green = 0.18039216f, blue = 0.6f, alpha = 1.0f)
    Color(red = 0.18039216f, 0.18039216f, blue = 0.6f, 1.0f)
    Color(0.18039216f, 0.18039216f, 0.6f, 1.0f)

    Color(red = 0.18039216f, green = 0.18039216f, blue = 0.6f, colorSpace = ColorSpaces.Srgb)
    Color(red = 0.18039216f, 0.18039216f, blue = 0.6f, colorSpace = ColorSpaces.Srgb)

    Color(red = 0.18039216f, green = 0.18039216f, blue = 0.6f)
    Color(red = 0.18039216f, 0.18039216f, blue = 0.6f)
    Color(0.18039216f, 0.18039216f, 0.6f)
}

fun floatX3X4X5KtProperty() {
    val p1 = Color(red = 0.18039216f, green = 0.18039216f, blue = 0.6f, alpha = 1.0f, ColorSpaces.Srgb)
    val p2 = Color(red = 0.18039216f, 0.18039216f, blue = 0.6f, 1.0f, ColorSpaces.Srgb)
    val p3 = Color(0.18039216f, 0.18039216f, 0.6f, 1.0f, ColorSpaces.Srgb)

    val p4 = Color(red = 0.18039216f, green = 0.18039216f, blue = 0.6f, alpha = 1.0f)
    val p5 = Color(red = 0.18039216f, 0.18039216f, blue = 0.6f, 1.0f)
    val p6 = Color(0.18039216f, 0.18039216f, 0.6f, 1.0f)

    val p7 = Color(red = 0.18039216f, green = 0.18039216f, blue = 0.6f, colorSpace = ColorSpaces.Srgb)
    val p8 = Color(red = 0.18039216f, 0.18039216f, blue = 0.6f, colorSpace = ColorSpaces.Srgb)

    val p9 = Color(red = 0.18039216f, green = 0.18039216f, blue = 0.6f)
    val p10 = Color(red = 0.18039216f, 0.18039216f, blue = 0.6f)
    val p11 = Color(0.18039216f, 0.18039216f, 0.6f)
}

fun floatX3X4X5KtParameter(
    p1: Color = Color(red = 0.18039216f, green = 0.18039216f, blue = 0.6f, alpha = 1.0f, ColorSpaces.Srgb),
    p2: Color = Color(red = 0.18039216f, 0.18039216f, blue = 0.6f, 1.0f, ColorSpaces.Srgb),
    p3: Color = Color(0.18039216f, 0.18039216f, 0.6f, 1.0f, ColorSpaces.Srgb),

    p4: Color = Color(red = 0.18039216f, green = 0.18039216f, blue = 0.6f, alpha = 1.0f),
    p5: Color = Color(red = 0.18039216f, 0.18039216f, blue = 0.6f, 1.0f),
    p6: Color = Color(0.18039216f, 0.18039216f, 0.6f, 1.0f),

    p7: Color = Color(red = 0.18039216f, green = 0.18039216f, blue = 0.6f, colorSpace = ColorSpaces.Srgb),
    p8: Color = Color(red = 0.18039216f, 0.18039216f, blue = 0.6f, colorSpace = ColorSpaces.Srgb),

    p9: Color = Color(red = 0.18039216f, green = 0.18039216f, blue = 0.6f),
    p10: Color = Color(red = 0.18039216f, 0.18039216f, blue = 0.6f),
    p11: Color = Color(0.18039216f, 0.18039216f, 0.6f),
) = Unit

fun floatX3X4X5KtValueArgumentName() = floatX3X4X5KtParameter(
    p1 = Color(red = 0.18039216f, green = 0.18039216f, blue = 0.6f, alpha = 1.0f, ColorSpaces.Srgb),
    p2 = Color(red = 0.18039216f, 0.18039216f, blue = 0.6f, 1.0f, ColorSpaces.Srgb),
    p3 = Color(0.18039216f, 0.18039216f, 0.6f, 1.0f, ColorSpaces.Srgb),

    p4 = Color(red = 0.18039216f, green = 0.18039216f, blue = 0.6f, alpha = 1.0f),
    p5 = Color(red = 0.18039216f, 0.18039216f, blue = 0.6f, 1.0f),
    p6 = Color(0.18039216f, 0.18039216f, 0.6f, 1.0f),

    p7 = Color(red = 0.18039216f, green = 0.18039216f, blue = 0.6f, colorSpace = ColorSpaces.Srgb),
    p8 = Color(red = 0.18039216f, 0.18039216f, blue = 0.6f, colorSpace = ColorSpaces.Srgb),

    p9 = Color(red = 0.18039216f, green = 0.18039216f, blue = 0.6f),
    p10 = Color(red = 0.18039216f, 0.18039216f, blue = 0.6f),
    p11 = Color(0.18039216f, 0.18039216f, 0.6f),
)

fun floatX3X4X5KtValueArgument() = floatX3X4X5KtParameter(
    Color(red = 0.18039216f, green = 0.18039216f, blue = 0.6f, alpha = 1.0f, ColorSpaces.Srgb),
    Color(red = 0.18039216f, 0.18039216f, blue = 0.6f, 1.0f, ColorSpaces.Srgb),
    Color(0.18039216f, 0.18039216f, 0.6f, 1.0f, ColorSpaces.Srgb),

    Color(red = 0.18039216f, green = 0.18039216f, blue = 0.6f, alpha = 1.0f),
    Color(red = 0.18039216f, 0.18039216f, blue = 0.6f, 1.0f),
    Color(0.18039216f, 0.18039216f, 0.6f, 1.0f),

    Color(red = 0.18039216f, green = 0.18039216f, blue = 0.6f, colorSpace = ColorSpaces.Srgb),
    Color(red = 0.18039216f, 0.18039216f, blue = 0.6f, colorSpace = ColorSpaces.Srgb),

    Color(red = 0.18039216f, green = 0.18039216f, blue = 0.6f),
    Color(red = 0.18039216f, 0.18039216f, blue = 0.6f),
    Color(0.18039216f, 0.18039216f, 0.6f),
)

fun floatX3X4X5KtReturnExpression(): Color {
    return Color(red = 0.18039216f, green = 0.18039216f, blue = 0.6f, alpha = 1.0f, ColorSpaces.Srgb)
    return Color(red = 0.18039216f, 0.18039216f, blue = 0.6f, 1.0f, ColorSpaces.Srgb)
    return Color(0.18039216f, 0.18039216f, 0.6f, 1.0f, ColorSpaces.Srgb)

    return Color(red = 0.18039216f, green = 0.18039216f, blue = 0.6f, alpha = 1.0f)
    return Color(red = 0.18039216f, 0.18039216f, blue = 0.6f, 1.0f)
    return Color(0.18039216f, 0.18039216f, 0.6f, 1.0f)

    return Color(red = 0.18039216f, green = 0.18039216f, blue = 0.6f, colorSpace = ColorSpaces.Srgb)
    return Color(red = 0.18039216f, 0.18039216f, blue = 0.6f, colorSpace = ColorSpaces.Srgb)

    return Color(red = 0.18039216f, green = 0.18039216f, blue = 0.6f)
    return Color(red = 0.18039216f, 0.18039216f, blue = 0.6f)
    return Color(0.18039216f, 0.18039216f, 0.6f)
}

fun floatX3X4X5KtBinaryExpression() {
    null ?: Color(red = 0.18039216f, green = 0.18039216f, blue = 0.6f, alpha = 1.0f, ColorSpaces.Srgb)
    null ?: Color(red = 0.18039216f, 0.18039216f, blue = 0.6f, 1.0f, ColorSpaces.Srgb)
    null ?: Color(0.18039216f, 0.18039216f, 0.6f, 1.0f, ColorSpaces.Srgb)

    null ?: Color(red = 0.18039216f, green = 0.18039216f, blue = 0.6f, alpha = 1.0f)
    null ?: Color(red = 0.18039216f, 0.18039216f, blue = 0.6f, 1.0f)
    null ?: Color(0.18039216f, 0.18039216f, 0.6f, 1.0f)

    null ?: Color(red = 0.18039216f, green = 0.18039216f, blue = 0.6f, colorSpace = ColorSpaces.Srgb)
    null ?: Color(red = 0.18039216f, 0.18039216f, blue = 0.6f, colorSpace = ColorSpaces.Srgb)

    null ?: Color(red = 0.18039216f, green = 0.18039216f, blue = 0.6f)
    null ?: Color(red = 0.18039216f, 0.18039216f, blue = 0.6f)
    null ?: Color(0.18039216f, 0.18039216f, 0.6f)
}

