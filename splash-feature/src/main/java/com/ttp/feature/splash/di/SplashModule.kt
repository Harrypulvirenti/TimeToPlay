package com.ttp.feature.splash.di

import com.ttp.feature.splash.viewmodel.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val splashModule = module {

    viewModel { SplashViewModel() }
}
