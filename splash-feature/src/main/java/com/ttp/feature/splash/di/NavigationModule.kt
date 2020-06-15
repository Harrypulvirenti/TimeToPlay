package com.ttp.feature.splash.di

import com.ttp.feature.splash.R
import com.ttp.navigation.extensions.navGraph
import org.koin.dsl.module

val splashNavigationModule = module {
    navGraph(R.navigation.splash_nav_graph)
}