package ru.ztrap.plugin.idea.compose.color.preview.line.marker.provider

import com.intellij.codeInsight.daemon.GutterIconNavigationHandler
import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.ui.scale.JBUIScale
import com.intellij.util.ui.ColorIcon
import com.intellij.util.ui.ColorsIcon
import java.awt.Color
import javax.swing.Icon
import ru.ztrap.plugin.idea.compose.color.preview.utils.cast

internal abstract class ColorAwareLineMarkerInfo(
    val color: Color,
    anchor: LeafPsiElement,
    tooltipText: String,
    navHandler: GutterIconNavigationHandler<PsiElement>?,
) : MergeableLineMarkerInfo<PsiElement>(
    /* element = */ anchor,
    /* textRange = */ anchor.textRange,
    /* icon = */ JBUIScale.scaleIcon(ColorIcon(12, color)),
    /* tooltipProvider = */ { tooltipText },
    /* navHandler = */ navHandler,
    /* alignment = */ GutterIconRenderer.Alignment.LEFT,
    /* accessibleNameProvider = */ { tooltipText },
) {
    override fun canMergeWith(info: MergeableLineMarkerInfo<*>): Boolean = javaClass.isInstance(info)

    override fun getCommonIcon(infos: MutableList<out MergeableLineMarkerInfo<*>>): Icon {
        val colors = Array(infos.size) { infos[it].cast<ColorAwareLineMarkerInfo>().color }
        return JBUIScale.scaleIcon(ColorsIcon(12, *colors))
    }
}