package com.ttp.feature.home.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.ttp.entities.Game
import com.ttp.extensions.android.inflate
import com.ttp.feature.home.R

internal class GameAdapter : ListAdapter<Game, GameViewHolder>(GameDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder =
        GameViewHolder(parent.inflate(R.layout.viewpager_game_page))

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) =
        holder.bindView(getItem(position))
}