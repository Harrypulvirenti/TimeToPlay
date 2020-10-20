package com.ttp.navigation.extensions

import android.net.Uri
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.NavigationRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.ttp.navigation.GraphContributor
import org.koin.android.ext.android.getKoin

inline fun <reified T : GraphContributor> Fragment.setupSubGraph(
    navController: NavController,
    @NavigationRes subGraphId: Int
) {
    navController.setupContributors(
        subGraphId,
        getKoin().getGraphContributors<T>()
    )
}

fun Fragment.findChildNavController(@IdRes navHostFragmentId: Int): NavController =
    (childFragmentManager.findFragmentById(navHostFragmentId) as NavHostFragment).navController

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

/**
 * Return, if present, the current child [Fragment] displayed in the screen
 *
 * @return [Fragment]
 * */
val Fragment.currentChildFragment: Fragment?
    get() = childFragmentManager.primaryNavigationFragment

