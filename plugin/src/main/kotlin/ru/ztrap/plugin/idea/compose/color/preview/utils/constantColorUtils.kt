package ru.ztrap.plugin.idea.compose.color.preview.utils

import com.intellij.psi.PsiElement
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

internal fun resolveKtProperty(element: KtProperty): KtCallExpression? {
    if (element.isVar) return null
    val expression = element.getInitializerOrGetterInitializer() ?: return null
    return resolveConstantOrCtor(expression)
}

private fun resolveConstantOrCtor(element: PsiElement): KtCallExpression? {
    return when (element) {
        is KtCallExpression -> element
        is KtNameReferenceExpression -> resolveNameReference(element)
        is KtDotQualifiedExpression -> when (val selector = element.selectorExpression) {
            is KtNameReferenceExpression -> resolveNameReference(selector)
            is KtCallExpression -> selector
            else -> null
        }

        else -> null
    }
}