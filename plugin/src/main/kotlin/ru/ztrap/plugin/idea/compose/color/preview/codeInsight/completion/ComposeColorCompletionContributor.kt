package ru.ztrap.plugin.idea.compose.color.preview.codeInsight.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementDecorator
import com.intellij.codeInsight.lookup.LookupElementPresentation
import org.jetbrains.kotlin.psi.KtProperty
import ru.ztrap.plugin.idea.compose.color.preview.icon.ComposeColorIcon
import ru.ztrap.plugin.idea.compose.color.preview.utils.getColorOrNull
import ru.ztrap.plugin.idea.compose.color.preview.utils.resolveKtProperty
import ru.ztrap.plugin.idea.compose.color.preview.utils.safeCast
import ru.ztrap.plugin.idea.compose.color.preview.utils.toAwtColor

class ComposeColorCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        result.runRemainingContributors(parameters) { completionResult ->
            val lookupElement = completionResult.lookupElement

            val newResult = lookupElement.psiElement
                ?.navigationElement
                ?.safeCast<KtProperty>()
                ?.let(::resolveKtProperty)
                ?.getColorOrNull()
                ?.toAwtColor()
                ?.let { ComposeColorIcon(16, it) }
                ?.let { ComposeColorLookupElementDecorator(lookupElement, it) }
                ?.let(completionResult::withLookupElement)
                ?: completionResult

            result.passResult(newResult)
        }
    }

    private class ComposeColorLookupElementDecorator(
        delegate: LookupElement,
        private val icon: ComposeColorIcon,
    ) : LookupElementDecorator<LookupElement>(delegate) {
        override fun renderElement(presentation: LookupElementPresentation) {
            super.renderElement(presentation)
            presentation.icon = icon
        }
    }
}