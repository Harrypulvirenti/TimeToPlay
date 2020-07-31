package com.ttp.feature.home.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.core.view.isVisible
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ui.PlayerView
import com.ttp.core.coroutines.viewScope
import com.ttp.entities.Game
import com.ttp.extensions.android.inflate
import com.ttp.feature.home.R
import com.ttp.feature.home.extensions.play
import com.ttp.feature.home.extensions.toMediaSource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map

private const val PLAYBACK_DELAY_TIME = 2000L

internal class CarouselPlayerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val playerVew: PlayerView

    private var data: Game? = null

    init {
        isVisible = false
        inflate(R.layout.view_carousel_player, true)

        playerVew = findViewById(R.id.carousel_player)
        playerVew.clipToOutline = true
    }

    fun bind(data: Game) {
        this.data = data
    }

    fun initPlayer(player: ExoPlayer, playerController: Flow<Long>) {
        viewScope.launchWhenAttached {
            playerController
                .map { it == data?.id }
                .collect {
                    if (it) {
                        startPlaying(data?.clip, player)
                    } else {
                        stopPlaying()
                    }
                }
        }
    }

    private suspend fun startPlaying(url: String?, player: ExoPlayer) {
        playerVew.player = player
        url?.toMediaSource()?.let(player::prepare)
        delay(PLAYBACK_DELAY_TIME)
        isVisible = true
        player.play()
    }

    private fun stopPlaying() {
        isVisible = false
        playerVew.player = null
    }
}