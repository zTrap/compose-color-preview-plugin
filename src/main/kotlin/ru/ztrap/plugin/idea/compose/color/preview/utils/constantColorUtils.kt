package ru.ztrap.plugin.idea.compose.color.preview.utils

import com.intellij.psi.impl.source.tree.LeafPsiElement
import org.jetbrains.kotlin.psi.KtCallExpression
import org.jetbrains.kotlin.psi.KtDotQualifiedExpression
import org.jetbrains.kotlin.psi.KtNameReferenceExpression
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.psi.psiUtil.getStrictParentOfType

internal fun findColorConstantExpression(leaf: LeafPsiElement): KtCallExpression? {
    return leaf.getStrictParentOfType<KtNameReferenceExpression>()
        ?.let(::resolveNameReference)
        ?.takeIf(KtCallExpression::isComposeColorFun)
}

internal fun resolveNameReference(reference: KtNameReferenceExpression): KtCallExpression? {
    return when (val mainReference = reference.resolveMainReference()?.navigationElement) {
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
        is KtDotQualifiedExpression -> when (val selector = expression.selectorExpression) {
            is KtNameReferenceExpression -> resolveNameReference(selector)
            is KtCallExpression -> selector
            else -> null
        }

        else -> null
    }
}