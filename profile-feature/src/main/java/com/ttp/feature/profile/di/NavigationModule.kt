package com.ttp.feature.profile.di

import com.ttp.feature.profile.R
import com.ttp.navigation.extensions.navGraph
import org.koin.dsl.module

val profileNavigationModule = module {
    navGraph(R.navigation.profile_nav_graph)
}