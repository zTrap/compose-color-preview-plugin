package ru.ztrap.plugin.idea.compose.color.preview.line.marker.provider

import com.intellij.codeInsight.daemon.GutterIconNavigationHandler
import com.intellij.ide.util.EditSourceUtil
import com.intellij.pom.Navigatable
import com.intellij.psi.PsiElement
import com.intellij.psi.SmartPsiElementPointer
import java.awt.event.MouseEvent

internal class GoToSmartPointerNavigationHandler(
    private val target: SmartPsiElementPointer<PsiElement>,
) : GutterIconNavigationHandler<PsiElement> {
    override fun navigate(e: MouseEvent, elt: PsiElement) {
        target.element
            ?.let(EditSourceUtil::getDescriptor)
            ?.takeIf(Navigatable::canNavigate)
            ?.navigate(true)
    }
}