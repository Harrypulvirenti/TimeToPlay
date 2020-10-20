package com.ttp.feature.splash.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ttp.core.utils.Event
import com.ttp.extensions.kotlin.lazyFast
import com.ttp.testimplementation.CoroutineTestRule
import dev.olog.flow.test.observer.test
import kotlinx.coroutines.delay
import org.junit.Rule
import org.junit.Test

internal class SplashViewModelTest {

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    private val sut by lazyFast { SplashViewModel(1L) }

    @Test
    fun `Should navigate to next section after waiting the delay time`() {
        coroutineTestRule.runBlockingTest {

            sut.navigationEvent.test(this) {
                delay(2L)
                assertValue(Event(Unit))
            }
        }
    }
}
