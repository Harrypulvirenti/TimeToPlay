package com.ttp.feature.home.di

import com.ttp.feature.home.R
import com.ttp.navigation.extensions.mainGraphContributor
import org.koin.dsl.module

val homeNavigationModule = module {
    mainGraphContributor(R.navigation.home_nav_graph)
}
