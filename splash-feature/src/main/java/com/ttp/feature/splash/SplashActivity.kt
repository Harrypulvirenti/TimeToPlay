package com.ttp.feature.splash

import android.os.Bundle
import com.ttp.core.base.BaseActivity
import com.ttp.feature.splash.di.splashModule
import org.koin.core.module.Module

internal class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, SplashFragment())
            .commit()
    }

    override fun getKoinModules(): List<Module> = listOf(splashModule)
}