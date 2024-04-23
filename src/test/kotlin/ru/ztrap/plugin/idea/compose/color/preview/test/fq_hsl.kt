@file:Suppress("RemoveRedundantQualifierName", "unused", "UNUSED_VARIABLE", "UNREACHABLE_CODE", "UNUSED_PARAMETER")

package ru.ztrap.plugin.idea.compose.color.preview.test

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.hsl
import androidx.compose.ui.graphics.colorspace.ColorSpaces

//region hslKtPropertyAccessor
//region KtDotQualifiedExpression
val hslP1 get() = Color.hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f)
val hslP2 get() = Color.hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f)
val hslP3 get() = Color.hsl(240.0f, 0.69458133f, 0.6019608f)

val hslP4 get() = Color.hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, alpha = 1f)
val hslP5 get() = Color.hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, alpha = 1f)
val hslP6 get() = Color.hsl(240.0f, 0.69458133f, 0.6019608f, 1f)

val hslP7 get() = Color.hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, colorSpace = ColorSpaces.Srgb)
val hslP8 get() = Color.hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, colorSpace = ColorSpaces.Srgb)

val hslP9 get() = Color.hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
val hslP10 get() = Color.hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
val hslP11 get() = Color.hsl(240.0f, 0.69458133f, 0.6019608f, 1f, ColorSpaces.Srgb)
//endregion

//region KtCallExpression
val hslP12 get() = hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f)
val hslP13 get() = hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f)
val hslP14 get() = hsl(240.0f, 0.69458133f, 0.6019608f)

val hslP15 get() = hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, alpha = 1f)
val hslP16 get() = hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, alpha = 1f)
val hslP17 get() = hsl(240.0f, 0.69458133f, 0.6019608f, 1f)

val hslP18 get() = hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, colorSpace = ColorSpaces.Srgb)
val hslP19 get() = hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, colorSpace = ColorSpaces.Srgb)

val hslP20 get() = hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
val hslP21 get() = hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
val hslP22 get() = hsl(240.0f, 0.69458133f, 0.6019608f, 1f, ColorSpaces.Srgb)
//endregion
//endregion

fun hslKtBlockExpression() {
    //region KtDotQualifiedExpression
    Color.hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f)
    Color.hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f)
    Color.hsl(240.0f, 0.69458133f, 0.6019608f)

    Color.hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, alpha = 1f)
    Color.hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, alpha = 1f)
    Color.hsl(240.0f, 0.69458133f, 0.6019608f, 1f)

    Color.hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, colorSpace = ColorSpaces.Srgb)
    Color.hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, colorSpace = ColorSpaces.Srgb)

    Color.hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
    Color.hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
    Color.hsl(240.0f, 0.69458133f, 0.6019608f, 1f, ColorSpaces.Srgb)
    //endregion

    //region KtCallExpression
    hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f)
    hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f)
    hsl(240.0f, 0.69458133f, 0.6019608f)

    hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, alpha = 1f)
    hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, alpha = 1f)
    hsl(240.0f, 0.69458133f, 0.6019608f, 1f)

    hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, colorSpace = ColorSpaces.Srgb)
    hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, colorSpace = ColorSpaces.Srgb)

    hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
    hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
    hsl(240.0f, 0.69458133f, 0.6019608f, 1f, ColorSpaces.Srgb)
    //endregion
}

fun hslKtProperty() {
    //region KtDotQualifiedExpression
    val p1 = Color.hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f)
    val p2 = Color.hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f)
    val p3 = Color.hsl(240.0f, 0.69458133f, 0.6019608f)

    val p4 = Color.hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, alpha = 1f)
    val p5 = Color.hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, alpha = 1f)
    val p6 = Color.hsl(240.0f, 0.69458133f, 0.6019608f, 1f)

    val p7 = Color.hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, colorSpace = ColorSpaces.Srgb)
    val p8 = Color.hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, colorSpace = ColorSpaces.Srgb)

    val p9 = Color.hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
    val p10 = Color.hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
    val p11 = Color.hsl(240.0f, 0.69458133f, 0.6019608f, 1f, ColorSpaces.Srgb)
    //endregion

    //region KtCallExpression
    val p12 = hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f)
    val p13 = hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f)
    val p14 = hsl(240.0f, 0.69458133f, 0.6019608f)

    val p15 = hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, alpha = 1f)
    val p16 = hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, alpha = 1f)
    val p17 = hsl(240.0f, 0.69458133f, 0.6019608f, 1f)

    val p18 = hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, colorSpace = ColorSpaces.Srgb)
    val p19 = hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, colorSpace = ColorSpaces.Srgb)

    val p20 = hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
    val p21 = hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
    val p22 = hsl(240.0f, 0.69458133f, 0.6019608f, 1f, ColorSpaces.Srgb)
    //endregion
}

fun hslKtParameter(
    //region KtDotQualifiedExpression
    p1: Color = Color.hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f),
    p2: Color = Color.hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f),
    p3: Color = Color.hsl(240.0f, 0.69458133f, 0.6019608f),

    p4: Color = Color.hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, alpha = 1f),
    p5: Color = Color.hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, alpha = 1f),
    p6: Color = Color.hsl(240.0f, 0.69458133f, 0.6019608f, 1f),

    p7: Color = Color.hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, colorSpace = ColorSpaces.Srgb),
    p8: Color = Color.hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, colorSpace = ColorSpaces.Srgb),

    p9: Color = Color.hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, alpha = 1f, colorSpace = ColorSpaces.Srgb),
    p10: Color = Color.hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, alpha = 1f, colorSpace = ColorSpaces.Srgb),
    p11: Color = Color.hsl(240.0f, 0.69458133f, 0.6019608f, 1f, ColorSpaces.Srgb),
    //endregion

    //region KtCallExpression
    p12: Color = hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f),
    p13: Color = hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f),
    p14: Color = hsl(240.0f, 0.69458133f, 0.6019608f),

    p15: Color = hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, alpha = 1f),
    p16: Color = hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, alpha = 1f),
    p17: Color = hsl(240.0f, 0.69458133f, 0.6019608f, 1f),

    p18: Color = hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, colorSpace = ColorSpaces.Srgb),
    p19: Color = hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, colorSpace = ColorSpaces.Srgb),

    p20: Color = hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, alpha = 1f, colorSpace = ColorSpaces.Srgb),
    p21: Color = hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, alpha = 1f, colorSpace = ColorSpaces.Srgb),
    p22: Color = hsl(240.0f, 0.69458133f, 0.6019608f, 1f, ColorSpaces.Srgb),
    //endregion
) = Unit

fun hslKtValueArgumentName() = hslKtParameter(
    //region KtDotQualifiedExpression
    p1 = hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f),
    p2 = hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f),
    p3 = hsl(240.0f, 0.69458133f, 0.6019608f),

    p4 = hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, alpha = 1f),
    p5 = hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, alpha = 1f),
    p6 = hsl(240.0f, 0.69458133f, 0.6019608f, 1f),

    p7 = hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, colorSpace = ColorSpaces.Srgb),
    p8 = hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, colorSpace = ColorSpaces.Srgb),

    p9 = hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, alpha = 1f, colorSpace = ColorSpaces.Srgb),
    p10 = hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, alpha = 1f, colorSpace = ColorSpaces.Srgb),
    p11 = hsl(240.0f, 0.69458133f, 0.6019608f, 1f, ColorSpaces.Srgb),
    //endregion

    //region KtCallExpression
    p12 = hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f),
    p13 = hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f),
    p14 = hsl(240.0f, 0.69458133f, 0.6019608f),

    p15 = hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, alpha = 1f),
    p16 = hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, alpha = 1f),
    p17 = hsl(240.0f, 0.69458133f, 0.6019608f, 1f),

    p18 = hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, colorSpace = ColorSpaces.Srgb),
    p19 = hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, colorSpace = ColorSpaces.Srgb),

    p20 = hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, alpha = 1f, colorSpace = ColorSpaces.Srgb),
    p21 = hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, alpha = 1f, colorSpace = ColorSpaces.Srgb),
    p22 = hsl(240.0f, 0.69458133f, 0.6019608f, 1f, ColorSpaces.Srgb),
    //endregion
)

fun hslKtValueArgument() = hslKtParameter(
    //region KtDotQualifiedExpression
    hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f),
    hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f),
    hsl(240.0f, 0.69458133f, 0.6019608f),

    hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, alpha = 1f),
    hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, alpha = 1f),
    hsl(240.0f, 0.69458133f, 0.6019608f, 1f),

    hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, colorSpace = ColorSpaces.Srgb),
    hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, colorSpace = ColorSpaces.Srgb),

    hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, alpha = 1f, colorSpace = ColorSpaces.Srgb),
    hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, alpha = 1f, colorSpace = ColorSpaces.Srgb),
    hsl(240.0f, 0.69458133f, 0.6019608f, 1f, ColorSpaces.Srgb),
    //endregion

    //region KtCallExpression
    hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f),
    hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f),
    hsl(240.0f, 0.69458133f, 0.6019608f),

    hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, alpha = 1f),
    hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, alpha = 1f),
    hsl(240.0f, 0.69458133f, 0.6019608f, 1f),

    hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, colorSpace = ColorSpaces.Srgb),
    hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, colorSpace = ColorSpaces.Srgb),

    hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, alpha = 1f, colorSpace = ColorSpaces.Srgb),
    hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, alpha = 1f, colorSpace = ColorSpaces.Srgb),
    hsl(240.0f, 0.69458133f, 0.6019608f, 1f, ColorSpaces.Srgb),
    //endregion
)

fun hslKtReturnExpression(): Color {
    //region KtDotQualifiedExpression
    return Color.hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f)
    return Color.hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f)
    return Color.hsl(240.0f, 0.69458133f, 0.6019608f)

    return Color.hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, alpha = 1f)
    return Color.hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, alpha = 1f)
    return Color.hsl(240.0f, 0.69458133f, 0.6019608f, 1f)

    return Color.hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, colorSpace = ColorSpaces.Srgb)
    return Color.hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, colorSpace = ColorSpaces.Srgb)

    return Color.hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
    return Color.hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
    return Color.hsl(240.0f, 0.69458133f, 0.6019608f, 1f, ColorSpaces.Srgb)
    //endregion

    //region KtCallExpression
    return hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f)
    return hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f)
    return hsl(240.0f, 0.69458133f, 0.6019608f)

    return hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, alpha = 1f)
    return hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, alpha = 1f)
    return hsl(240.0f, 0.69458133f, 0.6019608f, 1f)

    return hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, colorSpace = ColorSpaces.Srgb)
    return hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, colorSpace = ColorSpaces.Srgb)

    return hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
    return hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
    return hsl(240.0f, 0.69458133f, 0.6019608f, 1f, ColorSpaces.Srgb)
    //endregion
}

fun hslKtBinaryExpression() {
    //region KtDotQualifiedExpression
    null ?: Color.hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f)
    null ?: Color.hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f)
    null ?: Color.hsl(240.0f, 0.69458133f, 0.6019608f)

    null ?: Color.hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, alpha = 1f)
    null ?: Color.hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, alpha = 1f)
    null ?: Color.hsl(240.0f, 0.69458133f, 0.6019608f, 1f)

    null ?: Color.hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, colorSpace = ColorSpaces.Srgb)
    null ?: Color.hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, colorSpace = ColorSpaces.Srgb)

    null ?: Color.hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
    null ?: Color.hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
    null ?: Color.hsl(240.0f, 0.69458133f, 0.6019608f, 1f, ColorSpaces.Srgb)
    //endregion

    //region KtCallExpression
    null ?: hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f)
    null ?: hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f)
    null ?: hsl(240.0f, 0.69458133f, 0.6019608f)

    null ?: hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, alpha = 1f)
    null ?: hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, alpha = 1f)
    null ?: hsl(240.0f, 0.69458133f, 0.6019608f, 1f)

    null ?: hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, colorSpace = ColorSpaces.Srgb)
    null ?: hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, colorSpace = ColorSpaces.Srgb)

    null ?: hsl(hue = 240.0f, saturation = 0.69458133f, lightness = 0.6019608f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
    null ?: hsl(hue = 240.0f, 0.69458133f, lightness = 0.6019608f, alpha = 1f, colorSpace = ColorSpaces.Srgb)
    null ?: hsl(240.0f, 0.69458133f, 0.6019608f, 1f, ColorSpaces.Srgb)
    //endregion
}