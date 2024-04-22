package ru.ztrap.plugin.idea.compose.color.preview.utils

internal inline fun <reified T : Any> T?.requireNotNull(): T = requireNotNull(this)

internal inline fun <reified T : Any> List<T?>.requireAllNotNull(): List<T> = map { it.requireNotNull() }

internal inline fun <reified T : Any> Any.safeCast(): T? = this as? T

internal inline fun <reified T : Any> Any.cast(): T = this as T

internal fun Float.isMaxComponent(): Boolean = this == MAX_COMPONENT_FLOAT

internal fun fractionToHex(fraction: Float): Int = (MAX_COMPONENT_HEX * fraction).toInt()

internal fun <T : Any, P : Any> T.modifyIfNotNull(param: P?, modifier: T.(P) -> T): T {
    return if (param != null) modifier(param) else this
}