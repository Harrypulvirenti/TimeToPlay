package com.ttp.navigation.extensions

import android.net.Uri
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.findNavController

fun Fragment.navigate(
    @IdRes resId: Int,
    args: Bundle? = null,
    navOptions: NavOptions? = null
) = findNavController().navigate(resId, args, navOptions)

fun Fragment.navigate(
    deepLink: Uri,
    navOptions: NavOptions? = null,
    navigatorExtras: Navigator.Extras? = null
) = findNavController().navigate(deepLink, navOptions, navigatorExtras)

fun Fragment.navigate(
    request: NavDeepLinkRequest,
    navOptions: NavOptions? = null,
    navigatorExtras: Navigator.Extras? = null
) = findNavController().navigate(request, navOptions, navigatorExtras)

fun Fragment.navigate(
    directions: NavDirections,
    navOptions: NavOptions? = null
) = findNavController().navigate(directions, navOptions)

fun Fragment.navigate(
    directions: NavDirections,
    navigatorExtras: Navigator.Extras
) = findNavController().navigate(directions, navigatorExtras)

fun withNavOptions(configuration: NavOptions.Builder.() -> Unit): NavOptions =
    NavOptions.Builder().apply(configuration).build()