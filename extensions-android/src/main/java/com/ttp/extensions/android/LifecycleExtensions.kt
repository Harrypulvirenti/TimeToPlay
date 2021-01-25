package com.ttp.extensions.android

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

/**
 * This lambda will be invoked after the LifecycleOwner's onCreate method returns.
 *
 * @param onCreateAction the lambda to be invoked
 * @see LifecycleOwner
 * @see DefaultLifecycleObserver
 * @see DefaultLifecycleObserver.onCreate
 */
fun LifecycleOwner.doOnCreate(onCreateAction: () -> Unit) {
    lifecycle.addObserver(object : DefaultLifecycleObserver {
        override fun onCreate(owner: LifecycleOwner) {
            onCreateAction()
        }
    })
}

/**
 * This lambda will be invoked after the LifecycleOwner's onStart method returns.
 *
 * @param onStartAction the lambda to be invoked
 * @see LifecycleOwner
 * @see DefaultLifecycleObserver
 * @see DefaultLifecycleObserver.onStart
 */
fun LifecycleOwner.doOnStart(onStartAction: () -> Unit) {
    lifecycle.addObserver(object : DefaultLifecycleObserver {
        override fun onStart(owner: LifecycleOwner) {
            onStartAction()
        }
    })
}

/**
 * This lambda will be invoked after the LifecycleOwner's onResume method returns.
 *
 * @param onResumeAction the lambda to be invoked
 * @see LifecycleOwner
 * @see DefaultLifecycleObserver
 * @see DefaultLifecycleObserver.onResume
 */
fun LifecycleOwner.doOnResume(onResumeAction: () -> Unit) {
    lifecycle.addObserver(object : DefaultLifecycleObserver {
        override fun onResume(owner: LifecycleOwner) {
            onResumeAction()
        }
    })
}

/**
 * This lambda will be invoked before the LifecycleOwner's onPause method is called.
 *
 * @param onPauseAction the lambda to be invoked
 * @see LifecycleOwner
 * @see DefaultLifecycleObserver
 * @see DefaultLifecycleObserver.onPause
 */
fun LifecycleOwner.doOnPause(onPauseAction: () -> Unit) {
    lifecycle.addObserver(object : DefaultLifecycleObserver {
        override fun onPause(owner: LifecycleOwner) {
            onPauseAction()
        }
    })
}

/**
 * This lambda will be invoked before the LifecycleOwner's onStop method is called.
 *
 * @param onStopAction the lambda to be invoked
 * @see LifecycleOwner
 * @see DefaultLifecycleObserver
 * @see DefaultLifecycleObserver.onStop
 */
fun LifecycleOwner.doOnStop(onStopAction: () -> Unit) {
    lifecycle.addObserver(object : DefaultLifecycleObserver {
        override fun onStop(owner: LifecycleOwner) {
            onStopAction()
        }
    })
}

/**
 * This lambda will be invoked before the LifecycleOwner's onDestroy method is called.
 *
 * @param onDestroyAction the lambda to be invoked
 * @see LifecycleOwner
 * @see DefaultLifecycleObserver
 * @see DefaultLifecycleObserver.onDestroy
 */
fun LifecycleOwner.doOnDestroy(onDestroyAction: () -> Unit) {
    lifecycle.addObserver(object : DefaultLifecycleObserver {
        override fun onDestroy(owner: LifecycleOwner) {
            onDestroyAction()
        }
    })
}
