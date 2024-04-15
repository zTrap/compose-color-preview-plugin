package ru.ztrap.plugin.idea.compose.color.preview.line.marker.provider

import androidx.compose.ui.graphics.Color
import com.intellij.openapi.editor.ElementColorProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import org.jetbrains.kotlin.idea.KotlinLanguage
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.KtBinaryExpression
import org.jetbrains.kotlin.psi.KtBlockExpression
import org.jetbrains.kotlin.psi.KtCallExpression
import org.jetbrains.kotlin.psi.KtDotQualifiedExpression
import org.jetbrains.kotlin.psi.KtNameReferenceExpression
import org.jetbrains.kotlin.psi.KtParameter
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.psi.KtPropertyAccessor
import org.jetbrains.kotlin.psi.KtPsiFactory
import org.jetbrains.kotlin.psi.KtReturnExpression
import org.jetbrains.kotlin.psi.KtValueArgument
import org.jetbrains.kotlin.psi.psiUtil.getChildOfType
import org.jetbrains.kotlin.psi.psiUtil.getParentOfType
import ru.ztrap.plugin.idea.compose.color.preview.utils.createColorFunction
import ru.ztrap.plugin.idea.compose.color.preview.utils.isComposeColorFun
import ru.ztrap.plugin.idea.compose.color.preview.utils.isInFileHeader
import ru.ztrap.plugin.idea.compose.color.preview.utils.toAwtColor

private val ALLOWED_COLOR_SOURCE_PARENTS = arrayOf(
    KtBlockExpression::class,
    KtPropertyAccessor::class,
    KtBinaryExpression::class,
    KtReturnExpression::class,
    KtDotQualifiedExpression::class,
    KtValueArgument::class,
)

class EditableColorLineMarkerProvider : ElementColorProvider {

    override fun getColorFrom(element: PsiElement): java.awt.Color? {
        if (element.language != KotlinLanguage.INSTANCE) return null
        if (element !is LeafPsiElement) return null
        if (element.elementType != KtTokens.IDENTIFIER) return null
        if (element.isInFileHeader) return null

        return findColorSource(element)
            ?.createColorFunction()
            ?.getColor()
            ?.toAwtColor()
    }

    override fun setColorTo(element: PsiElement, awtColor: java.awt.Color) {
        val colorFunction = findColorSource(element)?.createColorFunction() ?: return
        val currentComposeColor = colorFunction.getColor() ?: return
        val newComposeColor = Color(awtColor.red, awtColor.green, awtColor.blue, awtColor.alpha)
            .convert(currentComposeColor.colorSpace)

        if (currentComposeColor == newComposeColor) return

        val factory = KtPsiFactory(element.project, true)
        colorFunction.setNewColor(newComposeColor, factory)
    }

    private fun findColorSource(element: PsiElement): KtCallExpression? {
        val callExpression = when (val parent = element.parent) {
            is KtParameter -> parent.getChildOfType<KtCallExpression>()
            is KtProperty -> parent.getChildOfType<KtCallExpression>()
            is KtNameReferenceExpression -> parent.getParentOfType<KtCallExpression>(strict = true)
                ?.takeIf { it.parent::class in ALLOWED_COLOR_SOURCE_PARENTS }

            else -> null
        }

        return callExpression?.takeIf(::isComposeColorFun)
    }
}