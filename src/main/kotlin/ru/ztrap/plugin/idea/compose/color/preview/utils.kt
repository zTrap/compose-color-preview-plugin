package ru.ztrap.plugin.idea.compose.color.preview

import androidx.compose.ui.graphics.Color as ComposeColor
import java.awt.Color as AwtColor
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiMember
import com.intellij.psi.PsiPackage
import org.jetbrains.kotlin.asJava.namedUnwrappedElement
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.psi.KtConstructor
import org.jetbrains.kotlin.psi.KtNamedDeclaration
import org.jetbrains.kotlin.psi.KtValueArgument
import org.jetbrains.kotlin.psi.psiUtil.astReplace

internal val PsiElement.kotlinFqOrConstructorName: FqName?
    get() = when (val element = namedUnwrappedElement) {
        is KtConstructor<*> -> element.containingKtFile.packageFqName.child(element.nameAsName)
        is PsiPackage -> FqName(element.qualifiedName)
        is PsiClass -> element.qualifiedName?.let(::FqName)
        is PsiMember -> element.getName()?.let { name ->
            val prefix = element.containingClass?.qualifiedName
            FqName(if (prefix != null) "$prefix.$name" else name)
        }
        is KtNamedDeclaration -> element.fqName
        else -> null
    }

@Suppress("UseJBColor")
internal fun ComposeColor.toAwtColor(): AwtColor? {
    return convert(ColorSpaces.Srgb)
        .runCatching { AwtColor(red, green, blue, alpha) }
        .onFailure { it.printStackTrace() }
        .getOrNull()
}

internal fun List<KtValueArgument>.findByNameOrIndex(name: String, index: Int): KtValueArgument? {
    val guess = get(index)
    val guessName = guess.getArgumentName()

    return if (guessName == null || guessName.text == name) {
        guess
    } else {
        find { it.getArgumentName()?.text == name }
    }
}

internal fun List<KtValueArgument>.getPackedARGB(): ColorsValueArgumentsPack.ARGB {
    return ColorsValueArgumentsPack.ARGB(
        red = findByNameOrIndex(COMPOSE_RED_ARG_NAME, 0).requireNotNull(),
        green = findByNameOrIndex(COMPOSE_GREEN_ARG_NAME, 1).requireNotNull(),
        blue = findByNameOrIndex(COMPOSE_BLUE_ARG_NAME, 2).requireNotNull(),
        alpha = findByNameOrIndex(COMPOSE_ALPHA_ARG_NAME, 3).requireNotNull(),
    )
}

internal fun List<KtValueArgument>.getPackedRGB(): ColorsValueArgumentsPack.RGB {
    return ColorsValueArgumentsPack.RGB(
        red = findByNameOrIndex(COMPOSE_RED_ARG_NAME, 0).requireNotNull(),
        green = findByNameOrIndex(COMPOSE_GREEN_ARG_NAME, 1).requireNotNull(),
        blue = findByNameOrIndex(COMPOSE_BLUE_ARG_NAME, 2).requireNotNull(),
    )
}

internal fun ColorsValueArgumentsPack.replace(pack: ColorsExpressionsPack) {
    red.lastChild.astReplace(pack.red)
    green.lastChild.astReplace(pack.green)
    blue.lastChild.astReplace(pack.blue)

    if (this is ColorsValueArgumentsPack.ARGB && pack is ColorsExpressionsPack.ARGB) {
        alpha.lastChild.astReplace(pack.alpha)
    }
}

private fun <T : Any> T?.requireNotNull(): T {
    return requireNotNull(this)
}