package com.ttp.feature.home.di

import com.ttp.datasources.di.gameRepositoryModules
import com.ttp.feature.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val internalModule = module {

    viewModel { HomeViewModel(get()) }
}

internal val homeModules = gameRepositoryModules + internalModule