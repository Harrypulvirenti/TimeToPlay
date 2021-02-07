package com.ttp.feature.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ttp.core.extensions.observeEvent
import com.ttp.core.extensions.registerKoinModules
import com.ttp.feature.splash.di.splashModule
import com.ttp.feature.splash.viewmodel.SplashViewModel
import com.ttp.navigation.extensions.navigate
import com.ttp.navigation.extensions.withNavOptions
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val viewModel: SplashViewModel by viewModel()

    init {
        registerKoinModules(splashModule)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeEvent(viewModel.navigationEvent) {
            navigate(
                resId = R.id.splashToHome,
                navOptions = withNavOptions { setPopUpTo(R.id.splashFragment, true) }
            )
        }
    }
}
