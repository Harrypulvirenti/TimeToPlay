package com.ttp.feature.discovery.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.core.view.isVisible
import com.google.android.exoplayer2.ExoPlayer
import com.ttp.core.coroutines.viewScope
import com.ttp.core.extensions.viewBinding
import com.ttp.entities.Game
import com.ttp.feature.discovery.databinding.ViewCarouselPlayerBinding
import com.ttp.feature.discovery.extensions.toMediaSource
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

    private val binding: ViewCarouselPlayerBinding

    private var data: Game? = null

    init {
        isVisible = false
        binding = viewBinding(ViewCarouselPlayerBinding::inflate)

        binding.carouselPlayer.clipToOutline = true
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
        binding.carouselPlayer.player = player
        url?.toMediaSource()?.let(player::prepare)
        delay(PLAYBACK_DELAY_TIME)
        isVisible = true
        player.play()
    }

    private fun stopPlaying() {
        isVisible = false
        binding.carouselPlayer.player = null
    }
}
