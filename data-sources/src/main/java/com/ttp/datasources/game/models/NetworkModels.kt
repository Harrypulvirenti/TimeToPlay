package com.ttp.datasources.game.models

import kotlinx.serialization.Serializable

@Serializable
internal data class GameListResponse(
    val count: Long? = null,
    val next: String? = null,
    val previous: String? = null,
    val results: List<GameResponse> = emptyList()
)

@Serializable
internal data class GameResponse(
    val id: Long = -1,
    val name: String = "",
    val background_image: String = "",
    val rating: Double = 0.0,
    val rating_top: Int = 5,
    val ratings_count: Int? = null,
    val metacritic: Int = 0,
    val clip: ClipResponse = ClipResponse(),
    val short_screenshots: List<ScreenShotResponse> = emptyList()
)

@Serializable
internal data class ClipResponse(
    val clip: String = ""
)

@Serializable
internal data class ScreenShotResponse(
    val id: Long = -1,
    val image: String = ""
)