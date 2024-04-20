package ru.ztrap.plugin.idea.compose.color.preview.line.marker.provider

import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.LineMarkerProviderDescriptor
import com.intellij.codeInsight.daemon.LineMarkerSettings
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import org.jetbrains.kotlin.idea.KotlinLanguage
import org.jetbrains.kotlin.lexer.KtTokens
import ru.ztrap.plugin.idea.compose.color.preview.line.marker.provider.delegates.ColorConstantsLineMarkerProviderDelegate
import ru.ztrap.plugin.idea.compose.color.preview.line.marker.provider.delegates.ColorModifiersLineMarkerProviderDelegate
import ru.ztrap.plugin.idea.compose.color.preview.line.marker.provider.delegates.EditableColorLineMarkerProviderDelegate
import ru.ztrap.plugin.idea.compose.color.preview.utils.isInFileHeader

class ComposeColorPreviewLineMarkerProvider : LineMarkerProviderDescriptor() {
    private val delegates = listOf(
        EditableColorLineMarkerProviderDelegate,
        ColorConstantsLineMarkerProviderDelegate,
        ColorModifiersLineMarkerProviderDelegate,
    )

    private val options = Array(delegates.size) { delegates[it].option }

    override fun getOptions(): Array<Option> = options
    override fun getName(): String = ""
    override fun getLineMarkerInfo(element: PsiElement): LineMarkerInfo<*>? = null
    override fun collectSlowLineMarkers(
        elements: MutableList<out PsiElement>,
        result: MutableCollection<in LineMarkerInfo<*>>,
    ) {
        val settings = LineMarkerSettings.getSettings()
        elements.asSequence()
            .filter { it.language == KotlinLanguage.INSTANCE }
            .filterIsInstance<LeafPsiElement>()
            .filter { it.elementType == KtTokens.IDENTIFIER }
            .filterNot { it.isInFileHeader }
            .flatMap { leaf ->
                delegates.filter { settings.isEnabled(it.option) }
                    .map { it.getLineMarkerInfo(leaf) }
            }
            .filterNotNull()
            .toCollection(result)
    }
}