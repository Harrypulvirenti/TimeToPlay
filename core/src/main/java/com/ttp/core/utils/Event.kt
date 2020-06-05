package com.ttp.core.utils

import kotlinx.coroutines.coroutineScope

/**
 * Used as a wrapper for data that is exposed via a StateFlow that represents an event.
 */
data class Event<out T : Any>(private val value: T? = null) {

    var hasBeenHandled = false
        private set

    /**
     * Returns the value and prevents its use again.
     */
    fun getIfNotHandled(): T? =
        value.takeIf { !hasBeenHandled }?.also {
            hasBeenHandled = true
        }

    fun handle(block: (T) -> Unit) =
        getIfNotHandled()?.let(block)

    suspend fun handle(block: suspend (T) -> Unit) = coroutineScope {
        getIfNotHandled()?.let {
            block(it)
        }
    }
}
