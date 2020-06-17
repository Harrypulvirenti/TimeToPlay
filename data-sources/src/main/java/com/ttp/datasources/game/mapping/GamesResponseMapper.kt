package com.ttp.datasources.game.mapping

import com.ttp.datasources.game.models.GameListResponse
import com.ttp.datasources.game.models.GameResponse
import com.ttp.datasources.game.models.ScreenShotResponse
import com.ttp.entities.Game
import com.ttp.entities.Rating
import com.ttp.entities.ScreenShot
import com.ttp.extensions.kotlin.or

internal fun GameListResponse.toEntity(): List<Game> =
    results.orEmpty().map(GameResponse::toEntity)

internal fun GameResponse.toEntity(): Game =
    Game(
        id = id or -1,
        name = name.orEmpty(),
        background = background_image.orEmpty(),
        rating = toRating(),
        clip = clip?.clip.orEmpty(),
        screenShots = short_screenshots.orEmpty().map(ScreenShotResponse::toEntity)
    )

internal fun GameResponse.toRating(): Rating =
    Rating(
        rating = rating or 0.0,
        ratingMax = rating_top or 5,
        metaCritic = metacritic or 0
    )

internal fun ScreenShotResponse.toEntity(): ScreenShot =
    ScreenShot(
        id = id or -1,
        url = image.orEmpty()
    )