package ru.ztrap.plugin.idea.compose.color.preview.utils

import com.intellij.psi.PsiElement
import org.jetbrains.kotlin.idea.intentions.callExpression
import org.jetbrains.kotlin.psi.KtCallExpression
import org.jetbrains.kotlin.psi.KtDotQualifiedExpression
import org.jetbrains.kotlin.psi.KtNameReferenceExpression
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.psi.psiUtil.getParentOfType

internal fun findColorConstantExpression(element: PsiElement): KtCallExpression? {
    return element.getParentOfType<KtNameReferenceExpression>(true)
        ?.let(::resolveNameReference)
        ?.takeIf(::isComposeColorFun)
}

internal fun resolveNameReference(element: KtNameReferenceExpression): KtCallExpression? {
    return when (val mainReference = element.resolveMainReference()?.navigationElement) {
        is KtProperty -> resolveKtProperty(mainReference)
        else -> null
    }
}

private fun resolveKtProperty(element: KtProperty): KtCallExpression? {
    if (element.isVar) return null
    val expression = element.getInitializerOrGetterInitializer() ?: return null

    return when (expression) {
        is KtCallExpression -> expression
        is KtNameReferenceExpression -> resolveNameReference(expression)
        is KtDotQualifiedExpression -> expression.callExpression
        else -> null
    }
}