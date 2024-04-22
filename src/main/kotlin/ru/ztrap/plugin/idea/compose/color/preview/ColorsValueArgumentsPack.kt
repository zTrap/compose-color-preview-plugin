package ru.ztrap.plugin.idea.compose.color.preview

import org.jetbrains.kotlin.psi.KtValueArgument
import ru.ztrap.plugin.idea.compose.color.preview.utils.HSLA_NAMES
import ru.ztrap.plugin.idea.compose.color.preview.utils.HSL_NAMES
import ru.ztrap.plugin.idea.compose.color.preview.utils.HSVA_NAMES
import ru.ztrap.plugin.idea.compose.color.preview.utils.HSV_NAMES
import ru.ztrap.plugin.idea.compose.color.preview.utils.RGBA_NAMES
import ru.ztrap.plugin.idea.compose.color.preview.utils.RGB_NAMES
import ru.ztrap.plugin.idea.compose.color.preview.utils.find
import ru.ztrap.plugin.idea.compose.color.preview.utils.requireAllNotNull

internal sealed class ColorsValueArgumentsPack {
    abstract val red: KtValueArgument
    abstract val green: KtValueArgument
    abstract val blue: KtValueArgument

    class RGB(
        override val red: KtValueArgument,
        override val green: KtValueArgument,
        override val blue: KtValueArgument,
    ) : ColorsValueArgumentsPack()

    class ARGB(
        val alpha: KtValueArgument,
        override val red: KtValueArgument,
        override val green: KtValueArgument,
        override val blue: KtValueArgument,
    ) : ColorsValueArgumentsPack()
}

internal fun List<KtValueArgument>.getPackedARGB(): ColorsValueArgumentsPack.ARGB {
    val (red, green, blue, alpha) = find(RGBA_NAMES).requireAllNotNull()
    return ColorsValueArgumentsPack.ARGB(alpha, red, green, blue)
}

internal fun List<KtValueArgument>.getPackedRGB(): ColorsValueArgumentsPack.RGB {
    val (red, green, blue) = find(RGB_NAMES).requireAllNotNull()
    return ColorsValueArgumentsPack.RGB(red, green, blue)
}

internal fun List<KtValueArgument>.getPackedHSLA(): ColorsValueArgumentsPack.ARGB {
    val (hue, saturation, lightness, alpha) = find(HSLA_NAMES).requireAllNotNull()
    return ColorsValueArgumentsPack.ARGB(alpha, hue, saturation, lightness)
}

internal fun List<KtValueArgument>.getPackedHSL(): ColorsValueArgumentsPack.RGB {
    val (hue, saturation, lightness) = find(HSL_NAMES).requireAllNotNull()
    return ColorsValueArgumentsPack.RGB(hue, saturation, lightness)
}

internal fun List<KtValueArgument>.getPackedHSVA(): ColorsValueArgumentsPack.ARGB {
    val (hue, saturation, value, alpha) = find(HSVA_NAMES).requireAllNotNull()
    return ColorsValueArgumentsPack.ARGB(alpha, hue, saturation, value)
}

internal fun List<KtValueArgument>.getPackedHSV(): ColorsValueArgumentsPack.RGB {
    val (hue, saturation, value) = find(HSV_NAMES).requireAllNotNull()
    return ColorsValueArgumentsPack.RGB(hue, saturation, value)
}
