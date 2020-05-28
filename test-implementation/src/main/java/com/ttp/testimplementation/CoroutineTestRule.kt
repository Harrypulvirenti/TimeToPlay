package com.ttp.testimplementation

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class CoroutineTestRule : TestRule {

    val dispatcherProvider = TestDispatcherProvider()
    internal val coroutineScope = TestCoroutineScope(dispatcherProvider.dispatcher)

    override fun apply(base: Statement?, description: Description?): Statement =
        object : Statement() {

            @Throws(Throwable::class)
            override fun evaluate() {
                Dispatchers.setMain(dispatcherProvider.dispatcher)

                base?.evaluate()

                Dispatchers.resetMain()
                coroutineScope.cleanupTestCoroutines()
            }
        }

    fun runBlockingTest(block: suspend TestCoroutineScope.() -> Unit) =
        coroutineScope.runBlockingTest(block)
}