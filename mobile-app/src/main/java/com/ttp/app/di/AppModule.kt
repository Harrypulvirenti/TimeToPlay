package com.ttp.app.di

import com.ttp.feature.collection.di.collectionNavigationModule
import com.ttp.feature.discovery.di.discoveryNavigationModule
import com.ttp.feature.home.di.homeNavigationModule
import com.ttp.feature.profile.di.profileNavigationModule
import com.ttp.feature.splash.di.splashNavigationModule

internal val appModules = listOf(
    splashNavigationModule,
    homeNavigationModule,
    discoveryNavigationModule,
    collectionNavigationModule,
    profileNavigationModule
)
