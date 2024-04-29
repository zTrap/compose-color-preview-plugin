@file:Suppress("RemoveRedundantQualifierName", "unused", "UNUSED_VARIABLE", "UNREACHABLE_CODE", "UNUSED_PARAMETER", "SameReturnValue")

package ru.ztrap.plugin.idea.compose.color.preview.sample

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White

val constP1 get() = Color.White
val constP2 get() = White

val constProxyP1 get() = constP1
val constProxyP2 get() = constP2

fun constKtBlockExpression() {
    Color.White
    White
}

fun constKtProperty() {
    val constP1 = Color.White
    val constP2 = White
}

fun constKtParameter(
    p1: Color = Color.White,
    p2: Color = White,
) = Unit

fun constKtValueArgumentName() = constKtParameter(
    p1 = White,
    p2 = White,
)

fun constKtValueArgument() = constKtParameter(
    White,
    White,
)

fun constKtReturnExpression(): Color {
    return Color.White
    return White
}

fun constKtBinaryExpression() {
    null ?: Color.White
    null ?: White
}