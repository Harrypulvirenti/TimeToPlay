package com.ttp.navigation.extensions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.ttp.navigation.Navigator
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

inline fun <reified T : Navigator> FragmentActivity.navigator(): Lazy<T> =
    inject { parametersOf(this) }

inline fun <reified T : Navigator> Fragment.navigator(): Lazy<T> =
    inject { parametersOf(requireActivity()) }
