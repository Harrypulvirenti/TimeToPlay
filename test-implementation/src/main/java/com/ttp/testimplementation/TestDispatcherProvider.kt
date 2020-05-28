package com.ttp.testimplementation

import com.ttp.shared.interfaces.DispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineDispatcher

class TestDispatcherProvider : DispatcherProvider {

    internal val dispatcher = TestCoroutineDispatcher()

    override val IO: CoroutineDispatcher = dispatcher

    override val Default: CoroutineDispatcher = dispatcher

    override val Main: CoroutineDispatcher = dispatcher
}