package com.ttp.feature.discovery.adapter

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.google.android.exoplayer2.ExoPlayer
import com.ttp.entities.Game
import com.ttp.extensions.android.getDimensionPixelSize
import com.ttp.feature.discovery.R
import com.ttp.feature.discovery.databinding.ViewpagerGamePageBinding
import com.ttp.feature.discovery.utils.LinearGradientTransformation
import kotlinx.coroutines.flow.Flow

internal class GameViewHolder(private val binding: ViewpagerGamePageBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindView(data: Game) {
        binding.gamePagerBackground.load(data.background) {
            transformations(
                LinearGradientTransformation(Color.BLACK),
                RoundedCornersTransformation(
                    binding.gamePagerBackground.getDimensionPixelSize(R.dimen.carousel_game_image_corner).toFloat()
                )
            )
        }

        binding.gamePagerName.text = data.name

        binding.gamePagerPlayer.bind(data)
    }

    fun attachView(player: ExoPlayer, playerController: Flow<Long>) {
        binding.gamePagerPlayer.initPlayer(player, playerController)
    }
}
