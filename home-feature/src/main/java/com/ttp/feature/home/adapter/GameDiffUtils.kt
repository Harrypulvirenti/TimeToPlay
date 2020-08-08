package com.ttp.feature.home.adapter

import androidx.recyclerview.widget.DiffUtil
import com.ttp.entities.Game

internal class GameDiffUtils : DiffUtil.ItemCallback<Game>() {
    override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean =
        oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean =
        oldItem == newItem
}