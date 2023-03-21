package ru.ztrap.plugin.idea.compose.color.preview

import org.jetbrains.kotlin.psi.KtValueArgument

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
