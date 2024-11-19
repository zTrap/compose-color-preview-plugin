package ru.ztrap.plugin.idea.compose.color.preview.codeInsight.daemon

import com.intellij.codeInsight.daemon.GutterIconNavigationHandler
import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.ui.scale.JBUIScale
import java.awt.Color
import javax.swing.Icon
import ru.ztrap.plugin.idea.compose.color.preview.icon.ComposeColorIcon
import ru.ztrap.plugin.idea.compose.color.preview.utils.cast

internal abstract class ColorAwareLineMarkerInfo(
    val color: Color,
    anchor: LeafPsiElement,
    tooltipText: String,
    navHandler: GutterIconNavigationHandler<PsiElement>?,
) : MergeableLineMarkerInfo<PsiElement>(
    /* element = */ anchor,
    /* textRange = */ anchor.textRange,
    /* icon = */ JBUIScale.scaleIcon(ComposeColorIcon(12, color)),
    /* tooltipProvider = */ { tooltipText },
    /* navHandler = */ navHandler,
    /* alignment = */ GutterIconRenderer.Alignment.LEFT,
    /* accessibleNameProvider = */ { tooltipText },
) {
    override fun canMergeWith(info: MergeableLineMarkerInfo<*>): Boolean = this::class.isInstance(info)

    override fun getElementPresentation(element: PsiElement): String {
        return element.text.replace("_", "__") // remove mnemonic
    }

    override fun getCommonIcon(infos: MutableList<out MergeableLineMarkerInfo<*>>): Icon {
        val colors = Array(infos.size) { infos[it].cast<ColorAwareLineMarkerInfo>().color }
        return JBUIScale.scaleIcon(ComposeColorIcon(12, colors = colors))
    }
}