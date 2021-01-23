package com.ttp.core.extensions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

inline fun <T : ViewBinding> ViewGroup.viewBinding(viewBindingFactory: (LayoutInflater, ViewGroup) -> T) =
    viewBindingFactory(LayoutInflater.from(context), this)

inline fun <T : ViewBinding> ViewGroup.viewBinding(
    viewBindingFactory: (LayoutInflater, ViewGroup, Boolean) -> T,
    attachToRoot: Boolean = false
) =
    viewBindingFactory(LayoutInflater.from(context), this, attachToRoot)
