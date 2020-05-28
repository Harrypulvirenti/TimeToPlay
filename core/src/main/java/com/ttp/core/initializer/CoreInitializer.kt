package com.ttp.core.initializer

import com.ttp.core.utils.SmartLogger
import com.ttp.shared.interfaces.ApplicationBundle
import com.ttp.shared.interfaces.ApplicationInitializer

internal class CoreInitializer(bundle: ApplicationBundle) : ApplicationInitializer {

    init {
        SmartLogger.init(bundle.isDebug)
    }
}