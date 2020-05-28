package com.ttp.shared.interfaces

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {

    val IO: CoroutineDispatcher

    val Default: CoroutineDispatcher

    val Main: CoroutineDispatcher
}
