package ru.ztrap.plugin.idea.compose.color.preview.codeInsight.daemon.delegates

import androidx.compose.ui.graphics.Color
import com.intellij.codeInsight.daemon.GutterIconNavigationHandler
import com.intellij.ide.IdeBundle
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
import ru.ztrap.plugin.idea.compose.color.preview.utils.toComposeColor

internal data object EditableColorLineMarkerProviderDelegate : LineMarkerProviderDelegate() {

    override val option = createOption("Color chooser")

    override fun getLineMarkerInfo(leaf: LeafPsiElement): ColorAwareLineMarkerInfo? {
        val expression = findColorSource(leaf)
        val colorFunction = expression?.createColorFunction() ?: return null
        val composeColor = colorFunction.getColor() ?: return null
        val awtColor = composeColor.toAwtColor() ?: return null

        leaf.putUserData(KEY_COMPOSE_COLOR_FQ, colorFunction)
        return EditableColorLineMarkerInfo(
            color = awtColor,
            message = IdeBundle.message("dialog.title.choose.color"),
            anchor = leaf,
            colorApplier = { selectedAwtColor -> setColorTo(leaf, composeColor, selectedAwtColor) },
        )
    }

    private fun setColorTo(leaf: LeafPsiElement, currentComposeColor: Color, selectedAwtColor: java.awt.Color) {
        val colorFunction = leaf.getUserData(KEY_COMPOSE_COLOR_FQ) ?: return
        val newComposeColor = selectedAwtColor.toComposeColor().convert(currentComposeColor.colorSpace)

        if (currentComposeColor == newComposeColor) return

        val factory = KtPsiFactory(leaf.project, true)
        colorFunction.setNewColor(newComposeColor, factory)
    }

    private fun findColorSource(leaf: LeafPsiElement): KtCallExpression? {
        val callExpression = when (val parent = leaf.parent) {
            is KtParameter -> parent.getChildOfType<KtCallExpression>()
            is KtProperty -> parent.getInitializerOrGetterInitializer()?.safeCast<KtCallExpression>()
            is KtNameReferenceExpression -> findCallByReferenceExpression(leaf, parent)
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
        colorApplier: (color: java.awt.Color) -> Unit,
    ) : ColorAwareLineMarkerInfo(
        color = color,
        anchor = anchor,
        tooltipText = message,
        navHandler = NavigationHandler(anchor, color, colorApplier),
    )

    private class NavigationHandler(
        private val anchor: LeafPsiElement,
        private val color: java.awt.Color,
        private val colorApplier: (color: java.awt.Color) -> Unit,
    ) : GutterIconNavigationHandler<PsiElement> {
        override fun navigate(e: MouseEvent, elt: PsiElement) {
            if (!elt.isWritable) return

            ColorChooserService.instance.showPopup(
                project = anchor.project,
                currentColor = color,
                listener = { c, _ -> colorApplier(c) },
                location = RelativePoint(e.component, e.point),
                showAlpha = true,
            )
        }
    }
}