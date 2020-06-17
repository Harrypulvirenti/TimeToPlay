package com.ttp.datasources.game

import arrow.core.Either
import com.ttp.datasources.game.mapping.toEntity
import com.ttp.datasources.game.models.GameListResponse
import com.ttp.datasources.game.services.GameService
import com.ttp.entities.Game
import com.ttp.shared.interfaces.DispatcherProvider
import kotlinx.coroutines.withContext

internal class GameDataSourceImpl(
    private val service: GameService,
    private val dispatcherProvider: DispatcherProvider
) : GameDataSource {

    override suspend fun getGames(): Either<Throwable, List<Game>> =
        withContext(dispatcherProvider.IO) {
            service.getGames()
                .map(GameListResponse::toEntity)
        }
}