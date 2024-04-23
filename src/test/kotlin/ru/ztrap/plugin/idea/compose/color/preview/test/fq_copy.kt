@file:Suppress("RemoveRedundantQualifierName", "unused", "UNUSED_VARIABLE", "UNREACHABLE_CODE", "UNUSED_PARAMETER", "SameReturnValue")

package ru.ztrap.plugin.idea.compose.color.preview.test

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black

val copyC1 = Color.Black
val copyC2 = Black
val copyC3 = Color(0xff000000)

//region KtPropertyAccessor
val copyP1 get() = Color.Black.copy()
val copyP2 get() = Color.Black.copy(alpha = 0.5f)
val copyP3 get() = Color.Black.copy(0.5f)
val copyP4 get() = Color.Black.copy(alpha = 0.5f, red = 1f)
val copyP5 get() = Color.Black.copy(alpha = 0.5f, 1f)
val copyP6 get() = Color.Black.copy(0.5f, 1f)
val copyP7 get() = Color.Black.copy(alpha = 0.5f, red = 1f, green = 1f)
val copyP8 get() = Color.Black.copy(alpha = 0.5f, 1f, green = 1f)
val copyP9 get() = Color.Black.copy(0.5f, 1f, 1f)
val copyP10 get() = Color.Black.copy(alpha = 0.5f, red = 1f, green = 1f, blue = 1f)
val copyP11 get() = Color.Black.copy(alpha = 0.5f, 1f, green = 1f, 1f)
val copyP12 get() = Color.Black.copy(0.5f, 1f, 1f, 1f)

val copyP13 get() = Black.copy()
val copyP14 get() = Black.copy(alpha = 0.5f)
val copyP15 get() = Black.copy(0.5f)
val copyP16 get() = Black.copy(alpha = 0.5f, red = 1f)
val copyP17 get() = Black.copy(alpha = 0.5f, 1f)
val copyP18 get() = Black.copy(0.5f, 1f)
val copyP19 get() = Black.copy(alpha = 0.5f, red = 1f, green = 1f)
val copyP20 get() = Black.copy(alpha = 0.5f, 1f, green = 1f)
val copyP21 get() = Black.copy(0.5f, 1f, 1f)
val copyP22 get() = Black.copy(alpha = 0.5f, red = 1f, green = 1f, blue = 1f)
val copyP23 get() = Black.copy(alpha = 0.5f, 1f, green = 1f, 1f)
val copyP24 get() = Black.copy(0.5f, 1f, 1f, 1f)

val copyP25 get() = Color(0xff000000).copy()
val copyP26 get() = Color(0xff000000).copy(alpha = 0.5f)
val copyP27 get() = Color(0xff000000).copy(0.5f)
val copyP28 get() = Color(0xff000000).copy(alpha = 0.5f, red = 1f)
val copyP29 get() = Color(0xff000000).copy(alpha = 0.5f, 1f)
val copyP30 get() = Color(0xff000000).copy(0.5f, 1f)
val copyP31 get() = Color(0xff000000).copy(alpha = 0.5f, red = 1f, green = 1f)
val copyP32 get() = Color(0xff000000).copy(alpha = 0.5f, 1f, green = 1f)
val copyP33 get() = Color(0xff000000).copy(0.5f, 1f, 1f)
val copyP34 get() = Color(0xff000000).copy(alpha = 0.5f, red = 1f, green = 1f, blue = 1f)
val copyP35 get() = Color(0xff000000).copy(alpha = 0.5f, 1f, green = 1f, 1f)
val copyP36 get() = Color(0xff000000).copy(0.5f, 1f, 1f, 1f)
//endregion

fun copyKtBlockExpression() {
    Color.Black.copy()
    Color.Black.copy(alpha = 0.5f)
    Color.Black.copy(0.5f)
    Color.Black.copy(alpha = 0.5f, red = 1f)
    Color.Black.copy(alpha = 0.5f, 1f)
    Color.Black.copy(0.5f, 1f)
    Color.Black.copy(alpha = 0.5f, red = 1f, green = 1f)
    Color.Black.copy(alpha = 0.5f, 1f, green = 1f)
    Color.Black.copy(0.5f, 1f, 1f)
    Color.Black.copy(alpha = 0.5f, red = 1f, green = 1f, blue = 1f)
    Color.Black.copy(alpha = 0.5f, 1f, green = 1f, 1f)
    Color.Black.copy(0.5f, 1f, 1f, 1f)

    Black.copy()
    Black.copy(alpha = 0.5f)
    Black.copy(0.5f)
    Black.copy(alpha = 0.5f, red = 1f)
    Black.copy(alpha = 0.5f, 1f)
    Black.copy(0.5f, 1f)
    Black.copy(alpha = 0.5f, red = 1f, green = 1f)
    Black.copy(alpha = 0.5f, 1f, green = 1f)
    Black.copy(0.5f, 1f, 1f)
    Black.copy(alpha = 0.5f, red = 1f, green = 1f, blue = 1f)
    Black.copy(alpha = 0.5f, 1f, green = 1f, 1f)
    Black.copy(0.5f, 1f, 1f, 1f)

    Color(0xff000000).copy()
    Color(0xff000000).copy(alpha = 0.5f)
    Color(0xff000000).copy(0.5f)
    Color(0xff000000).copy(alpha = 0.5f, red = 1f)
    Color(0xff000000).copy(alpha = 0.5f, 1f)
    Color(0xff000000).copy(0.5f, 1f)
    Color(0xff000000).copy(alpha = 0.5f, red = 1f, green = 1f)
    Color(0xff000000).copy(alpha = 0.5f, 1f, green = 1f)
    Color(0xff000000).copy(0.5f, 1f, 1f)
    Color(0xff000000).copy(alpha = 0.5f, red = 1f, green = 1f, blue = 1f)
    Color(0xff000000).copy(alpha = 0.5f, 1f, green = 1f, 1f)
    Color(0xff000000).copy(0.5f, 1f, 1f, 1f)
}

fun copyKtProperty() {
    val p1 = Color.Black.copy()
    val p2 = Color.Black.copy(alpha = 0.5f)
    val p3 = Color.Black.copy(0.5f)
    val p4 = Color.Black.copy(alpha = 0.5f, red = 1f)
    val p5 = Color.Black.copy(alpha = 0.5f, 1f)
    val p6 = Color.Black.copy(0.5f, 1f)
    val p7 = Color.Black.copy(alpha = 0.5f, red = 1f, green = 1f)
    val p8 = Color.Black.copy(alpha = 0.5f, 1f, green = 1f)
    val p9 = Color.Black.copy(0.5f, 1f, 1f)
    val p10 = Color.Black.copy(alpha = 0.5f, red = 1f, green = 1f, blue = 1f)
    val p11 = Color.Black.copy(alpha = 0.5f, 1f, green = 1f, 1f)
    val p12 = Color.Black.copy(0.5f, 1f, 1f, 1f)

    val p13 = Black.copy()
    val p14 = Black.copy(alpha = 0.5f)
    val p15 = Black.copy(0.5f)
    val p16 = Black.copy(alpha = 0.5f, red = 1f)
    val p17 = Black.copy(alpha = 0.5f, 1f)
    val p18 = Black.copy(0.5f, 1f)
    val p19 = Black.copy(alpha = 0.5f, red = 1f, green = 1f)
    val p20 = Black.copy(alpha = 0.5f, 1f, green = 1f)
    val p21 = Black.copy(0.5f, 1f, 1f)
    val p22 = Black.copy(alpha = 0.5f, red = 1f, green = 1f, blue = 1f)
    val p23 = Black.copy(alpha = 0.5f, 1f, green = 1f, 1f)
    val p24 = Black.copy(0.5f, 1f, 1f, 1f)

    val p25 = Color(0xff000000).copy()
    val p26 = Color(0xff000000).copy(alpha = 0.5f)
    val p27 = Color(0xff000000).copy(0.5f)
    val p28 = Color(0xff000000).copy(alpha = 0.5f, red = 1f)
    val p29 = Color(0xff000000).copy(alpha = 0.5f, 1f)
    val p30 = Color(0xff000000).copy(0.5f, 1f)
    val p31 = Color(0xff000000).copy(alpha = 0.5f, red = 1f, green = 1f)
    val p32 = Color(0xff000000).copy(alpha = 0.5f, 1f, green = 1f)
    val p33 = Color(0xff000000).copy(0.5f, 1f, 1f)
    val p34 = Color(0xff000000).copy(alpha = 0.5f, red = 1f, green = 1f, blue = 1f)
    val p35 = Color(0xff000000).copy(alpha = 0.5f, 1f, green = 1f, 1f)
    val p36 = Color(0xff000000).copy(0.5f, 1f, 1f, 1f)
}

fun copyKtParameter(
    p1: Color = Color.Black.copy(),
    p2: Color = Color.Black.copy(alpha = 0.5f),
    p3: Color = Color.Black.copy(0.5f),
    p4: Color = Color.Black.copy(alpha = 0.5f, red = 1f),
    p5: Color = Color.Black.copy(alpha = 0.5f, 1f),
    p6: Color = Color.Black.copy(0.5f, 1f),
    p7: Color = Color.Black.copy(alpha = 0.5f, red = 1f, green = 1f),
    p8: Color = Color.Black.copy(alpha = 0.5f, 1f, green = 1f),
    p9: Color = Color.Black.copy(0.5f, 1f, 1f),
    p10: Color = Color.Black.copy(alpha = 0.5f, red = 1f, green = 1f, blue = 1f),
    p11: Color = Color.Black.copy(alpha = 0.5f, 1f, green = 1f, 1f),
    p12: Color = Color.Black.copy(0.5f, 1f, 1f, 1f),

    p13: Color = Black.copy(),
    p14: Color = Black.copy(alpha = 0.5f),
    p15: Color = Black.copy(0.5f),
    p16: Color = Black.copy(alpha = 0.5f, red = 1f),
    p17: Color = Black.copy(alpha = 0.5f, 1f),
    p18: Color = Black.copy(0.5f, 1f),
    p19: Color = Black.copy(alpha = 0.5f, red = 1f, green = 1f),
    p20: Color = Black.copy(alpha = 0.5f, 1f, green = 1f),
    p21: Color = Black.copy(0.5f, 1f, 1f),
    p22: Color = Black.copy(alpha = 0.5f, red = 1f, green = 1f, blue = 1f),
    p23: Color = Black.copy(alpha = 0.5f, 1f, green = 1f, 1f),
    p24: Color = Black.copy(0.5f, 1f, 1f, 1f),

    p25: Color = Color(0xff000000).copy(),
    p26: Color = Color(0xff000000).copy(alpha = 0.5f),
    p27: Color = Color(0xff000000).copy(0.5f),
    p28: Color = Color(0xff000000).copy(alpha = 0.5f, red = 1f),
    p29: Color = Color(0xff000000).copy(alpha = 0.5f, 1f),
    p30: Color = Color(0xff000000).copy(0.5f, 1f),
    p31: Color = Color(0xff000000).copy(alpha = 0.5f, red = 1f, green = 1f),
    p32: Color = Color(0xff000000).copy(alpha = 0.5f, 1f, green = 1f),
    p33: Color = Color(0xff000000).copy(0.5f, 1f, 1f),
    p34: Color = Color(0xff000000).copy(alpha = 0.5f, red = 1f, green = 1f, blue = 1f),
    p35: Color = Color(0xff000000).copy(alpha = 0.5f, 1f, green = 1f, 1f),
    p36: Color = Color(0xff000000).copy(0.5f, 1f, 1f, 1f),
) = Unit

fun copyKtValueArgumentName() = copyKtParameter(
    p1 = Black.copy(),
    p2 = Black.copy(alpha = 0.5f),
    p3 = Black.copy(0.5f),
    p4 = Black.copy(alpha = 0.5f, red = 1f),
    p5 = Black.copy(alpha = 0.5f, 1f),
    p6 = Black.copy(0.5f, 1f),
    p7 = Black.copy(alpha = 0.5f, red = 1f, green = 1f),
    p8 = Black.copy(alpha = 0.5f, 1f, green = 1f),
    p9 = Black.copy(0.5f, 1f, 1f),
    p10 = Black.copy(alpha = 0.5f, red = 1f, green = 1f, blue = 1f),
    p11 = Black.copy(alpha = 0.5f, 1f, green = 1f, 1f),
    p12 = Black.copy(0.5f, 1f, 1f, 1f),

    p13 = Black.copy(),
    p14 = Black.copy(alpha = 0.5f),
    p15 = Black.copy(0.5f),
    p16 = Black.copy(alpha = 0.5f, red = 1f),
    p17 = Black.copy(alpha = 0.5f, 1f),
    p18 = Black.copy(0.5f, 1f),
    p19 = Black.copy(alpha = 0.5f, red = 1f, green = 1f),
    p20 = Black.copy(alpha = 0.5f, 1f, green = 1f),
    p21 = Black.copy(0.5f, 1f, 1f),
    p22 = Black.copy(alpha = 0.5f, red = 1f, green = 1f, blue = 1f),
    p23 = Black.copy(alpha = 0.5f, 1f, green = 1f, 1f),
    p24 = Black.copy(0.5f, 1f, 1f, 1f),

    p25 = Color(0xff000000).copy(),
    p26 = Color(0xff000000).copy(alpha = 0.5f),
    p27 = Color(0xff000000).copy(0.5f),
    p28 = Color(0xff000000).copy(alpha = 0.5f, red = 1f),
    p29 = Color(0xff000000).copy(alpha = 0.5f, 1f),
    p30 = Color(0xff000000).copy(0.5f, 1f),
    p31 = Color(0xff000000).copy(alpha = 0.5f, red = 1f, green = 1f),
    p32 = Color(0xff000000).copy(alpha = 0.5f, 1f, green = 1f),
    p33 = Color(0xff000000).copy(0.5f, 1f, 1f),
    p34 = Color(0xff000000).copy(alpha = 0.5f, red = 1f, green = 1f, blue = 1f),
    p35 = Color(0xff000000).copy(alpha = 0.5f, 1f, green = 1f, 1f),
    p36 = Color(0xff000000).copy(0.5f, 1f, 1f, 1f),
)

fun copyKtValueArgument() = copyKtParameter(
    Black.copy(),
    Black.copy(alpha = 0.5f),
    Black.copy(0.5f),
    Black.copy(alpha = 0.5f, red = 1f),
    Black.copy(alpha = 0.5f, 1f),
    Black.copy(0.5f, 1f),
    Black.copy(alpha = 0.5f, red = 1f, green = 1f),
    Black.copy(alpha = 0.5f, 1f, green = 1f),
    Black.copy(0.5f, 1f, 1f),
    Black.copy(alpha = 0.5f, red = 1f, green = 1f, blue = 1f),
    Black.copy(alpha = 0.5f, 1f, green = 1f, 1f),
    Black.copy(0.5f, 1f, 1f, 1f),

    Black.copy(),
    Black.copy(alpha = 0.5f),
    Black.copy(0.5f),
    Black.copy(alpha = 0.5f, red = 1f),
    Black.copy(alpha = 0.5f, 1f),
    Black.copy(0.5f, 1f),
    Black.copy(alpha = 0.5f, red = 1f, green = 1f),
    Black.copy(alpha = 0.5f, 1f, green = 1f),
    Black.copy(0.5f, 1f, 1f),
    Black.copy(alpha = 0.5f, red = 1f, green = 1f, blue = 1f),
    Black.copy(alpha = 0.5f, 1f, green = 1f, 1f),
    Black.copy(0.5f, 1f, 1f, 1f),

    Color(0xff000000).copy(),
    Color(0xff000000).copy(alpha = 0.5f),
    Color(0xff000000).copy(0.5f),
    Color(0xff000000).copy(alpha = 0.5f, red = 1f),
    Color(0xff000000).copy(alpha = 0.5f, 1f),
    Color(0xff000000).copy(0.5f, 1f),
    Color(0xff000000).copy(alpha = 0.5f, red = 1f, green = 1f),
    Color(0xff000000).copy(alpha = 0.5f, 1f, green = 1f),
    Color(0xff000000).copy(0.5f, 1f, 1f),
    Color(0xff000000).copy(alpha = 0.5f, red = 1f, green = 1f, blue = 1f),
    Color(0xff000000).copy(alpha = 0.5f, 1f, green = 1f, 1f),
    Color(0xff000000).copy(0.5f, 1f, 1f, 1f),
)

fun copyKtReturnExpression(): Color {
    return Color.Black.copy()
    return Color.Black.copy(alpha = 0.5f)
    return Color.Black.copy(0.5f)
    return Color.Black.copy(alpha = 0.5f, red = 1f)
    return Color.Black.copy(alpha = 0.5f, 1f)
    return Color.Black.copy(0.5f, 1f)
    return Color.Black.copy(alpha = 0.5f, red = 1f, green = 1f)
    return Color.Black.copy(alpha = 0.5f, 1f, green = 1f)
    return Color.Black.copy(0.5f, 1f, 1f)
    return Color.Black.copy(alpha = 0.5f, red = 1f, green = 1f, blue = 1f)
    return Color.Black.copy(alpha = 0.5f, 1f, green = 1f, 1f)
    return Color.Black.copy(0.5f, 1f, 1f, 1f)

    return Black.copy()
    return Black.copy(alpha = 0.5f)
    return Black.copy(0.5f)
    return Black.copy(alpha = 0.5f, red = 1f)
    return Black.copy(alpha = 0.5f, 1f)
    return Black.copy(0.5f, 1f)
    return Black.copy(alpha = 0.5f, red = 1f, green = 1f)
    return Black.copy(alpha = 0.5f, 1f, green = 1f)
    return Black.copy(0.5f, 1f, 1f)
    return Black.copy(alpha = 0.5f, red = 1f, green = 1f, blue = 1f)
    return Black.copy(alpha = 0.5f, 1f, green = 1f, 1f)
    return Black.copy(0.5f, 1f, 1f, 1f)

    return Color(0xff000000).copy()
    return Color(0xff000000).copy(alpha = 0.5f)
    return Color(0xff000000).copy(0.5f)
    return Color(0xff000000).copy(alpha = 0.5f, red = 1f)
    return Color(0xff000000).copy(alpha = 0.5f, 1f)
    return Color(0xff000000).copy(0.5f, 1f)
    return Color(0xff000000).copy(alpha = 0.5f, red = 1f, green = 1f)
    return Color(0xff000000).copy(alpha = 0.5f, 1f, green = 1f)
    return Color(0xff000000).copy(0.5f, 1f, 1f)
    return Color(0xff000000).copy(alpha = 0.5f, red = 1f, green = 1f, blue = 1f)
    return Color(0xff000000).copy(alpha = 0.5f, 1f, green = 1f, 1f)
    return Color(0xff000000).copy(0.5f, 1f, 1f, 1f)
}

fun copyKtBinaryExpression() {
    null ?: Color.Black.copy()
    null ?: Color.Black.copy(alpha = 0.5f)
    null ?: Color.Black.copy(0.5f)
    null ?: Color.Black.copy(alpha = 0.5f, red = 1f)
    null ?: Color.Black.copy(alpha = 0.5f, 1f)
    null ?: Color.Black.copy(0.5f, 1f)
    null ?: Color.Black.copy(alpha = 0.5f, red = 1f, green = 1f)
    null ?: Color.Black.copy(alpha = 0.5f, 1f, green = 1f)
    null ?: Color.Black.copy(0.5f, 1f, 1f)
    null ?: Color.Black.copy(alpha = 0.5f, red = 1f, green = 1f, blue = 1f)
    null ?: Color.Black.copy(alpha = 0.5f, 1f, green = 1f, 1f)
    null ?: Color.Black.copy(0.5f, 1f, 1f, 1f)

    null ?: Black.copy()
    null ?: Black.copy(alpha = 0.5f)
    null ?: Black.copy(0.5f)
    null ?: Black.copy(alpha = 0.5f, red = 1f)
    null ?: Black.copy(alpha = 0.5f, 1f)
    null ?: Black.copy(0.5f, 1f)
    null ?: Black.copy(alpha = 0.5f, red = 1f, green = 1f)
    null ?: Black.copy(alpha = 0.5f, 1f, green = 1f)
    null ?: Black.copy(0.5f, 1f, 1f)
    null ?: Black.copy(alpha = 0.5f, red = 1f, green = 1f, blue = 1f)
    null ?: Black.copy(alpha = 0.5f, 1f, green = 1f, 1f)
    null ?: Black.copy(0.5f, 1f, 1f, 1f)

    null ?: Color(0xff000000).copy()
    null ?: Color(0xff000000).copy(alpha = 0.5f)
    null ?: Color(0xff000000).copy(0.5f)
    null ?: Color(0xff000000).copy(alpha = 0.5f, red = 1f)
    null ?: Color(0xff000000).copy(alpha = 0.5f, 1f)
    null ?: Color(0xff000000).copy(0.5f, 1f)
    null ?: Color(0xff000000).copy(alpha = 0.5f, red = 1f, green = 1f)
    null ?: Color(0xff000000).copy(alpha = 0.5f, 1f, green = 1f)
    null ?: Color(0xff000000).copy(0.5f, 1f, 1f)
    null ?: Color(0xff000000).copy(alpha = 0.5f, red = 1f, green = 1f, blue = 1f)
    null ?: Color(0xff000000).copy(alpha = 0.5f, 1f, green = 1f, 1f)
    null ?: Color(0xff000000).copy(0.5f, 1f, 1f, 1f)
}