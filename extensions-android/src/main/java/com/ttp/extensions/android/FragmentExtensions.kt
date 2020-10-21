package com.ttp.extensions.android

import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

fun <T : Any> Fragment.observe(flow: Flow<T>, block: suspend (T) -> Unit) =
    viewLifecycleOwner.lifecycleScope.launchWhenResumed {
        flow.onEach(block).collect()
    }

/**
 * Fragment handleOnBackPressed() invoked by the onBackPressedDispatcher, allow the current fragment to
 * handle the onBackPressed event.
 *
 * The onBackPressed lambda should return true if the event was handled by the fragment,
 * otherwise return false if the event should be handled by the activity.
 *
 * @see OnBackPressedCallback
 * */
fun Fragment.handleOnBackPressed(onBackPressed: () -> Boolean) {
    lifecycle.addObserver(
        object : DefaultLifecycleObserver {
            override fun onCreate(owner: LifecycleOwner) {
                activity?.onBackPressedDispatcher?.addCallback(
                    this@handleOnBackPressed,
                    object : OnBackPressedCallback(true) {
                        override fun handleOnBackPressed() {
                            if (!onBackPressed()) {
                                isEnabled = false
                                activity?.onBackPressed()
                            }
                        }
                    }
                )
            }
        }
    )
}
