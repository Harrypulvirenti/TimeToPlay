package com.ttp.core.extensions

import androidx.fragment.app.Fragment
import com.ttp.core.utils.Event
import com.ttp.extensions.android.observe
import kotlinx.coroutines.flow.Flow

fun <T : Any> Fragment.observeEvent(flow: Flow<Event<T>>, block: suspend (T) -> Unit) =
    observe(flow) { it.handle(block) }