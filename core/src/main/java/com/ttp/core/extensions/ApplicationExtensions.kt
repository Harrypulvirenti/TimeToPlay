package com.ttp.core.extensions

import android.app.Application
import com.ttp.core.di.createCoreModule
import com.ttp.shared.interfaces.ApplicationInitializer
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.module.Module

fun Application.initKoin(isDebug: Boolean = false, modules: List<Module> = emptyList()) {

    startKoin {
        if (isDebug) {
            androidLogger(Level.DEBUG)
        }
        fragmentFactory()
        androidContext(this@initKoin)

        modules(modules + createCoreModule(isDebug))
    }

    getKoin().getAll<ApplicationInitializer>()
}
