package com.ttp.app

import android.app.Application
import com.ttp.app.BuildConfig.DEBUG
import com.ttp.app.di.appModules
import com.ttp.core.extensions.initKoin

internal class MobileApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin(DEBUG, appModules)
    }
}
