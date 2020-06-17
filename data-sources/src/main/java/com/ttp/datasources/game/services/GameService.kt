package com.ttp.datasources.game.services

import arrow.core.Either
import com.ttp.datasources.game.models.GameListResponse
import retrofit2.http.GET

internal interface GameService {

    @GET("games")
    suspend fun getGames(): Either<Throwable, GameListResponse>
}