package com.ttp.navigation.extensions

import androidx.annotation.NavigationRes
import androidx.navigation.NavGraph
import androidx.navigation.NavInflater
import com.ttp.navigation.GraphContributor
import com.ttp.navigation.MainNavigation
import kotlin.reflect.typeOf
import org.koin.core.Koin
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.bind

fun Module.mainGraphContributor(@NavigationRes graphResId: Int) =
    subGraphContributor<MainNavigation>(graphResId)

@OptIn(ExperimentalStdlibApi::class)
inline fun <reified T : GraphContributor> Module.subGraphContributor(@NavigationRes graphResId: Int) =
    factory(named(graphResId.toString())) {
        val inflater: NavInflater = get()
        Pair(T::class, inflater.inflate(graphResId))
    } bind typeOf<Pair<T, NavGraph>>()::class

inline fun <reified T : GraphContributor> Koin.getGraphContributors(): List<NavGraph> =
    getAll<Pair<T, NavGraph>>().map { it.second }
