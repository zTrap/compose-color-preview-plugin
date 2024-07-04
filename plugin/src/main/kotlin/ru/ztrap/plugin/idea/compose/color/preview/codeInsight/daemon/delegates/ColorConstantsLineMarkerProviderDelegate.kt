package ru.ztrap.plugin.idea.compose.color.preview.codeInsight.daemon.delegates

import com.intellij.codeInsight.daemon.NavigateAction
import com.intellij.icons.AllIcons
import com.intellij.psi.PsiElement
import com.intellij.psi.SmartPsiElementPointer
import com.intellij.psi.createSmartPointer
import com.intellij.psi.impl.source.tree.LeafPsiElement
import java.awt.Color
import ru.ztrap.plugin.idea.compose.color.preview.codeInsight.daemon.ColorAwareLineMarkerInfo
import ru.ztrap.plugin.idea.compose.color.preview.codeInsight.daemon.GoToSmartPointerNavigationHandler
import ru.ztrap.plugin.idea.compose.color.preview.utils.createColorFunction
import ru.ztrap.plugin.idea.compose.color.preview.utils.findColorConstantExpression
import ru.ztrap.plugin.idea.compose.color.preview.utils.toAwtColor

internal data object ColorConstantsLineMarkerProviderDelegate : LineMarkerProviderDelegate() {

    override val option = createOption("Go to color declaration")

    override fun getLineMarkerInfo(leaf: LeafPsiElement): ColorAwareLineMarkerInfo? {
        val expression = findColorConstantExpression(leaf)
        return expression?.createColorFunction()
            ?.getColor()
            ?.toAwtColor()
            ?.let { color ->
                ColorConstantLineMarkerInfo(
                    color = color,
                    anchor = leaf,
                    target = expression.createSmartPointer(),
                )
            }
            ?.also(ColorConstantsLineMarkerProviderDelegate::setNavigateAction)
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
        color: Color,
        anchor: LeafPsiElement,
        target: SmartPsiElementPointer<PsiElement>?,
    ) : ColorAwareLineMarkerInfo(
        color = color,
        anchor = anchor,
        tooltipText = "Go To \"${anchor.text}\" Root Declaration",
        navHandler = target?.let(::GoToSmartPointerNavigationHandler),
    )
}