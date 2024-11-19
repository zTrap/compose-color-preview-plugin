package ru.ztrap.plugin.idea.compose.color.preview.utils

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.ExperimentalExtendedContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

internal inline fun <reified T : Any> T?.requireNotNull(): T = requireNotNull(this)

internal inline fun <reified T : Any> List<T?>.requireAllNotNull(): List<T> = map { it.requireNotNull() }

internal inline fun <reified T : Any> Any.safeCast(): T? = this as? T

internal inline fun <reified T : Any> Any.cast(): T = this as T

internal fun Float.isMaxComponent(): Boolean = this == MAX_COMPONENT_FLOAT

internal fun fractionToHex(fraction: Float): Int = (MAX_COMPONENT_HEX * fraction).toInt()

@OptIn(ExperimentalContracts::class, ExperimentalExtendedContracts::class)
internal inline fun <T : Any> T.modifyIf(condition: Boolean, modifier: T.() -> T): T {
    contract {
        condition holdsIn modifier
        callsInPlace(modifier, InvocationKind.AT_MOST_ONCE)
    }
    return if (condition) modifier() else this
}