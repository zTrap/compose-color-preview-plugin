package ru.ztrap.plugin.idea.compose.color.preview

import org.jetbrains.kotlin.psi.KtExpression

internal sealed class ColorsExpressionsPack {
    abstract val red: KtExpression
    abstract val green: KtExpression
    abstract val blue: KtExpression

    class RGB(
        override val red: KtExpression,
        override val green: KtExpression,
        override val blue: KtExpression,
    ) : ColorsExpressionsPack()

    class ARGB(
        val alpha: KtExpression,
        override val red: KtExpression,
        override val green: KtExpression,
        override val blue: KtExpression,
    ) : ColorsExpressionsPack()
}
