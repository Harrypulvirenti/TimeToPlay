package com.ttp.core.delegates

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.viewbinding.ViewBinding
import com.ttp.extensions.android.doOnCreate
import com.ttp.extensions.android.doOnDestroy
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class FragmentViewBindingDelegate<T : ViewBinding>(
    private val fragment: Fragment,
    private val viewBindingFactory: (View) -> T
) : ReadOnlyProperty<Fragment, T> {
    internal var binding: T? = null

    init {
        with(fragment) {
            doOnCreate {
                viewLifecycleOwnerLiveData.observe(this@with) { viewLifecycleOwner ->
                    viewLifecycleOwner.doOnDestroy {
                        binding = null
                    }
                }
            }
        }
    }

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        val binding = binding
        if (binding != null) {
            return binding
        }

        val lifecycle = fragment.viewLifecycleOwner.lifecycle
        if (!lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED)) {
            throw IllegalStateException("Should not attempt to get bindings when Fragment views are destroyed.")
        }

        return viewBindingFactory(thisRef.requireView()).also { this.binding = it }
    }
}
