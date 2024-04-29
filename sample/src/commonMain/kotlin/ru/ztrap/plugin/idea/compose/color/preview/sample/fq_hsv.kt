@file:Suppress("RemoveRedundantQualifierName", "unused", "UNUSED_VARIABLE", "UNREACHABLE_CODE", "UNUSED_PARAMETER")

package ru.ztrap.plugin.idea.compose.color.preview.sample

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.hsv
import androidx.compose.ui.graphics.colorspace.ColorSpaces

//region hsvKtPropertyAccessor
//region KtDotQualifiedExpression
val hsvP1 get() = Color.hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f)
val hsvP2 get() = Color.hsv(hue = 240.0f, 0.7f, value = 0.6f)
val hsvP3 get() = Color.hsv(240.0f, 0.7f, 0.6f)

val hsvP4 get() = Color.hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, alpha = 1f)
val hsvP5 get() = Color.hsv(hue = 240.0f, 0.7f, value = 0.6f, alpha = 1f)
val hsvP6 get() = Color.hsv(240.0f, 0.7f, 0.6f, 1f)

val hsvP7 get() = Color.hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, colorSpace = ColorSpaces.Srgb)
val hsvP8 get() = Color.hsv(hue = 240.0f, 0.7f, value = 0.6f, colorSpace = ColorSpaces.Srgb)

val hsvP9 get() = Color.hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
val hsvP10 get() = Color.hsv(hue = 240.0f, 0.7f, value = 0.6f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
val hsvP11 get() = Color.hsv(240.0f, 0.7f, 0.6f, 1f, ColorSpaces.Srgb)
//endregion

//region KtCallExpression
val hsvP12 get() = hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f)
val hsvP13 get() = hsv(hue = 240.0f, 0.7f, value = 0.6f)
val hsvP14 get() = hsv(240.0f, 0.7f, 0.6f)

val hsvP15 get() = hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, alpha = 1f)
val hsvP16 get() = hsv(hue = 240.0f, 0.7f, value = 0.6f, alpha = 1f)
val hsvP17 get() = hsv(240.0f, 0.7f, 0.6f, 1f)

val hsvP18 get() = hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, colorSpace = ColorSpaces.Srgb)
val hsvP19 get() = hsv(hue = 240.0f, 0.7f, value = 0.6f, colorSpace = ColorSpaces.Srgb)

val hsvP20 get() = hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
val hsvP21 get() = hsv(hue = 240.0f, 0.7f, value = 0.6f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
val hsvP22 get() = hsv(240.0f, 0.7f, 0.6f, 1f, ColorSpaces.Srgb)
//endregion
//endregion

fun hsvKtBlockExpression() {
    //region KtDotQualifiedExpression
    Color.hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f)
    Color.hsv(hue = 240.0f, 0.7f, value = 0.6f)
    Color.hsv(240.0f, 0.7f, 0.6f)

    Color.hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, alpha = 1f)
    Color.hsv(hue = 240.0f, 0.7f, value = 0.6f, alpha = 1f)
    Color.hsv(240.0f, 0.7f, 0.6f, 1f)

    Color.hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, colorSpace = ColorSpaces.Srgb)
    Color.hsv(hue = 240.0f, 0.7f, value = 0.6f, colorSpace = ColorSpaces.Srgb)

    Color.hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
    Color.hsv(hue = 240.0f, 0.7f, value = 0.6f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
    Color.hsv(240.0f, 0.7f, 0.6f, 1f, ColorSpaces.Srgb)
    //endregion

    //region KtCallExpression
    hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f)
    hsv(hue = 240.0f, 0.7f, value = 0.6f)
    hsv(240.0f, 0.7f, 0.6f)

    hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, alpha = 1f)
    hsv(hue = 240.0f, 0.7f, value = 0.6f, alpha = 1f)
    hsv(240.0f, 0.7f, 0.6f, 1f)

    hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, colorSpace = ColorSpaces.Srgb)
    hsv(hue = 240.0f, 0.7f, value = 0.6f, colorSpace = ColorSpaces.Srgb)

    hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
    hsv(hue = 240.0f, 0.7f, value = 0.6f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
    hsv(240.0f, 0.7f, 0.6f, 1f, ColorSpaces.Srgb)
    //endregion
}

fun hsvKtProperty() {
    //region KtDotQualifiedExpression
    val p1 = Color.hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f)
    val p2 = Color.hsv(hue = 240.0f, 0.7f, value = 0.6f)
    val p3 = Color.hsv(240.0f, 0.7f, 0.6f)

    val p4 = Color.hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, alpha = 1f)
    val p5 = Color.hsv(hue = 240.0f, 0.7f, value = 0.6f, alpha = 1f)
    val p6 = Color.hsv(240.0f, 0.7f, 0.6f, 1f)

    val p7 = Color.hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, colorSpace = ColorSpaces.Srgb)
    val p8 = Color.hsv(hue = 240.0f, 0.7f, value = 0.6f, colorSpace = ColorSpaces.Srgb)

    val p9 = Color.hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
    val p10 = Color.hsv(hue = 240.0f, 0.7f, value = 0.6f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
    val p11 = Color.hsv(240.0f, 0.7f, 0.6f, 1f, ColorSpaces.Srgb)
    //endregion

    //region KtCallExpression
    val p12 = hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f)
    val p13 = hsv(hue = 240.0f, 0.7f, value = 0.6f)
    val p14 = hsv(240.0f, 0.7f, 0.6f)

    val p15 = hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, alpha = 1f)
    val p16 = hsv(hue = 240.0f, 0.7f, value = 0.6f, alpha = 1f)
    val p17 = hsv(240.0f, 0.7f, 0.6f, 1f)

    val p18 = hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, colorSpace = ColorSpaces.Srgb)
    val p19 = hsv(hue = 240.0f, 0.7f, value = 0.6f, colorSpace = ColorSpaces.Srgb)

    val p20 = hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
    val p21 = hsv(hue = 240.0f, 0.7f, value = 0.6f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
    val p22 = hsv(240.0f, 0.7f, 0.6f, 1f, ColorSpaces.Srgb)
    //endregion
}

fun hsvKtParameter(
    //region KtDotQualifiedExpression
    p1: Color = Color.hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f),
    p2: Color = Color.hsv(hue = 240.0f, 0.7f, value = 0.6f),
    p3: Color = Color.hsv(240.0f, 0.7f, 0.6f),

    p4: Color = Color.hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, alpha = 1f),
    p5: Color = Color.hsv(hue = 240.0f, 0.7f, value = 0.6f, alpha = 1f),
    p6: Color = Color.hsv(240.0f, 0.7f, 0.6f, 1f),

    p7: Color = Color.hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, colorSpace = ColorSpaces.Srgb),
    p8: Color = Color.hsv(hue = 240.0f, 0.7f, value = 0.6f, colorSpace = ColorSpaces.Srgb),

    p9: Color = Color.hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, alpha = 1f, colorSpace = ColorSpaces.Srgb),
    p10: Color = Color.hsv(hue = 240.0f, 0.7f, value = 0.6f, alpha = 1f, colorSpace = ColorSpaces.Srgb),
    p11: Color = Color.hsv(240.0f, 0.7f, 0.6f, 1f, ColorSpaces.Srgb),
    //endregion

    //region KtCallExpression
    p12: Color = hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f),
    p13: Color = hsv(hue = 240.0f, 0.7f, value = 0.6f),
    p14: Color = hsv(240.0f, 0.7f, 0.6f),

    p15: Color = hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, alpha = 1f),
    p16: Color = hsv(hue = 240.0f, 0.7f, value = 0.6f, alpha = 1f),
    p17: Color = hsv(240.0f, 0.7f, 0.6f, 1f),

    p18: Color = hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, colorSpace = ColorSpaces.Srgb),
    p19: Color = hsv(hue = 240.0f, 0.7f, value = 0.6f, colorSpace = ColorSpaces.Srgb),

    p20: Color = hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, alpha = 1f, colorSpace = ColorSpaces.Srgb),
    p21: Color = hsv(hue = 240.0f, 0.7f, value = 0.6f, alpha = 1f, colorSpace = ColorSpaces.Srgb),
    p22: Color = hsv(240.0f, 0.7f, 0.6f, 1f, ColorSpaces.Srgb),
    //endregion
) = Unit

fun hsvKtValueArgumentName() = hsvKtParameter(
    //region KtDotQualifiedExpression
    p1 = hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f),
    p2 = hsv(hue = 240.0f, 0.7f, value = 0.6f),
    p3 = hsv(240.0f, 0.7f, 0.6f),

    p4 = hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, alpha = 1f),
    p5 = hsv(hue = 240.0f, 0.7f, value = 0.6f, alpha = 1f),
    p6 = hsv(240.0f, 0.7f, 0.6f, 1f),

    p7 = hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, colorSpace = ColorSpaces.Srgb),
    p8 = hsv(hue = 240.0f, 0.7f, value = 0.6f, colorSpace = ColorSpaces.Srgb),

    p9 = hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, alpha = 1f, colorSpace = ColorSpaces.Srgb),
    p10 = hsv(hue = 240.0f, 0.7f, value = 0.6f, alpha = 1f, colorSpace = ColorSpaces.Srgb),
    p11 = hsv(240.0f, 0.7f, 0.6f, 1f, ColorSpaces.Srgb),
    //endregion

    //region KtCallExpression
    p12 = hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f),
    p13 = hsv(hue = 240.0f, 0.7f, value = 0.6f),
    p14 = hsv(240.0f, 0.7f, 0.6f),

    p15 = hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, alpha = 1f),
    p16 = hsv(hue = 240.0f, 0.7f, value = 0.6f, alpha = 1f),
    p17 = hsv(240.0f, 0.7f, 0.6f, 1f),

    p18 = hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, colorSpace = ColorSpaces.Srgb),
    p19 = hsv(hue = 240.0f, 0.7f, value = 0.6f, colorSpace = ColorSpaces.Srgb),

    p20 = hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, alpha = 1f, colorSpace = ColorSpaces.Srgb),
    p21 = hsv(hue = 240.0f, 0.7f, value = 0.6f, alpha = 1f, colorSpace = ColorSpaces.Srgb),
    p22 = hsv(240.0f, 0.7f, 0.6f, 1f, ColorSpaces.Srgb),
    //endregion
)

fun hsvKtValueArgument() = hsvKtParameter(
    //region KtDotQualifiedExpression
    hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f),
    hsv(hue = 240.0f, 0.7f, value = 0.6f),
    hsv(240.0f, 0.7f, 0.6f),

    hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, alpha = 1f),
    hsv(hue = 240.0f, 0.7f, value = 0.6f, alpha = 1f),
    hsv(240.0f, 0.7f, 0.6f, 1f),

    hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, colorSpace = ColorSpaces.Srgb),
    hsv(hue = 240.0f, 0.7f, value = 0.6f, colorSpace = ColorSpaces.Srgb),

    hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, alpha = 1f, colorSpace = ColorSpaces.Srgb),
    hsv(hue = 240.0f, 0.7f, value = 0.6f, alpha = 1f, colorSpace = ColorSpaces.Srgb),
    hsv(240.0f, 0.7f, 0.6f, 1f, ColorSpaces.Srgb),
    //endregion

    //region KtCallExpression
    hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f),
    hsv(hue = 240.0f, 0.7f, value = 0.6f),
    hsv(240.0f, 0.7f, 0.6f),

    hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, alpha = 1f),
    hsv(hue = 240.0f, 0.7f, value = 0.6f, alpha = 1f),
    hsv(240.0f, 0.7f, 0.6f, 1f),

    hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, colorSpace = ColorSpaces.Srgb),
    hsv(hue = 240.0f, 0.7f, value = 0.6f, colorSpace = ColorSpaces.Srgb),

    hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, alpha = 1f, colorSpace = ColorSpaces.Srgb),
    hsv(hue = 240.0f, 0.7f, value = 0.6f, alpha = 1f, colorSpace = ColorSpaces.Srgb),
    hsv(240.0f, 0.7f, 0.6f, 1f, ColorSpaces.Srgb),
    //endregion
)

fun hsvKtReturnExpression(): Color {
    //region KtDotQualifiedExpression
    return Color.hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f)
    return Color.hsv(hue = 240.0f, 0.7f, value = 0.6f)
    return Color.hsv(240.0f, 0.7f, 0.6f)

    return Color.hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, alpha = 1f)
    return Color.hsv(hue = 240.0f, 0.7f, value = 0.6f, alpha = 1f)
    return Color.hsv(240.0f, 0.7f, 0.6f, 1f)

    return Color.hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, colorSpace = ColorSpaces.Srgb)
    return Color.hsv(hue = 240.0f, 0.7f, value = 0.6f, colorSpace = ColorSpaces.Srgb)

    return Color.hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
    return Color.hsv(hue = 240.0f, 0.7f, value = 0.6f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
    return Color.hsv(240.0f, 0.7f, 0.6f, 1f, ColorSpaces.Srgb)
    //endregion

    //region KtCallExpression
    return hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f)
    return hsv(hue = 240.0f, 0.7f, value = 0.6f)
    return hsv(240.0f, 0.7f, 0.6f)

    return hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, alpha = 1f)
    return hsv(hue = 240.0f, 0.7f, value = 0.6f, alpha = 1f)
    return hsv(240.0f, 0.7f, 0.6f, 1f)

    return hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, colorSpace = ColorSpaces.Srgb)
    return hsv(hue = 240.0f, 0.7f, value = 0.6f, colorSpace = ColorSpaces.Srgb)

    return hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
    return hsv(hue = 240.0f, 0.7f, value = 0.6f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
    return hsv(240.0f, 0.7f, 0.6f, 1f, ColorSpaces.Srgb)
    //endregion
}

fun hsvKtBinaryExpression() {
    //region KtDotQualifiedExpression
    null ?: Color.hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f)
    null ?: Color.hsv(hue = 240.0f, 0.7f, value = 0.6f)
    null ?: Color.hsv(240.0f, 0.7f, 0.6f)

    null ?: Color.hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, alpha = 1f)
    null ?: Color.hsv(hue = 240.0f, 0.7f, value = 0.6f, alpha = 1f)
    null ?: Color.hsv(240.0f, 0.7f, 0.6f, 1f)

    null ?: Color.hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, colorSpace = ColorSpaces.Srgb)
    null ?: Color.hsv(hue = 240.0f, 0.7f, value = 0.6f, colorSpace = ColorSpaces.Srgb)

    null ?: Color.hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
    null ?: Color.hsv(hue = 240.0f, 0.7f, value = 0.6f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
    null ?: Color.hsv(240.0f, 0.7f, 0.6f, 1f, ColorSpaces.Srgb)
    //endregion

    //region KtCallExpression
    null ?: hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f)
    null ?: hsv(hue = 240.0f, 0.7f, value = 0.6f)
    null ?: hsv(240.0f, 0.7f, 0.6f)

    null ?: hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, alpha = 1f)
    null ?: hsv(hue = 240.0f, 0.7f, value = 0.6f, alpha = 1f)
    null ?: hsv(240.0f, 0.7f, 0.6f, 1f)

    null ?: hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, colorSpace = ColorSpaces.Srgb)
    null ?: hsv(hue = 240.0f, 0.7f, value = 0.6f, colorSpace = ColorSpaces.Srgb)

    null ?: hsv(hue = 240.0f, saturation = 0.7f, value = 0.6f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
    null ?: hsv(hue = 240.0f, 0.7f, value = 0.6f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
    null ?: hsv(240.0f, 0.7f, 0.6f, 1f, ColorSpaces.Srgb)
    //endregion
}