package com.ttp.feature.home.adapter

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.google.android.exoplayer2.ExoPlayer
import com.ttp.entities.Game
import com.ttp.extensions.android.getDimensionPixelSize
import com.ttp.feature.home.R
import com.ttp.feature.home.ui.CarouselPlayerView
import com.ttp.feature.home.utils.LinearGradientTransformation
import kotlinx.coroutines.flow.Flow

internal class GameViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val background: ImageView = view.findViewById(R.id.game_pager_background)
    private val playerView: CarouselPlayerView = view.findViewById(R.id.game_pager_player)
    private val name: TextView = view.findViewById(R.id.game_pager_name)

    fun bindView(data: Game) {

        background.load(data.background) {
            transformations(
                LinearGradientTransformation(Color.BLACK),
                RoundedCornersTransformation(
                    background.getDimensionPixelSize(R.dimen.carousel_game_image_corner).toFloat()
                )
            )
        }

        name.text = data.name

        playerView.bind(data)
    }

    fun attachView(player: ExoPlayer, playerController: Flow<Long>) {
        playerView.initPlayer(player, playerController)
    }
}