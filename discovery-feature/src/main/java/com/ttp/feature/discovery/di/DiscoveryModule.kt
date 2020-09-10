package com.ttp.feature.discovery.di

import com.ttp.datasources.di.gameRepositoryModules
import com.ttp.feature.discovery.viewmodel.DiscoveryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val internalModule = module {

    viewModel { DiscoveryViewModel(get()) }
}

internal val discoveryModules = gameRepositoryModules + internalModule