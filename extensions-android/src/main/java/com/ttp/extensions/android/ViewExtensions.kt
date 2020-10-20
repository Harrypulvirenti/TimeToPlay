package com.ttp.extensions.android

import android.view.View
import androidx.annotation.DimenRes
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

fun View.getDimension(@DimenRes dimenRes: Int): Float =
    context.resources.getDimension(dimenRes)

fun View.getDimensionPixelSize(@DimenRes dimenRes: Int): Int =
    context.resources.getDimensionPixelSize(dimenRes)

suspend fun View.awaitOnAttach() = suspendCancellableCoroutine<Unit> { continuation ->
    if (isAttachedToWindow) {
        continuation.resume(Unit)
        return@suspendCancellableCoroutine
    }
    val listener = object : View.OnAttachStateChangeListener {

        override fun onViewAttachedToWindow(v: View) {
            removeOnAttachStateChangeListener(this)
            continuation.resume(Unit)
        }

        override fun onViewDetachedFromWindow(v: View) {}
    }
    addOnAttachStateChangeListener(listener)
    continuation.invokeOnCancellation { removeOnAttachStateChangeListener(listener) }
}
