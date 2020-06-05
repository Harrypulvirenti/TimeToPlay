package com.ttp.core.coroutines

import com.ttp.core.utils.Event
import kotlinx.coroutines.flow.MutableStateFlow

typealias  EventFlow<T> = MutableStateFlow<Event<T>>

fun <T : Any> MutableStateFlow<Event<T>>.postEvent(value: T) {
    this.value = Event(value)
}

fun <T : Any> EventFlow(): EventFlow<T> = MutableStateFlow(Event())