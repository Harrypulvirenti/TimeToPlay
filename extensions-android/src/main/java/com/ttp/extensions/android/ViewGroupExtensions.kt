package com.ttp.extensions.android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun ViewGroup.inflate(@LayoutRes layout: Int, attachToRoot: Boolean = false): View =
    LayoutInflater.from(context).inflate(layout, this, attachToRoot)