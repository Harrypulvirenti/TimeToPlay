package com.ttp.feature.discovery.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.Player
import com.ttp.entities.Game
import com.ttp.extensions.android.inflate
import com.ttp.feature.discovery.R
import kotlinx.coroutines.flow.Flow

internal class GameAdapter(
    context: Context,
    private val playerController: Flow<Long>
) : ListAdapter<Game, GameViewHolder>(GameDiffUtils()) {

    private val exoPlayer = ExoPlayerFactory.newSimpleInstance(context).apply {
        repeatMode = Player.REPEAT_MODE_ALL
        volume = 0F
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder =
        GameViewHolder(parent.inflate(R.layout.viewpager_game_page))

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) =
        holder.bindView(getItem(position))

    override fun onViewAttachedToWindow(holder: GameViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.attachView(exoPlayer, playerController)
    }
}
