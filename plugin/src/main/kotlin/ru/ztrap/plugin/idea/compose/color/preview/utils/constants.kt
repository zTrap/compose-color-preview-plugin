package ru.ztrap.plugin.idea.compose.color.preview.utils

private const val COMPOSE_COLOR_PACKAGE = "androidx.compose.ui.graphics"
internal const val COMPOSE_COLOR_FQ_NAME_CTOR = "$COMPOSE_COLOR_PACKAGE.Color"
internal const val COMPOSE_COLOR_FQ_NAME_COPY = "$COMPOSE_COLOR_FQ_NAME_CTOR.copy"
internal const val COMPOSE_COLOR_FQ_NAME_CONVERT = "$COMPOSE_COLOR_FQ_NAME_CTOR.convert"
internal const val COMPOSE_COLOR_FQ_NAME_HSV = "$COMPOSE_COLOR_FQ_NAME_CTOR.Companion.hsv"
internal const val COMPOSE_COLOR_FQ_NAME_HSL = "$COMPOSE_COLOR_FQ_NAME_CTOR.Companion.hsl"
internal const val COMPOSE_COLOR_FQ_NAME_LERP = "$COMPOSE_COLOR_PACKAGE.lerp"
internal const val COMPOSE_COLOR_FQ_NAME_COMPOSITE_OVER = "$COMPOSE_COLOR_PACKAGE.compositeOver"

internal const val MAX_COMPONENT_FLOAT = 1f
internal const val MAX_COMPONENT_HEX = 0xFF

internal const val HEX_FORMAT_PREFIX = "0x"
internal const val HEX_FORMAT = "$HEX_FORMAT_PREFIX%08x"
internal const val HEX_FORMAT_RADIX = 16

internal const val COMPOSE_ARG_NAME_HUE = "hue"
internal const val COMPOSE_ARG_NAME_SATURATION = "saturation"
internal const val COMPOSE_ARG_NAME_LIGHTNESS = "lightness"
internal const val COMPOSE_ARG_NAME_VALUE = "value"
internal const val COMPOSE_ARG_NAME_RED = "red"
internal const val COMPOSE_ARG_NAME_GREEN = "green"
internal const val COMPOSE_ARG_NAME_BLUE = "blue"
internal const val COMPOSE_ARG_NAME_START = "start"
internal const val COMPOSE_ARG_NAME_STOP = "stop"
internal const val COMPOSE_ARG_NAME_FRACTION = "fraction"
internal const val COMPOSE_ARG_NAME_ALPHA = "alpha"
internal const val COMPOSE_ARG_NAME_COLOR_SPACE = "colorSpace"

internal val ARGB_NAMES = arrayOf(
    COMPOSE_ARG_NAME_ALPHA,
    COMPOSE_ARG_NAME_RED,
    COMPOSE_ARG_NAME_GREEN,
    COMPOSE_ARG_NAME_BLUE,
)

internal val LERP_NAMES = arrayOf(
    COMPOSE_ARG_NAME_START,
    COMPOSE_ARG_NAME_STOP,
    COMPOSE_ARG_NAME_FRACTION,
)

internal val RGBA_NAMES = arrayOf(
    COMPOSE_ARG_NAME_RED,
    COMPOSE_ARG_NAME_GREEN,
    COMPOSE_ARG_NAME_BLUE,
    COMPOSE_ARG_NAME_ALPHA,
)

internal val RGB_NAMES = arrayOf(
    COMPOSE_ARG_NAME_RED,
    COMPOSE_ARG_NAME_GREEN,
    COMPOSE_ARG_NAME_BLUE,
)

internal val HSLA_NAMES = arrayOf(
    COMPOSE_ARG_NAME_HUE,
    COMPOSE_ARG_NAME_SATURATION,
    COMPOSE_ARG_NAME_LIGHTNESS,
    COMPOSE_ARG_NAME_ALPHA,
)

internal val HSL_NAMES = arrayOf(
    COMPOSE_ARG_NAME_HUE,
    COMPOSE_ARG_NAME_SATURATION,
    COMPOSE_ARG_NAME_LIGHTNESS,
)

internal val HSVA_NAMES = arrayOf(
    COMPOSE_ARG_NAME_HUE,
    COMPOSE_ARG_NAME_SATURATION,
    COMPOSE_ARG_NAME_VALUE,
    COMPOSE_ARG_NAME_ALPHA,
)

internal val HSV_NAMES = arrayOf(
    COMPOSE_ARG_NAME_HUE,
    COMPOSE_ARG_NAME_SATURATION,
    COMPOSE_ARG_NAME_VALUE,
)

internal val COMPOSE_COLOR_CREATOR_FUNCTIONS = arrayOf(
    COMPOSE_COLOR_FQ_NAME_CTOR,
    COMPOSE_COLOR_FQ_NAME_HSL,
    COMPOSE_COLOR_FQ_NAME_HSV,
)

internal val COMPOSE_COLOR_MODIFIER_FUNCTIONS = arrayOf(
    COMPOSE_COLOR_FQ_NAME_COMPOSITE_OVER,
    COMPOSE_COLOR_FQ_NAME_LERP,
    COMPOSE_COLOR_FQ_NAME_CONVERT,
    COMPOSE_COLOR_FQ_NAME_COPY,
)