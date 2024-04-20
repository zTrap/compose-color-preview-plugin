package ru.ztrap.plugin.idea.compose.color.preview.line.marker.provider.delegates

import com.intellij.codeInsight.daemon.NavigateAction
import com.intellij.icons.AllIcons
import com.intellij.psi.PsiElement
import com.intellij.psi.SmartPsiElementPointer
import com.intellij.psi.impl.source.tree.LeafPsiElement
import java.awt.Color
import org.jetbrains.kotlin.psi.psiUtil.createSmartPointer
import ru.ztrap.plugin.idea.compose.color.preview.line.marker.provider.ColorAwareLineMarkerInfo
import ru.ztrap.plugin.idea.compose.color.preview.line.marker.provider.GoToSmartPointerNavigationHandler
import ru.ztrap.plugin.idea.compose.color.preview.utils.createColorFunction
import ru.ztrap.plugin.idea.compose.color.preview.utils.findColorConstantExpression
import ru.ztrap.plugin.idea.compose.color.preview.utils.toAwtColor

internal object ColorConstantsLineMarkerProviderDelegate : LineMarkerProviderDelegate() {

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
            ?.also(::setNavigateAction)
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