package com.ttp.app.di

import com.ttp.feature.home.di.homeNavigationModule
import com.ttp.feature.splash.di.splashNavigationModule

internal val appModules = splashNavigationModule + homeNavigationModule