@file:Suppress("unused", "UNUSED_VARIABLE")

package ru.ztrap.plugin.idea.compose.color.preview.sample

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.graphics.lerp

var mutableProperty = Color(0xffda0909)
val proxyPropertyToMutableProperty = mutableProperty // no preview because property are mutable

val property = Color(0xff4ec698)
val propertyWithGetter
    get() = Color(0xffbe09da)

val proxyPropertyToProperty = property
val proxyPropertyToPropertyWitchGetter = propertyWithGetter

val proxyPropertyWitchGetterToProperty
    get() = proxyPropertyToProperty

val proxyPropertyWitchGetterToPropertyWitchGetter
    get() = proxyPropertyToPropertyWitchGetter

fun function(
    parameter: Color = Color(red = 255, 0xc4, alpha = 0x88, blue = 0)
) {
    val localVariable = parameter // no preview because parameters are mutable
    val titleColor = Palette.titleColor
    val disabledTitleColor = titleColor.copy(alpha = 0.5f)
        .copy(red = 1f, green = 1f, blue = 1f)
        .compositeOver(Color.Red)
        .convert(ColorSpaces.Srgb)

    val colorHsl = Color.hsl(114.09326f, 0.7751004f, 0.4882353f)
    val colorHsv = Color.hsv(229.94763f, 0.8967136f, 0.8352941f)
    val interpolatedColor = lerp(Color.White, Color.Magenta, fraction = 0.7f)
}

object Palette {
    val titleColor = Color.Black
    val backgroundColor = Color(0xffffffff)
}