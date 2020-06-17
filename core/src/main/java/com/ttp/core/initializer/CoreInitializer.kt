package com.ttp.core.initializer

import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.ttp.shared.interfaces.ApplicationBundle
import com.ttp.shared.interfaces.ApplicationInitializer

internal class CoreInitializer(bundle: ApplicationBundle) : ApplicationInitializer {

    init {
        if (bundle.isDebug) {
            Logger.addLogAdapter(AndroidLogAdapter())
        }
    }
}
