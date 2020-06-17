package com.ttp.entities

data class Game(
    val id: Long,
    val name: String,
    val background: String,
    val rating: Rating,
    val clip: String,
    val screenShots: List<ScreenShot>
)