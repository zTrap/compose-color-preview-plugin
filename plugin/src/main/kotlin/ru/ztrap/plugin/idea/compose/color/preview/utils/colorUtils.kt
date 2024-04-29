package ru.ztrap.plugin.idea.compose.color.preview.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import kotlin.math.absoluteValue
import org.jetbrains.kotlin.psi.KtCallExpression
import org.jetbrains.kotlin.psi.KtDotQualifiedExpression
import org.jetbrains.kotlin.psi.KtNameReferenceExpression

internal fun PsiElement.getColor(): Color = getColorOrNull().requireNotNull()

internal fun PsiElement.getColorOrNull(): Color? {
    val expression = when (this) {
        is LeafPsiElement -> findColorConstantExpression(this)
        is KtCallExpression -> this
        is KtNameReferenceExpression -> parent.safeCast<KtCallExpression>()
            ?: resolveNameReference(this)

        is KtDotQualifiedExpression -> when (val selector = selectorExpression) {
            is KtNameReferenceExpression -> resolveNameReference(selector)
            is KtCallExpression -> selector
            else -> null
        }

        else -> null
    }

    return expression?.createColorFunction()?.getColor()
}

internal fun KtCallExpression.getParentReceiverColor(): Color? {
    return parent.cast<KtDotQualifiedExpression>()
        .receiverExpression
        .takeIf { it != this }
        ?.getColorOrNull()
}

internal fun Color.getComponents(): FloatArray = floatArrayOf(red, green, blue, alpha)

@Suppress("UseJBColor")
internal fun Color.toAwtColor(): java.awt.Color? {
    return convert(ColorSpaces.Srgb)
        .runCatching { java.awt.Color(red, green, blue, alpha) }
        .getOrNull()
}

internal fun FloatArray.toHsl(): FloatArray {
    val (red, green, blue) = this

    val max = maxOf(red, green, blue)
    val min = minOf(red, green, blue)
    val deltaMaxMin = max - min

    val l: Float = (max + min) / 2f

    // Monochromatic
    if (deltaMaxMin == 0f) {
        this[0] = 0f
        this[1] = 0f
        this[2] = l.coerceIn(0f, 1f)
        return this
    }

    var h = when (max) {
        red -> (green - blue) / deltaMaxMin % 6f
        green -> (blue - red) / deltaMaxMin + 2f
        else -> (red - green) / deltaMaxMin + 4f
    }

    h = (h * 60f) % 360f
    if (h < 0) {
        h += 360f
    }

    val s = deltaMaxMin / (1f - (2f * l - 1f).absoluteValue)

    this[0] = h.coerceIn(0f, 360f)
    this[1] = s.coerceIn(0f, 1f)
    this[2] = l.coerceIn(0f, 1f)

    return this
}

internal fun FloatArray.toHsv(): FloatArray {
    val (red, green, blue) = this

    val max = maxOf(red, green, blue)
    val min = minOf(red, green, blue)
    val deltaMaxMin = max - min

    // Monochromatic
    if (deltaMaxMin == 0f) {
        this[0] = 0f
        this[1] = 0f
        this[2] = max.coerceIn(0f, 1f)
        return this
    }

    var h = when (max) {
        red -> (green - blue) / deltaMaxMin % 6f
        green -> (blue - red) / deltaMaxMin + 2f
        else -> (red - green) / deltaMaxMin + 4f
    }

    h = (h * 60f) % 360f
    if (h < 0) {
        h += 360f
    }

    val s = if (max == 0f) {
        0f
    } else {
        deltaMaxMin / max
    }

    val v: Float = max

    this[0] = h.coerceIn(0f, 360f)
    this[1] = s.coerceIn(0f, 1f)
    this[2] = v.coerceIn(0f, 1f)

    return this
}