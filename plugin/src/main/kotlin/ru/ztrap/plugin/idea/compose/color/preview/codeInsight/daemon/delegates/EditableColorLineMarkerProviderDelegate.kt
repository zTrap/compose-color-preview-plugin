package ru.ztrap.plugin.idea.compose.color.preview.codeInsight.daemon.delegates

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
import org.jetbrains.kotlin.psi.KtValueArgumentName
import org.jetbrains.kotlin.psi.psiUtil.getCallNameExpression
import org.jetbrains.kotlin.psi.psiUtil.getChildOfType
import ru.ztrap.plugin.idea.compose.color.preview.codeInsight.daemon.ColorAwareLineMarkerInfo
import ru.ztrap.plugin.idea.compose.color.preview.utils.KEY_COMPOSE_COLOR_FQ
import ru.ztrap.plugin.idea.compose.color.preview.utils.createColorFunction
import ru.ztrap.plugin.idea.compose.color.preview.utils.firstSiblingOfTypeOrNull
import ru.ztrap.plugin.idea.compose.color.preview.utils.getInitializerOrGetterInitializer
import ru.ztrap.plugin.idea.compose.color.preview.utils.isComposeColorFun
import ru.ztrap.plugin.idea.compose.color.preview.utils.safeCast
import ru.ztrap.plugin.idea.compose.color.preview.utils.toAwtColor

internal data object EditableColorLineMarkerProviderDelegate : LineMarkerProviderDelegate() {

    override val option = createOption("Color chooser")

    override fun getLineMarkerInfo(leaf: LeafPsiElement): ColorAwareLineMarkerInfo? {
        val expression = findColorSource(leaf)
        return expression
            ?.createColorFunction()
            ?.getColor()
            ?.toAwtColor()
            ?.let { color ->
                leaf.putUserData(KEY_COMPOSE_COLOR_FQ, expression)
                EditableColorLineMarkerInfo(
                    color = color,
                    message = IdeBundle.message("dialog.title.choose.color"),
                    anchor = leaf,
                    colorApplier = EditableColorLineMarkerProviderDelegate::setColorTo,
                )
            }
    }

    private fun setColorTo(leaf: LeafPsiElement, awtColor: java.awt.Color) {
        val expression = leaf.getUserData(KEY_COMPOSE_COLOR_FQ) ?: findColorSource(leaf)
        val colorFunction = expression?.createColorFunction() ?: return
        val currentComposeColor = colorFunction.getColor() ?: return
        val newComposeColor = Color(awtColor.red, awtColor.green, awtColor.blue, awtColor.alpha)
            .convert(currentComposeColor.colorSpace)

        if (currentComposeColor == newComposeColor) return

        val factory = KtPsiFactory(leaf.project, true)
        colorFunction.setNewColor(newComposeColor, factory)
    }

    private fun findColorSource(leaf: LeafPsiElement): KtCallExpression? {
        val callExpression = when (val parent1 = leaf.parent) {
            is KtParameter -> parent1.getChildOfType<KtCallExpression>()
            is KtProperty -> parent1.getInitializerOrGetterInitializer()?.safeCast<KtCallExpression>()
            is KtNameReferenceExpression -> findCallByReferenceExpression(leaf, parent1)
            else -> null
        }

        return callExpression?.takeIf(KtCallExpression::isComposeColorFun)
    }

    private fun findCallByReferenceExpression(
        leaf: LeafPsiElement,
        reference: KtNameReferenceExpression,
    ): KtCallExpression? {
        return when (val refParent = reference.parent) {
            is KtValueArgumentName -> refParent.firstSiblingOfTypeOrNull<KtCallExpression>()
            is KtCallExpression -> when (val callParent = refParent.parent) {
                is KtParameter,
                is KtProperty,
                is KtPropertyAccessor,
                -> null // skip it, we've already attached icons to prop/param identifier

                is KtBlockExpression,
                is KtBinaryExpression,
                is KtReturnExpression,
                is KtDotQualifiedExpression,
                -> refParent.takeIf { refParent.getCallNameExpression()?.getIdentifier() == leaf }

                is KtValueArgument -> refParent.takeUnless { callParent.isNamed() }
                else -> refParent
            }

            else -> null
        }
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