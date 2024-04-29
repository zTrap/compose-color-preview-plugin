@file:Suppress("RemoveRedundantQualifierName", "unused", "UNUSED_VARIABLE", "UNREACHABLE_CODE", "UNUSED_PARAMETER")

package ru.ztrap.plugin.idea.compose.color.preview.sample

import androidx.compose.ui.graphics.Color

//region intX3X4KtPropertyAccessor
//region hex with alpha
val intX3X4P1 get() = Color(red = 0x2e, green = 0x2e, blue = 0x99, alpha = 0xff)
val intX3X4P2 get() = Color(red = 0x2e, 0x2e, blue = 0x99, 0xff)
val intX3X4P3 get() = Color(0x2e, 0x2e, 0x99, 0xff)
//endregion

//region int with alpha
val intX3X4P4 get() = Color(red = 46, green = 46, blue = 153, alpha = 255)
val intX3X4P5 get() = Color(red = 46, 46, blue = 153, 255)
val intX3X4P6 get() = Color(46, 46, 153, 255)
//endregion

//region mixed with alpha
val intX3X4P7 get() = Color(red = 0x2e, green = 46, blue = 0x99, alpha = 255)
val intX3X4P8 get() = Color(red = 0x2e, 46, blue = 0x99, 255)
val intX3X4P9 get() = Color(0x2e, 46, 0x99, 255)
//endregion

//region hex
val intX3X4P10 get() = Color(red = 0x2e, green = 0x2e, blue = 0x99)
val intX3X4P11 get() = Color(red = 0x2e, 0x2e, blue = 0x99)
val intX3X4P12 get() = Color(0x2e, 0x2e, 0x99)
//endregion

//region int
val intX3X4P13 get() = Color(red = 46, green = 46, blue = 153)
val intX3X4P14 get() = Color(red = 46, 46, blue = 153)
val intX3X4P15 get() = Color(46, 46, 153)
//endregion

//region mixed
val intX3X4P16 get() = Color(red = 0x2e, green = 46, blue = 0x99)
val intX3X4P17 get() = Color(red = 0x2e, 46, blue = 0x99)
val intX3X4P18 get() = Color(0x2e, 46, 0x99)
//endregion
//endregion

fun intX3X4KtBlockExpression() {
    //region hex with alpha
    Color(red = 0x2e, green = 0x2e, blue = 0x99, alpha = 0xff)
    Color(red = 0x2e, 0x2e, blue = 0x99, 0xff)
    Color(0x2e, 0x2e, 0x99, 0xff)
    //endregion

    //region int with alpha
    Color(red = 46, green = 46, blue = 153, alpha = 255)
    Color(red = 46, 46, blue = 153, 255)
    Color(46, 46, 153, 255)
    //endregion

    //region mixed with alpha
    Color(red = 0x2e, green = 46, blue = 0x99, alpha = 255)
    Color(red = 0x2e, 46, blue = 0x99, 255)
    Color(0x2e, 46, 0x99, 255)
    //endregion

    //region hex
    Color(red = 0x2e, green = 0x2e, blue = 0x99)
    Color(red = 0x2e, 0x2e, blue = 0x99)
    Color(0x2e, 0x2e, 0x99)
    //endregion

    //region int
    Color(red = 46, green = 46, blue = 153)
    Color(red = 46, 46, blue = 153)
    Color(46, 46, 153)
    //endregion

    //region mixed
    Color(red = 0x2e, green = 46, blue = 0x99)
    Color(red = 0x2e, 46, blue = 0x99)
    Color(0x2e, 46, 0x99)
    //endregion
}

fun intX3X4KtProperty() {
    //region hex with alpha
    val p1 = Color(red = 0x2e, green = 0x2e, blue = 0x99, alpha = 0xff)
    val p2 = Color(red = 0x2e, 0x2e, blue = 0x99, alpha = 0xff)
    val p3 = Color(0x2e, 0x2e, 0x99, alpha = 0xff)
    //endregion

    //region int with alpha
    val p4 = Color(red = 46, green = 46, blue = 153, alpha = 255)
    val p5 = Color(red = 46, 46, blue = 153, alpha = 255)
    val p6 = Color(46, 46, 153, alpha = 255)
    //endregion

    //region mixed with alpha
    val p7 = Color(red = 0x2e, green = 46, blue = 0x99, alpha = 255)
    val p8 = Color(red = 0x2e, 46, blue = 0x99, alpha = 255)
    val p9 = Color(0x2e, 46, 0x99, 255)
    //endregion

    //region hex
    val p10 = Color(red = 0x2e, green = 0x2e, blue = 0x99)
    val p11 = Color(red = 0x2e, 0x2e, blue = 0x99)
    val p12 = Color(0x2e, 0x2e, 0x99)
    //endregion

    //region int
    val p13 = Color(red = 46, green = 46, blue = 153)
    val p14 = Color(red = 46, 46, blue = 153)
    val p15 = Color(46, 46, 153)
    //endregion

    //region mixed
    val p16 = Color(red = 0x2e, green = 46, blue = 0x99)
    val p17 = Color(red = 0x2e, 46, blue = 0x99)
    val p18 = Color(0x2e, 46, 0x99)
    //endregion
}

fun intX3X4KtParameter(
    //region hex with alpha
    p1: Color = Color(red = 0x2e, green = 0x2e, blue = 0x99, alpha = 0xff),
    p2: Color = Color(red = 0x2e, 0x2e, blue = 0x99, alpha = 0xff),
    p3: Color = Color(0x2e, 0x2e, 0x99, alpha = 0xff),
    //endregion

    //region int with alpha
    p4: Color = Color(red = 46, green = 46, blue = 153, alpha = 255),
    p5: Color = Color(red = 46, 46, blue = 153, alpha = 255),
    p6: Color = Color(46, 46, 153, alpha = 255),
    //endregion

    //region mixed with alpha
    p7: Color = Color(red = 0x2e, green = 46, blue = 0x99, alpha = 255),
    p8: Color = Color(red = 0x2e, 46, blue = 0x99, alpha = 255),
    p9: Color = Color(0x2e, 46, 0x99, 255),
    //endregion

    //region hex
    p10: Color = Color(red = 0x2e, green = 0x2e, blue = 0x99),
    p11: Color = Color(red = 0x2e, 0x2e, blue = 0x99),
    p12: Color = Color(0x2e, 0x2e, 0x99),
    //endregion

    //region int
    p13: Color = Color(red = 46, green = 46, blue = 153),
    p14: Color = Color(red = 46, 46, blue = 153),
    p15: Color = Color(46, 46, 153),
    //endregion

    //region mixed
    p16: Color = Color(red = 0x2e, green = 46, blue = 0x99),
    p17: Color = Color(red = 0x2e, 46, blue = 0x99),
    p18: Color = Color(0x2e, 46, 0x99),
    //endregion
) = Unit

fun intX3X4KtValueArgumentName() = intX3X4KtParameter(
    //region hex with alpha
    p1 = Color(red = 0x2e, green = 0x2e, blue = 0x99, alpha = 0xff),
    p2 = Color(red = 0x2e, 0x2e, blue = 0x99, alpha = 0xff),
    p3 = Color(0x2e, 0x2e, 0x99, alpha = 0xff),
    //endregion

    //region int with alpha
    p4 = Color(red = 46, green = 46, blue = 153, alpha = 255),
    p5 = Color(red = 46, 46, blue = 153, alpha = 255),
    p6 = Color(46, 46, 153, alpha = 255),
    //endregion

    //region mixed with alpha
    p7 = Color(red = 0x2e, green = 46, blue = 0x99, alpha = 255),
    p8 = Color(red = 0x2e, 46, blue = 0x99, alpha = 255),
    p9 = Color(0x2e, 46, 0x99, 255),
    //endregion

    //region hex
    p10 = Color(red = 0x2e, green = 0x2e, blue = 0x99),
    p11 = Color(red = 0x2e, 0x2e, blue = 0x99),
    p12 = Color(0x2e, 0x2e, 0x99),
    //endregion

    //region int
    p13 = Color(red = 46, green = 46, blue = 153),
    p14 = Color(red = 46, 46, blue = 153),
    p15 = Color(46, 46, 153),
    //endregion

    //region mixed
    p16 = Color(red = 0x2e, green = 46, blue = 0x99),
    p17 = Color(red = 0x2e, 46, blue = 0x99),
    p18 = Color(0x2e, 46, 0x99),
    //endregion
)

fun intX3X4KtValueArgument() = intX3X4KtParameter(
    //region hex with alpha
    Color(red = 0x2e, green = 0x2e, blue = 0x99, alpha = 0xff),
    Color(red = 0x2e, 0x2e, blue = 0x99, alpha = 0xff),
    Color(0x2e, 0x2e, 0x99, alpha = 0xff),
    //endregion

    //region int with alpha
    Color(red = 46, green = 46, blue = 153, alpha = 255),
    Color(red = 46, 46, blue = 153, alpha = 255),
    Color(46, 46, 153, alpha = 255),
    //endregion

    //region mixed with alpha
    Color(red = 0x2e, green = 46, blue = 0x99, alpha = 255),
    Color(red = 0x2e, 46, blue = 0x99, alpha = 255),
    Color(0x2e, 46, 0x99, 255),
    //endregion

    //region hex
    Color(red = 0x2e, green = 0x2e, blue = 0x99),
    Color(red = 0x2e, 0x2e, blue = 0x99),
    Color(0x2e, 0x2e, 0x99),
    //endregion

    //region int
    Color(red = 46, green = 46, blue = 153),
    Color(red = 46, 46, blue = 153),
    Color(46, 46, 153),
    //endregion

    //region mixed
    Color(red = 0x2e, green = 46, blue = 0x99),
    Color(red = 0x2e, 46, blue = 0x99),
    Color(0x2e, 46, 0x99),
    //endregion
)

fun intX3X4KtReturnExpression(): Color {
    //region hex with alpha
    return Color(red = 0x2e, green = 0x2e, blue = 0x99, alpha = 0xff)
    return Color(red = 0x2e, 0x2e, blue = 0x99, alpha = 0xff)
    return Color(0x2e, 0x2e, 0x99, alpha = 0xff)
    //endregion

    //region int with alpha
    return Color(red = 46, green = 46, blue = 153, alpha = 255)
    return Color(red = 46, 46, blue = 153, alpha = 255)
    return Color(46, 46, 153, alpha = 255)
    //endregion

    //region mixed with alpha
    return Color(red = 0x2e, green = 46, blue = 0x99, alpha = 255)
    return Color(red = 0x2e, 46, blue = 0x99, alpha = 255)
    return Color(0x2e, 46, 0x99, 255)
    //endregion

    //region hex
    return Color(red = 0x2e, green = 0x2e, blue = 0x99)
    return Color(red = 0x2e, 0x2e, blue = 0x99)
    return Color(0x2e, 0x2e, 0x99)
    //endregion

    //region int
    return Color(red = 46, green = 46, blue = 153)
    return Color(red = 46, 46, blue = 153)
    return Color(46, 46, 153)
    //endregion

    //region mixed
    return Color(red = 0x2e, green = 46, blue = 0x99)
    return Color(red = 0x2e, 46, blue = 0x99)
    return Color(0x2e, 46, 0x99)
    //endregion
}

fun intX3X4KtBinaryExpression() {
    //region hex with alpha
    null ?: Color(red = 0x2e, green = 0x2e, blue = 0x99, alpha = 0xff)
    null ?: Color(red = 0x2e, 0x2e, blue = 0x99, alpha = 0xff)
    null ?: Color(0x2e, 0x2e, 0x99, alpha = 0xff)
    //endregion

    //region int with alpha
    null ?: Color(red = 46, green = 46, blue = 153, alpha = 255)
    null ?: Color(red = 46, 46, blue = 153, alpha = 255)
    null ?: Color(46, 46, 153, alpha = 255)
    //endregion

    //region mixed with alpha
    null ?: Color(red = 0x2e, green = 46, blue = 0x99, alpha = 255)
    null ?: Color(red = 0x2e, 46, blue = 0x99, alpha = 255)
    null ?: Color(0x2e, 46, 0x99, 255)
    //endregion

    //region hex
    null ?: Color(red = 0x2e, green = 0x2e, blue = 0x99)
    null ?: Color(red = 0x2e, 0x2e, blue = 0x99)
    null ?: Color(0x2e, 0x2e, 0x99)
    //endregion

    //region int
    null ?: Color(red = 46, green = 46, blue = 153)
    null ?: Color(red = 46, 46, blue = 153)
    null ?: Color(46, 46, 153)
    //endregion

    //region mixed
    null ?: Color(red = 0x2e, green = 46, blue = 0x99)
    null ?: Color(red = 0x2e, 46, blue = 0x99)
    null ?: Color(0x2e, 46, 0x99)
    //endregion
}