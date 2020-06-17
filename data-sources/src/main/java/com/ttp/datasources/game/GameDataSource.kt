package com.ttp.datasources.game

import arrow.core.Either
import com.ttp.entities.Game

interface GameDataSource {

    suspend fun getGames(): Either<Throwable, List<Game>>
}