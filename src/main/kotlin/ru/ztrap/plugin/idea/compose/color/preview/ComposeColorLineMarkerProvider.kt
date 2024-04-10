package ru.ztrap.plugin.idea.compose.color.preview

import com.intellij.codeInsight.daemon.GutterIconNavigationHandler
import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.LineMarkerProvider
import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.ide.util.EditSourceUtil
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.pom.Navigatable
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.ui.scale.JBUIScale.scaleIcon
import com.intellij.util.ui.ColorIcon
import com.intellij.util.ui.ColorsIcon
import java.awt.Color
import java.awt.event.MouseEvent
import javax.swing.Icon
import org.jetbrains.kotlin.idea.KotlinLanguage
import org.jetbrains.kotlin.idea.caches.resolve.analyze
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.parcelize.serializers.matchesFqName
import org.jetbrains.kotlin.psi.KtCallExpression
import org.jetbrains.kotlin.psi.KtDotQualifiedExpression
import org.jetbrains.kotlin.psi.KtNameReferenceExpression
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.psi.KtReferenceExpression
import org.jetbrains.kotlin.psi.psiUtil.createSmartPointer
import org.jetbrains.kotlin.psi.psiUtil.getParentOfType
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.lazy.BodyResolveMode

class ComposeColorLineMarkerProvider : LineMarkerProvider {
    override fun getLineMarkerInfo(element: PsiElement): LineMarkerInfo<*>? = null
    override fun collectSlowLineMarkers(
        elements: MutableList<out PsiElement>,
        result: MutableCollection<in LineMarkerInfo<*>>,
    ) {
        elements.asSequence()
            .filter { it.language == KotlinLanguage.INSTANCE }
            .filterIsInstance<LeafPsiElement>()
            .filter { it.elementType == KtTokens.IDENTIFIER }
            .mapNotNullTo(result) { leaf ->
                val expression = findColorExpression(leaf)
                val color = expression?.getColor()?.toAwtColor()
                if (color != null) {
                    ComposeColorFieldLineMarkerInfo(
                        color = color,
                        message = leaf.text,
                        anchor = leaf,
                        target = expression.createSmartPointer()
                            .element
                            ?.let(EditSourceUtil::getDescriptor)
                            ?.takeIf { it.canNavigate() },
                    )
                } else {
                    null
                }
            }
    }

    private fun findColorExpression(element: LeafPsiElement): KtCallExpression? {
        return element.getParentOfType<KtNameReferenceExpression>(true)
            ?.takeIf(::isComposeColorType)
            ?.let(::resolveNameReference)
    }

    private fun resolveNameReference(element: KtNameReferenceExpression): KtCallExpression? {
        val mainReference = element.resolveMainReference()
        return if (mainReference is KtProperty) {
            resolveKtProperty(mainReference)
        } else {
            null
        }
    }

    private fun resolveKtProperty(element: KtProperty): KtCallExpression? {
        val expression = element.getInitializerOrGetterInitializer() ?: return null

        return when (expression) {
            is KtCallExpression -> expression
            is KtDotQualifiedExpression -> expression.lastChild
                .safeCast<KtNameReferenceExpression>()
                ?.let(::resolveNameReference)

            is KtNameReferenceExpression -> resolveNameReference(expression)
            else -> null
        }
    }

    private fun isComposeColorType(expression: KtReferenceExpression): Boolean {
        val bindingContext = expression.analyze(BodyResolveMode.PARTIAL)
        val type = bindingContext.get(BindingContext.SMARTCAST, expression)
            ?.defaultType
            ?: bindingContext.getType(expression)
        return type?.matchesFqName(COMPOSE_COLOR_FQ_NAME) == true
    }

    private class ComposeColorFieldLineMarkerInfo(
        private val color: Color,
        message: String,
        anchor: PsiElement,
        target: Navigatable?,
    ) : MergeableLineMarkerInfo<PsiElement>(
        /* element = */ anchor,
        /* textRange = */ anchor.textRange,
        /* icon = */ scaleIcon(ColorIcon(12, color)),
        /* tooltipProvider = */ { message },
        /* navHandler = */ target?.let(::NavigationHandler),
        /* alignment = */ GutterIconRenderer.Alignment.LEFT,
        /* accessibleNameProvider = */ { message },
    ) {
        override fun canMergeWith(info: MergeableLineMarkerInfo<*>): Boolean {
            return info is ComposeColorFieldLineMarkerInfo
        }

        override fun getCommonIcon(infos: MutableList<out MergeableLineMarkerInfo<*>>): Icon {
            return scaleIcon(
                ColorsIcon(
                    12,
                    *Array(infos.size) { infos[it].cast<ComposeColorFieldLineMarkerInfo>().color },
                ),
            )
        }
    }

    private class NavigationHandler(
        private val target: Navigatable,
    ) : GutterIconNavigationHandler<PsiElement> {
        override fun navigate(e: MouseEvent, elt: PsiElement) {
            target.navigate(true)
        }
    }
}