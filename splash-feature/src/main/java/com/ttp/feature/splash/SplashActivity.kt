package com.ttp.feature.splash

import android.os.Bundle
import com.ttp.core.base.BaseActivity
import com.ttp.extensions.android.replaceFragment
import com.ttp.feature.splash.di.splashModule
import org.koin.core.module.Module

internal class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceFragment<SplashFragment>(R.id.fragment_container)
    }

    override fun getKoinModules(): List<Module> = listOf(splashModule)
}