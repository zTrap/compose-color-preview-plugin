@file:Suppress("RemoveRedundantQualifierName", "unused", "UNUSED_VARIABLE", "UNREACHABLE_CODE", "UNUSED_PARAMETER", "SameReturnValue")

package ru.ztrap.plugin.idea.compose.color.preview.test

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.colorspace.ColorSpaces

val p1 get() = White.convert(ColorSpaces.Srgb)
val p2 get() = White.convert(colorSpace = ColorSpaces.Srgb)
val p3 get() = Color.White.convert(ColorSpaces.Srgb)
val p4 get() = Color.White.convert(colorSpace = ColorSpaces.Srgb)
val p5 get() = Color(0xffffffff).convert(ColorSpaces.Srgb)
val p6 get() = Color(0xffffffff).convert(colorSpace = ColorSpaces.Srgb)

fun convertKtBlockExpression() {
    White.convert(ColorSpaces.Srgb)
    White.convert(colorSpace = ColorSpaces.Srgb)
    Color.White.convert(ColorSpaces.Srgb)
    Color.White.convert(colorSpace = ColorSpaces.Srgb)
    Color(0xffffffff).convert(ColorSpaces.Srgb)
    Color(0xffffffff).convert(colorSpace = ColorSpaces.Srgb)
}

fun convertKtProperty() {
    val p1 = White.convert(ColorSpaces.Srgb)
    val p2 = White.convert(colorSpace = ColorSpaces.Srgb)
    val p3 = Color.White.convert(ColorSpaces.Srgb)
    val p4 = Color.White.convert(colorSpace = ColorSpaces.Srgb)
    val p5 = Color(0xffffffff).convert(ColorSpaces.Srgb)
    val p6 = Color(0xffffffff).convert(colorSpace = ColorSpaces.Srgb)
}

fun convertKtParameter(
    p1: Color = White.convert(ColorSpaces.Srgb),
    p2: Color = White.convert(colorSpace = ColorSpaces.Srgb),
    p3: Color = Color.White.convert(ColorSpaces.Srgb),
    p4: Color = Color.White.convert(colorSpace = ColorSpaces.Srgb),
    p5: Color = Color(0xffffffff).convert(ColorSpaces.Srgb),
    p6: Color = Color(0xffffffff).convert(colorSpace = ColorSpaces.Srgb),
) = Unit

fun convertKtValueArgumentName() = convertKtParameter(
    p1 = White.convert(ColorSpaces.Srgb),
    p2 = White.convert(colorSpace = ColorSpaces.Srgb),
    p3 = White.convert(ColorSpaces.Srgb),
    p4 = White.convert(colorSpace = ColorSpaces.Srgb),
    p5 = Color(0xffffffff).convert(ColorSpaces.Srgb),
    p6 = Color(0xffffffff).convert(colorSpace = ColorSpaces.Srgb),
)

fun convertKtValueArgument() = convertKtParameter(
    White.convert(ColorSpaces.Srgb),
    White.convert(colorSpace = ColorSpaces.Srgb),
    White.convert(ColorSpaces.Srgb),
    White.convert(colorSpace = ColorSpaces.Srgb),
    Color(0xffffffff).convert(ColorSpaces.Srgb),
    Color(0xffffffff).convert(colorSpace = ColorSpaces.Srgb),
)

fun convertKtReturnExpression(): Color {
    return White.convert(ColorSpaces.Srgb)
    return White.convert(colorSpace = ColorSpaces.Srgb)
    return Color.White.convert(ColorSpaces.Srgb)
    return Color.White.convert(colorSpace = ColorSpaces.Srgb)
    return Color(0xffffffff).convert(ColorSpaces.Srgb)
    return Color(0xffffffff).convert(colorSpace = ColorSpaces.Srgb)
}

fun convertKtBinaryExpression() {
    null ?: White.convert(ColorSpaces.Srgb)
    null ?: White.convert(colorSpace = ColorSpaces.Srgb)
    null ?: Color.White.convert(ColorSpaces.Srgb)
    null ?: Color.White.convert(colorSpace = ColorSpaces.Srgb)
    null ?: Color(0xffffffff).convert(ColorSpaces.Srgb)
    null ?: Color(0xffffffff).convert(colorSpace = ColorSpaces.Srgb)
}