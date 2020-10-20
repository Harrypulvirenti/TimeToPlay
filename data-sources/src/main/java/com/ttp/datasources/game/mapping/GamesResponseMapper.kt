package com.ttp.datasources.game.mapping

import com.ttp.datasources.game.models.GameListResponse
import com.ttp.datasources.game.models.GameResponse
import com.ttp.datasources.game.models.ScreenShotResponse
import com.ttp.entities.Game
import com.ttp.entities.Rating
import com.ttp.entities.ScreenShot

internal fun GameListResponse.toEntity(): List<Game> =
    results.map(GameResponse::toEntity)

internal fun GameResponse.toEntity(): Game =
    Game(
        id = id,
        name = name,
        background = background_image,
        rating = toRating(),
        clip = clip.clip,
        screenShots = short_screenshots.map(ScreenShotResponse::toEntity)
    )

internal fun GameResponse.toRating(): Rating =
    Rating(
        rating = rating,
        ratingMax = rating_top,
        metaCritic = metacritic
    )

internal fun ScreenShotResponse.toEntity(): ScreenShot =
    ScreenShot(
        id = id,
        url = image
    )
