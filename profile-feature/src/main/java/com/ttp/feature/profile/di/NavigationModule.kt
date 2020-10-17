package com.ttp.feature.profile.di

import com.ttp.feature.profile.R
import com.ttp.navigation.HomeBottomNavigation
import com.ttp.navigation.extensions.subGraphContributor
import org.koin.dsl.module

val profileNavigationModule = module {
    subGraphContributor<HomeBottomNavigation>(R.navigation.profile_nav_graph)
}