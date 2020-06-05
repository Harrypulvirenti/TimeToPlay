package com.ttp.feature.splash

import android.os.Bundle
import android.view.View
import com.ttp.core.base.BaseFragment
import com.ttp.core.extensions.observeEvent
import com.ttp.core.utils.SmartLogger
import com.ttp.feature.splash.viewmodel.SplashViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class SplashFragment : BaseFragment() {

    private val viewModel: SplashViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.fragment_splash

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeEvent(viewModel.navigationEvent) {
            SmartLogger.d("Navigate to home")
        }
    }
}