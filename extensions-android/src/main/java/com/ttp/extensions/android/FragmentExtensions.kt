package com.ttp.extensions.android

import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

fun <T : Any> Fragment.observe(flow: Flow<T>, block: suspend (T) -> Unit) =
    flow.onEach(block)
        .launchIn(viewLifecycleOwner.lifecycleScope)