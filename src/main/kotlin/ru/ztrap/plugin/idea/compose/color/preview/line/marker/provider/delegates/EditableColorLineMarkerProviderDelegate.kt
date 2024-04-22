package ru.ztrap.plugin.idea.compose.color.preview.line.marker.provider.delegates

import androidx.compose.ui.graphics.Color
import com.intellij.codeInsight.daemon.GutterIconNavigationHandler
import com.intellij.ide.IdeBundle
import com.intellij.openapi.application.runWriteAction
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.ui.ColorChooserService
import com.intellij.ui.awt.RelativePoint
import java.awt.event.MouseEvent
import org.jetbrains.kotlin.psi.KtBinaryExpression
import org.jetbrains.kotlin.psi.KtBlockExpression
import org.jetbrains.kotlin.psi.KtCallExpression
import org.jetbrains.kotlin.psi.KtDotQualifiedExpression
import org.jetbrains.kotlin.psi.KtNameReferenceExpression
import org.jetbrains.kotlin.psi.KtParameter
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.psi.KtPropertyAccessor
import org.jetbrains.kotlin.psi.KtPsiFactory
import org.jetbrains.kotlin.psi.KtReturnExpression
import org.jetbrains.kotlin.psi.KtValueArgument
import org.jetbrains.kotlin.psi.psiUtil.getChildOfType
import org.jetbrains.kotlin.psi.psiUtil.getParentOfType
import ru.ztrap.plugin.idea.compose.color.preview.line.marker.provider.ColorAwareLineMarkerInfo
import ru.ztrap.plugin.idea.compose.color.preview.utils.createColorFunction
import ru.ztrap.plugin.idea.compose.color.preview.utils.isComposeColorFun
import ru.ztrap.plugin.idea.compose.color.preview.utils.toAwtColor

private val ALLOWED_COLOR_SOURCE_PARENTS = arrayOf(
    KtBlockExpression::class,
    KtPropertyAccessor::class,
    KtBinaryExpression::class,
    KtReturnExpression::class,
    KtDotQualifiedExpression::class,
    KtValueArgument::class,
)

internal data object EditableColorLineMarkerProviderDelegate : LineMarkerProviderDelegate() {

    override val option = createOption("Color chooser")

    override fun getLineMarkerInfo(leaf: LeafPsiElement): ColorAwareLineMarkerInfo? {
        return findColorSource(leaf)
            ?.createColorFunction()
            ?.getColor()
            ?.toAwtColor()
            ?.let { color ->
                EditableColorLineMarkerInfo(
                    color = color,
                    message = IdeBundle.message("dialog.title.choose.color"),
                    anchor = leaf,
                    colorApplier = ::setColorTo,
                )
            }
    }

    private fun setColorTo(element: LeafPsiElement, awtColor: java.awt.Color) {
        val colorFunction = findColorSource(element)?.createColorFunction() ?: return
        val currentComposeColor = colorFunction.getColor() ?: return
        val newComposeColor = Color(awtColor.red, awtColor.green, awtColor.blue, awtColor.alpha)
            .convert(currentComposeColor.colorSpace)

        if (currentComposeColor == newComposeColor) return

        val factory = KtPsiFactory(element.project, true)
        colorFunction.setNewColor(newComposeColor, factory)
    }

    private fun findColorSource(element: PsiElement): KtCallExpression? {
        val callExpression = when (val parent = element.parent) {
            is KtParameter -> parent.getChildOfType<KtCallExpression>()
            is KtProperty -> parent.getChildOfType<KtCallExpression>()
            is KtNameReferenceExpression -> parent.getParentOfType<KtCallExpression>(strict = true)
                ?.takeIf { it.parent::class in ALLOWED_COLOR_SOURCE_PARENTS }

            else -> null
        }

        return callExpression?.takeIf(KtCallExpression::isComposeColorFun)
    }

    private class EditableColorLineMarkerInfo(
        color: java.awt.Color,
        message: String,
        anchor: LeafPsiElement,
        colorApplier: (element: LeafPsiElement, color: java.awt.Color) -> Unit,
    ) : ColorAwareLineMarkerInfo(
        color = color,
        anchor = anchor,
        tooltipText = message,
        navHandler = NavigationHandler(anchor, color, colorApplier),
    )

    private class NavigationHandler(
        private val anchor: LeafPsiElement,
        private val color: java.awt.Color,
        private val colorApplier: (element: LeafPsiElement, color: java.awt.Color) -> Unit,
    ) : GutterIconNavigationHandler<PsiElement> {
        override fun navigate(e: MouseEvent, elt: PsiElement) {
            if (!elt.isWritable) return

            ColorChooserService.instance.showPopup(
                project = anchor.project,
                currentColor = color,
                listener = { c, _ -> runWriteAction { colorApplier(anchor, c) } },
                location = RelativePoint(e.component, e.point),
                showAlpha = true,
            )
        }
    }
}