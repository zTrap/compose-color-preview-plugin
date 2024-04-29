@file:Suppress("RemoveRedundantQualifierName", "unused", "UNUSED_VARIABLE", "UNREACHABLE_CODE", "UNUSED_PARAMETER")

package ru.ztrap.plugin.idea.compose.color.preview.sample

import androidx.compose.ui.graphics.Color

//region intLongULongKtPropertyAccessor
//region int
val intLongULongP1 get() = Color(color = 0xff2e2e99)
val intLongULongP2 get() = Color(0xff2e2e99)
val intLongULongP3 get() = Color(color = -13750631)
val intLongULongP4 get() = Color(-13750631)
//endregion

//region int
val intLongULongP5 get() = Color(color = 0xff2e2e99)
val intLongULongP6 get() = Color(0xff2e2e99)
val intLongULongP7 get() = Color(color = -13750631)
val intLongULongP8 get() = Color(-13750631)
//endregion

//region long
val intLongULongP9 get() = Color(color = 0xffffff2e2e99)
val intLongULongP10 get() = Color(0xffffff2e2e99)
val intLongULongP11 get() = Color(color = 281474962960025)
val intLongULongP12 get() = Color(281474962960025)
//endregion

//region ulong
val intLongULongP13 get() = Color(value = 0x2c5a29c23360ffceUL)
val intLongULongP14 get() = Color(0x2c5a29c23360ffceUL)
val intLongULongP15 get() = Color(value = 3195912799635177422UL)
val intLongULongP16 get() = Color(3195912799635177422UL)

val intLongULongP17 get() = Color(value = 0x2c5a29c23360ffceU)
val intLongULongP18 get() = Color(0x2c5a29c23360ffceU)
val intLongULongP19 get() = Color(value = 3195912799635177422U)
val intLongULongP20 get() = Color(3195912799635177422U)
//endregion
//endregion

fun intLongULongKtBlockExpression() {
    //region int
    Color(color = 0xff2e2e99)
    Color(0xff2e2e99)
    Color(color = -13750631)
    Color(-13750631)
    //endregion

    //region int
    Color(color = 0xff2e2e99)
    Color(0xff2e2e99)
    Color(color = -13750631)
    Color(-13750631)
    //endregion

    //region long
    Color(color = 0xffffff2e2e99)
    Color(0xffffff2e2e99)
    Color(color = 281474962960025)
    Color(281474962960025)
    //endregion

    //region ulong
    Color(value = 0x2c5a29c23360ffceUL)
    Color(0x2c5a29c23360ffceUL)
    Color(value = 3195912799635177422UL)
    Color(3195912799635177422UL)

    Color(value = 0x2c5a29c23360ffceU)
    Color(0x2c5a29c23360ffceU)
    Color(value = 3195912799635177422U)
    Color(3195912799635177422U)
    //endregion
}

fun intLongULongKtProperty() {
    //region int
    val p1 = Color(color = 0xff2e2e99)
    val p2 = Color(0xff2e2e99)
    val p3 = Color(color = -13750631)
    val p4 = Color(-13750631)
    //endregion

    //region long
    val p5 = Color(color = 0xffffff2e2e99)
    val p6 = Color(0xffffff2e2e99)
    val p7 = Color(color = 281474962960025)
    val p8 = Color(281474962960025)
    //endregion

    //region ulong
    val p9 = Color(value = 0x2c5a29c23360ffceUL)
    val p10 = Color(0x2c5a29c23360ffceUL)
    val p11 = Color(value = 3195912799635177422UL)
    val p12 = Color(3195912799635177422UL)

    val p13 = Color(value = 0x2c5a29c23360ffceU)
    val p14 = Color(0x2c5a29c23360ffceU)
    val p15 = Color(value = 3195912799635177422U); val p16 = Color(3195912799635177422U)
    //endregion
}

fun intLongULongKtParameter(
    //region int
    p1: Color = Color(color = 0xff2e2e99),
    p2: Color = Color(0xff2e2e99),
    p3: Color = Color(color = -13750631),
    p4: Color = Color(-13750631),
    //endregion

    //region long
    p5: Color = Color(color = 0xffffff2e2e99),
    p6: Color = Color(0xffffff2e2e99),
    p7: Color = Color(color = 281474962960025),
    p8: Color = Color(281474962960025),
    //endregion

    //region ulong
    p9: Color = Color(value = 0x2c5a29c23360ffceUL),
    p10: Color = Color(0x2c5a29c23360ffceUL),
    p11: Color = Color(value = 3195912799635177422UL),
    p12: Color = Color(3195912799635177422UL),

    p13: Color = Color(value = 0x2c5a29c23360ffceU),
    p14: Color = Color(0x2c5a29c23360ffceU),
    p15: Color = Color(value = 3195912799635177422U), p16: Color = Color(3195912799635177422U),
    //endregion
) = Unit

fun intLongULongKtValueArgumentName() = intLongULongKtParameter(
    //region int
    p1 = Color(color = 0xff2e2e99),
    p2 = Color(0xff2e2e99),
    p3 = Color(color = -13750631),
    p4 = Color(-13750631),
    //endregion

    //region long
    p5 = Color(color = 0xffffff2e2e99),
    p6 = Color(0xffffff2e2e99),
    p7 = Color(color = 281474962960025),
    p8 = Color(281474962960025),
    //endregion

    //region ulong
    p9 = Color(value = 0x2c5a29c23360ffceUL),
    p10 = Color(0x2c5a29c23360ffceUL),
    p11 = Color(value = 3195912799635177422UL),
    p12 = Color(3195912799635177422UL),

    p13 = Color(value = 0x2c5a29c23360ffceU),
    p14 = Color(0x2c5a29c23360ffceU),
    p15 = Color(value = 3195912799635177422U),
    p16 = Color(3195912799635177422U),
    //endregion
)

fun intLongULongKtValueArgument() = intLongULongKtParameter(
    //region int
    Color(color = 0xff2e2e99),
    Color(0xff2e2e99),
    Color(color = -13750631),
    Color(-13750631),
    //endregion

    //region long
    Color(color = 0xffffff2e2e99),
    Color(0xffffff2e2e99),
    Color(color = 281474962960025),
    Color(281474962960025),
    //endregion

    //region ulong
    Color(value = 0x2c5a29c23360ffceUL),
    Color(0x2c5a29c23360ffceUL),
    Color(value = 3195912799635177422UL),
    Color(3195912799635177422UL),

    Color(value = 0x2c5a29c23360ffceU),
    Color(0x2c5a29c23360ffceU),
    Color(value = 3195912799635177422U),
    Color(3195912799635177422U),
    //endregion
)

fun intLongULongKtReturnExpression(): Color {
    //region int
    return Color(color = 0xff2e2e99)
    return Color(0xff2e2e99)
    return Color(color = -13750631)
    return Color(-13750631)
    //endregion

    //region long
    return Color(color = 0xffffff2e2e99)
    return Color(0xffffff2e2e99)
    return Color(color = 281474962960025)
    return Color(281474962960025)
    //endregion

    //region ulong
    return Color(value = 0x2c5a29c23360ffceUL)
    return Color(0x2c5a29c23360ffceUL)
    return Color(value = 3195912799635177422UL)
    return Color(3195912799635177422UL)

    return Color(value = 0x2c5a29c23360ffceU)
    return Color(0x2c5a29c23360ffceU)
    return Color(value = 3195912799635177422U)
    return Color(3195912799635177422U)
    //endregion
}

fun intLongULongKtBinaryExpression() {
    //region int
    null ?: Color(color = 0xff2e2e99)
    null ?: Color(0xff2e2e99)
    null ?: Color(color = -13750631)
    null ?: Color(-13750631)
    //endregion

    //region long
    null ?: Color(color = 0xffffff2e2e99)
    null ?: Color(0xffffff2e2e99)
    null ?: Color(color = 281474962960025)
    null ?: Color(281474962960025)
    //endregion

    //region ulong
    null ?: Color(value = 0x2c5a29c23360ffceUL)
    null ?: Color(0x2c5a29c23360ffceUL)
    null ?: Color(value = 3195912799635177422UL)
    null ?: Color(3195912799635177422UL)

    null ?: Color(value = 0x2c5a29c23360ffceU)
    null ?: Color(0x2c5a29c23360ffceU)
    null ?: Color(value = 3195912799635177422U)
    null ?: Color(3195912799635177422U)
    //endregion
}