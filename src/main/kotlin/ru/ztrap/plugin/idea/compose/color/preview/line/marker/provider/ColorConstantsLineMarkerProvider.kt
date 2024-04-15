package ru.ztrap.plugin.idea.compose.color.preview.line.marker.provider

import com.intellij.codeInsight.daemon.GutterIconNavigationHandler
import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.LineMarkerProvider
import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.codeInsight.daemon.NavigateAction
import com.intellij.icons.AllIcons
import com.intellij.ide.util.EditSourceUtil
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.pom.Navigatable
import com.intellij.psi.PsiElement
import com.intellij.psi.SmartPsiElementPointer
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.ui.scale.JBUIScale.scaleIcon
import com.intellij.util.ui.ColorIcon
import com.intellij.util.ui.ColorsIcon
import java.awt.Color
import java.awt.event.MouseEvent
import javax.swing.Icon
import org.jetbrains.kotlin.idea.KotlinLanguage
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.psiUtil.createSmartPointer
import ru.ztrap.plugin.idea.compose.color.preview.utils.cast
import ru.ztrap.plugin.idea.compose.color.preview.utils.createColorFunction
import ru.ztrap.plugin.idea.compose.color.preview.utils.findColorConstantExpression
import ru.ztrap.plugin.idea.compose.color.preview.utils.isInFileHeader
import ru.ztrap.plugin.idea.compose.color.preview.utils.toAwtColor

class ColorConstantsLineMarkerProvider : LineMarkerProvider {
    override fun getLineMarkerInfo(element: PsiElement): LineMarkerInfo<*>? = null
    override fun collectSlowLineMarkers(
        elements: MutableList<out PsiElement>,
        result: MutableCollection<in LineMarkerInfo<*>>,
    ) {
        elements.asSequence()
            .filter { it.language == KotlinLanguage.INSTANCE }
            .filterIsInstance<LeafPsiElement>()
            .filter { it.elementType == KtTokens.IDENTIFIER }
            .filterNot { it.isInFileHeader }
            .forEach { leaf ->
                val expression = findColorConstantExpression(leaf)
                val color = expression?.createColorFunction()?.getColor()?.toAwtColor()
                if (color != null) {
                    val info = ColorConstantLineMarkerInfo(
                        color = color,
                        anchor = leaf,
                        target = expression.createSmartPointer(),
                    )
                    setNavigateAction(info)
                    result.add(info)
                }
            }
    }

    private fun setNavigateAction(info: ColorConstantLineMarkerInfo) {
        NavigateAction.setNavigateAction(
            /* info = */ info,
            /* text = */ "Go To Color Declaration",
            /* originalActionId = */ null,
            /* icon = */ AllIcons.Actions.Colors,
        )
    }

    private class ColorConstantLineMarkerInfo(
        private val color: Color,
        anchor: PsiElement,
        target: SmartPsiElementPointer<PsiElement>?,
    ) : MergeableLineMarkerInfo<PsiElement>(
        /* element = */ anchor,
        /* textRange = */ anchor.textRange,
        /* icon = */ scaleIcon(ColorIcon(12, color)),
        /* tooltipProvider = */ { anchor.text },
        /* navHandler = */ target?.let(ColorConstantsLineMarkerProvider::NavigationHandler),
        /* alignment = */ GutterIconRenderer.Alignment.LEFT,
        /* accessibleNameProvider = */ { anchor.text },
    ) {
        override fun canMergeWith(info: MergeableLineMarkerInfo<*>): Boolean {
            return info is ColorConstantLineMarkerInfo
        }

        override fun getCommonIcon(infos: MutableList<out MergeableLineMarkerInfo<*>>): Icon {
            return scaleIcon(
                ColorsIcon(
                    12,
                    *Array(infos.size) { infos[it].cast<ColorConstantLineMarkerInfo>().color },
                ),
            )
        }
    }

    private class NavigationHandler(
        private val target: SmartPsiElementPointer<PsiElement>,
    ) : GutterIconNavigationHandler<PsiElement> {
        override fun navigate(e: MouseEvent, elt: PsiElement) {
            target.element
                ?.let(EditSourceUtil::getDescriptor)
                ?.takeIf(Navigatable::canNavigate)
                ?.navigate(true)
        }
    }
}