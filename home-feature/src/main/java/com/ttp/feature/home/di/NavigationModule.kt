package com.ttp.feature.home.di

import com.ttp.feature.home.R
import com.ttp.navigation.extensions.navGraph
import org.koin.dsl.module

val homeNavigationModule = module {
    navGraph(R.navigation.home_nav_graph)
}