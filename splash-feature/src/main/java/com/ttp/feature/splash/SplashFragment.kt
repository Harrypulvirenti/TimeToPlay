package com.ttp.feature.splash

import android.os.Bundle
import android.view.View
import com.ttp.core.base.BaseFragment
import com.ttp.core.extensions.observeEvent
import com.ttp.feature.splash.di.splashModule
import com.ttp.feature.splash.viewmodel.SplashViewModel
import com.ttp.navigation.extensions.navigate
import com.ttp.navigation.extensions.withNavOptions
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.module.Module

internal class SplashFragment : BaseFragment(R.layout.fragment_splash) {

    private val viewModel: SplashViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeEvent(viewModel.navigationEvent) {
            navigate(
                resId = R.id.splashToHome,
                navOptions = withNavOptions { setPopUpTo(R.id.splashFragment, true) }
            )
        }
    }

    override fun getKoinModules(): List<Module> = listOf(splashModule)
}