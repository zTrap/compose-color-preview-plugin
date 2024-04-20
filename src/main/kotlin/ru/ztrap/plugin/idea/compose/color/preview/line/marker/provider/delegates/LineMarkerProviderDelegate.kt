package ru.ztrap.plugin.idea.compose.color.preview.line.marker.provider.delegates

import com.intellij.codeInsight.daemon.GutterIconDescriptor
import com.intellij.icons.AllIcons
import com.intellij.psi.impl.source.tree.LeafPsiElement
import ru.ztrap.plugin.idea.compose.color.preview.line.marker.provider.ColorAwareLineMarkerInfo

internal sealed class LineMarkerProviderDelegate {
    abstract val option: GutterIconDescriptor.Option
    abstract fun getLineMarkerInfo(leaf: LeafPsiElement): ColorAwareLineMarkerInfo?

    protected fun createOption(name: String): GutterIconDescriptor.Option {
        return GutterIconDescriptor.Option(
            /* id = */ javaClass.name,
            /* name = */ name,
            /* icon = */ AllIcons.Gutter.Colors,
        )
    }
}