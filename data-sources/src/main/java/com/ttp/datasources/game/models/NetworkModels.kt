package com.ttp.datasources.game.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class GameListResponse(
    val count: Long?,
    val next: String?,
    val previous: String?,
    val results: List<GameResponse>?
)

@JsonClass(generateAdapter = true)
internal data class GameResponse(
    val id: Long?,
    val name: String?,
    val background_image: String?,
    val rating: Double?,
    val rating_top: Int?,
    val ratings_count: Int?,
    val metacritic: Int?,
    val clip: ClipResponse?,
    val short_screenshots: List<ScreenShotResponse>?
)

@JsonClass(generateAdapter = true)
internal data class ClipResponse(
    val clip: String?
)

@JsonClass(generateAdapter = true)
internal data class ScreenShotResponse(
    val id: Long?,
    val image: String?
)