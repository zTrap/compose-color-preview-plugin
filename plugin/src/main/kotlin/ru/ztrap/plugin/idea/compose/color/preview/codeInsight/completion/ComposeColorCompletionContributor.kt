package ru.ztrap.plugin.idea.compose.color.preview.codeInsight.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementDecorator
import com.intellij.codeInsight.lookup.LookupElementPresentation
import com.intellij.util.ui.ColorIcon
import javax.swing.Icon
import org.jetbrains.kotlin.psi.KtProperty
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
                ?.let { ColorIcon(16, 12, it, true) }
                ?.let { ComposeColorLookupElementDecorator(lookupElement, it) }
                ?.let(completionResult::withLookupElement)
                ?: completionResult

            result.passResult(newResult)
        }
    }

    private class ComposeColorLookupElementDecorator(
        delegate: LookupElement,
        private val icon: Icon,
    ) : LookupElementDecorator<LookupElement>(delegate) {
        override fun renderElement(presentation: LookupElementPresentation) {
            super.renderElement(presentation)
            presentation.icon = icon
        }
    }
}