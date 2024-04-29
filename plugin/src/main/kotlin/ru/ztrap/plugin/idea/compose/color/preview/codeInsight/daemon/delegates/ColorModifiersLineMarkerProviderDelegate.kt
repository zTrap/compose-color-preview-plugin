package ru.ztrap.plugin.idea.compose.color.preview.codeInsight.daemon.delegates

import com.intellij.psi.PsiElement
import com.intellij.psi.SmartPsiElementPointer
import com.intellij.psi.impl.source.tree.LeafPsiElement
import java.awt.Color
import org.jetbrains.kotlin.psi.KtCallExpression
import org.jetbrains.kotlin.psi.psiUtil.createSmartPointer
import org.jetbrains.kotlin.psi.psiUtil.getCallNameExpression
import org.jetbrains.kotlin.psi.psiUtil.getStrictParentOfType
import ru.ztrap.plugin.idea.compose.color.preview.codeInsight.daemon.ColorAwareLineMarkerInfo
import ru.ztrap.plugin.idea.compose.color.preview.codeInsight.daemon.GoToSmartPointerNavigationHandler
import ru.ztrap.plugin.idea.compose.color.preview.utils.createColorFunction
import ru.ztrap.plugin.idea.compose.color.preview.utils.isComposeColorModifierFun
import ru.ztrap.plugin.idea.compose.color.preview.utils.toAwtColor

internal data object ColorModifiersLineMarkerProviderDelegate : LineMarkerProviderDelegate() {

    override val option = createOption("Result of modifier functions")

    override fun getLineMarkerInfo(leaf: LeafPsiElement): ColorAwareLineMarkerInfo? {
        val expression = findModifierExpression(leaf)
        return expression?.createColorFunction()
            ?.getColor()
            ?.toAwtColor()
            ?.let { color ->
                ColorModifierLineMarkerInfo(
                    color = color,
                    anchor = leaf,
                    target = expression.createSmartPointer(),
                )
            }
    }

    private fun findModifierExpression(leaf: LeafPsiElement): KtCallExpression? {
        return leaf.getStrictParentOfType<KtCallExpression>()
            ?.takeIf { it.getCallNameExpression()?.getIdentifier() == leaf }
            ?.takeIf(KtCallExpression::isComposeColorModifierFun)
    }

    private class ColorModifierLineMarkerInfo(
        color: Color,
        anchor: LeafPsiElement,
        target: SmartPsiElementPointer<PsiElement>?,
    ) : ColorAwareLineMarkerInfo(
        color = color,
        anchor = anchor,
        tooltipText = "Result of ${anchor.text}",
        navHandler = target?.let(::GoToSmartPointerNavigationHandler),
    )
}