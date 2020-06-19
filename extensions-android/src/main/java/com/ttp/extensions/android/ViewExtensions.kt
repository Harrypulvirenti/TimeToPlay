package com.ttp.extensions.android

import android.view.View
import androidx.annotation.DimenRes

fun View.getDimension(@DimenRes dimenRes: Int): Float =
    context.resources.getDimension(dimenRes)

fun View.getDimensionPixelSize(@DimenRes dimenRes: Int): Int =
    context.resources.getDimensionPixelSize(dimenRes)
