package com.ttp.feature.collection.di

import com.ttp.feature.collection.R
import com.ttp.navigation.HomeBottomNavigation
import com.ttp.navigation.extensions.subGraphContributor
import org.koin.dsl.module

val collectionNavigationModule = module {
    subGraphContributor<HomeBottomNavigation>(R.navigation.collection_nav_graph)
}
