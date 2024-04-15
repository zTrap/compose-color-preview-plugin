package ru.ztrap.plugin.idea.compose.color.preview.utils

import androidx.compose.ui.graphics.Color
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import kotlin.math.absoluteValue
import org.jetbrains.kotlin.idea.intentions.callExpression
import org.jetbrains.kotlin.psi.KtCallExpression
import org.jetbrains.kotlin.psi.KtDotQualifiedExpression
import org.jetbrains.kotlin.psi.KtNameReferenceExpression
import org.jetbrains.kotlin.psi.psiUtil.getParentOfType

internal fun PsiElement.getColor(): Color {
    return getColorOrNull().requireNotNull()
}

internal fun PsiElement.getColorOrNull(): Color? {
    val expression = when (this) {
        is LeafPsiElement -> findColorConstantExpression(this)
        is KtCallExpression -> this
        is KtNameReferenceExpression -> getParentOfType<KtCallExpression>(true)
            ?: resolveNameReference(this)
        is KtDotQualifiedExpression -> callExpression ?: lastChild
            ?.safeCast<KtNameReferenceExpression>()
            ?.let(::resolveNameReference)
        else -> null
    }

    val colorFunction = expression?.createColorFunction()
    val color = colorFunction?.getColor()

    return color
}

internal val KtCallExpression.parentReceiverColor: Color?
    get() = parent.cast<KtDotQualifiedExpression>()
        .receiverExpression
        .takeIf { it != this }
        ?.getColorOrNull()

internal val Color.components: FloatArray
    get() = floatArrayOf(red, green, blue, alpha)

internal fun FloatArray.toHsl(): FloatArray {
    val (red, green, blue) = this

    val max = maxOf(red, green, blue)
    val min = minOf(red, green, blue)
    val deltaMaxMin = max - min

    var h: Float
    val s: Float
    val l: Float = (max + min) / 2f

    if (max == min) {
        // Monochromatic
        s = 0f
        h = s
    } else {
        h = when (max) {
            red -> (green - blue) / deltaMaxMin % 6f
            green -> (blue - red) / deltaMaxMin + 2f
            else -> (red - green) / deltaMaxMin + 4f
        }

        s = deltaMaxMin / (1f - (2f * l - 1f).absoluteValue)
    }

    h = (h * 60f) % 360f
    if (h < 0) {
        h += 360f
    }

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

    if (deltaMaxMin == 0f) {
        this[0] = 360f
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