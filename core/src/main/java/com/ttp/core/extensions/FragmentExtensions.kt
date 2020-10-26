package com.ttp.core.extensions

import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.ttp.core.delegates.FragmentViewBindingDelegate
import com.ttp.core.utils.Event
import com.ttp.extensions.android.observe
import kotlinx.coroutines.flow.Flow

fun <T : Any> Fragment.observeEvent(flow: Flow<Event<T>>, block: suspend (T) -> Unit) =
    observe(flow) { it.handle(block) }

fun <T : ViewBinding> Fragment.viewBinding(viewBindingFactory: (View) -> T) =
    FragmentViewBindingDelegate(this, viewBindingFactory)
