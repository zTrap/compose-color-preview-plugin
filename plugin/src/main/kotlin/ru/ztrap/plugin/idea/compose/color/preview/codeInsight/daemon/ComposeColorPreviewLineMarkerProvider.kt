package ru.ztrap.plugin.idea.compose.color.preview.codeInsight.daemon

import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.LineMarkerProviderDescriptor
import com.intellij.codeInsight.daemon.LineMarkerSettings
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import org.jetbrains.kotlin.idea.KotlinLanguage
import org.jetbrains.kotlin.lexer.KtTokens
import ru.ztrap.plugin.idea.compose.color.preview.codeInsight.daemon.delegates.ColorConstantsLineMarkerProviderDelegate
import ru.ztrap.plugin.idea.compose.color.preview.codeInsight.daemon.delegates.ColorModifiersLineMarkerProviderDelegate
import ru.ztrap.plugin.idea.compose.color.preview.codeInsight.daemon.delegates.EditableColorLineMarkerProviderDelegate
import ru.ztrap.plugin.idea.compose.color.preview.utils.isInFileHeader

class ComposeColorPreviewLineMarkerProvider : LineMarkerProviderDescriptor() {
    private val delegates = arrayOf(
        EditableColorLineMarkerProviderDelegate,
        ColorConstantsLineMarkerProviderDelegate,
        ColorModifiersLineMarkerProviderDelegate,
    )

    private val options = Array(delegates.size) { index -> delegates[index].option }

    override fun getOptions(): Array<Option> = options
    override fun getName(): String = ""
    override fun getLineMarkerInfo(element: PsiElement): LineMarkerInfo<*>? = null
    override fun collectSlowLineMarkers(
        elements: MutableList<out PsiElement>,
        result: MutableCollection<in LineMarkerInfo<*>>,
    ) {
        if (elements.firstOrNull()?.language != KotlinLanguage.INSTANCE) return

        val settings = LineMarkerSettings.getSettings()
        elements.asSequence()
            .filterIsInstance<LeafPsiElement>()
            .filter { it.elementType == KtTokens.IDENTIFIER }
            .filterNot(LeafPsiElement::isInFileHeader)
            .forEach { leaf ->
                for (delegate in delegates) {
                    if (settings.isEnabled(delegate.option)) {
                        delegate.getLineMarkerInfo(leaf)?.let(result::add)
                    }
                }
            }
    }
}