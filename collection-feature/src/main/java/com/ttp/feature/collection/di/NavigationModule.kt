package com.ttp.feature.collection.di

import com.ttp.feature.collection.R
import com.ttp.navigation.extensions.navGraph
import org.koin.dsl.module

val collectionNavigationModule = module {
    navGraph(R.navigation.collection_nav_graph)
}