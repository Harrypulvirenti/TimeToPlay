package com.ttp.feature.splash.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ttp.core.coroutines.EventFlow
import com.ttp.core.coroutines.postEvent
import com.ttp.core.utils.Event
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

private const val SPLASH_DELAY_TIME = 2000L

internal class SplashViewModel(private val delayTime: Long = SPLASH_DELAY_TIME) : ViewModel() {

    private val _navigationEvent = EventFlow<Unit>()

    val navigationEvent: Flow<Event<Unit>>
        get() = _navigationEvent

    init {
        launchDelayedNavigation()
    }

    private fun launchDelayedNavigation() {
        viewModelScope.launch {
            delay(delayTime)
            _navigationEvent.postEvent(Unit)
        }
    }
}
