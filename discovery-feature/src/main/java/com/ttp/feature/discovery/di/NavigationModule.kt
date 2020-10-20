package com.ttp.feature.discovery.di

import com.ttp.feature.discovery.R
import com.ttp.navigation.HomeBottomNavigation
import com.ttp.navigation.extensions.subGraphContributor
import org.koin.dsl.module

val discoveryNavigationModule = module {
    subGraphContributor<HomeBottomNavigation>(R.navigation.discovery_nav_graph)
}
