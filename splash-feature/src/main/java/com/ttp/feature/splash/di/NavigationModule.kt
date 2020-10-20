package com.ttp.feature.splash.di

import com.ttp.feature.splash.R
import com.ttp.navigation.extensions.mainGraphContributor
import org.koin.dsl.module

val splashNavigationModule = module {
    mainGraphContributor(R.navigation.splash_nav_graph)
}
