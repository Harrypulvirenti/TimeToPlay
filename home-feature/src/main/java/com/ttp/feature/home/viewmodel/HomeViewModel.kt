package com.ttp.feature.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ttp.datasources.game.GameDataSource
import com.ttp.entities.Game
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class HomeViewModel(
    private val gameDataSource: GameDataSource
) : ViewModel() {

    private val _state = MutableStateFlow<List<Game>>(emptyList())

    val state: StateFlow<List<Game>>
        get() = _state

    fun getGames() {

        viewModelScope.launch {
            gameDataSource.getGames()
                .fold(
                    {},
                    {
                        _state.value = it
                    })
        }
    }
}