package com.ttp.core.coroutines

import android.os.Looper
import android.view.View
import androidx.core.view.doOnAttach
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.findViewTreeLifecycleOwner
import com.ttp.core.R
import com.ttp.extensions.android.awaitOnAttach
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import java.lang.ref.WeakReference
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

class ViewScope(
    view: View
) : CoroutineScope {

    private val context: CoroutineContext = SupervisorJob() + Dispatchers.Main.immediate

    private val view = WeakReference(view)

    override val coroutineContext: CoroutineContext
        get() = context

    fun launchWhenAttached(
        context: CoroutineContext = EmptyCoroutineContext,
        block: suspend CoroutineScope.() -> Unit
    ): Job {
        return launch(context) {
            view.get()?.awaitOnAttach() ?: return@launch
            block()
        }
    }
}

val View.viewScope: ViewScope
    get() {
        require(Looper.getMainLooper() == Looper.myLooper())

        return (getTag(R.id.tag_view_scope) as? ViewScope) ?: createScope()
    }

private fun View.createScope(): ViewScope {
    val scope = ViewScope(this)

    doOnAttach {
        AttachableView(this)
    }

    setTag(R.id.tag_view_scope, scope)
    return scope
}

private class AttachableView(
    view: View
) {

    internal val viewWeak = WeakReference(view)

    private val observer = object : DefaultLifecycleObserver {
        override fun onDestroy(owner: LifecycleOwner) {
            viewWeak.get()?.let {
                it.viewScope.cancel()
                it.removeOnAttachStateChangeListener(detachListener)
            }
        }
    }

    internal val detachListener = object : View.OnAttachStateChangeListener {

        override fun onViewDetachedFromWindow(v: View) {
            v.viewScope.coroutineContext.cancelChildren()
        }

        override fun onViewAttachedToWindow(v: View?) {}
    }

    init {
        view.findViewTreeLifecycleOwner()?.lifecycle?.addObserver(observer)
        view.addOnAttachStateChangeListener(detachListener)
    }
}
