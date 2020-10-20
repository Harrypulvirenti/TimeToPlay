package com.ttp.feature.discovery.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ttp.datasources.game.GameDataSource
import com.ttp.entities.Game
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.launch

internal class DiscoveryViewModel(
    private val gameDataSource: GameDataSource
) : ViewModel() {

    private val _playerController = BroadcastChannel<Long>(1)

    val playerController: Flow<Long>
        get() = _playerController.asFlow()

    private val _state = MutableStateFlow<List<Game>>(emptyList())

    val state: StateFlow<List<Game>>
        get() = _state

    fun onGamePageSelected(position: Int) {
        _state.value.getOrNull(position)?.let {
            _playerController.offer(it.id)
        }
    }

    fun getGames() {

        viewModelScope.launch {
            gameDataSource.getGames()
                .fold(
                    {},
                    {
                        _state.value = it
                    }
                )
        }
    }
}
