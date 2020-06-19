package com.ttp.feature.home.adapter

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.RoundedCornersTransformation
import com.ttp.entities.Game
import com.ttp.extensions.android.getDimensionPixelSize
import com.ttp.feature.home.R
import com.ttp.feature.home.utils.LinearGradientTransformation

internal class GameViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val background: ImageView = view.findViewById(R.id.game_pager_background)
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
    }
}