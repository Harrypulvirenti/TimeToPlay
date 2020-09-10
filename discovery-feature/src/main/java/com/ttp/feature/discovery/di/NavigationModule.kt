package com.ttp.feature.discovery.di

import com.ttp.feature.discovery.R
import com.ttp.navigation.extensions.navGraph
import org.koin.dsl.module

val discoveryNavigationModule = module {
    navGraph(R.navigation.discovery_nav_graph)
}