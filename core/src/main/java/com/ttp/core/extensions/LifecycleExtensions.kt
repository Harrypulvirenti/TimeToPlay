package com.ttp.core.extensions

import androidx.lifecycle.LifecycleOwner
import com.ttp.extensions.android.doOnCreate
import com.ttp.extensions.android.doOnDestroy
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.core.module.Module

/**
 * This method will load all the provided Koin Modules once the LifecycleOwner reach the onCreate status
 * and will unload the modules once the LifecycleOwner is Destroyed
 *
 * @param modules the Koin modules to be loaded
 * @see LifecycleOwner
 * @see Module
 * @see doOnCreate
 * @see doOnDestroy
 */
fun LifecycleOwner.registerKoinModules(vararg modules: Module) =
    registerKoinModules(modules.asList())

/**
 * This method will load all the provided Koin Modules once the LifecycleOwner reach the onCreate status
 * and will unload the modules once the LifecycleOwner is Destroyed
 *
 * @param modules the Koin modules to be loaded
 * @see LifecycleOwner
 * @see Module
 * @see doOnCreate
 * @see doOnDestroy
 */
fun LifecycleOwner.registerKoinModules(modules: List<Module>) {
    doOnCreate {
        loadKoinModules(modules)
    }
    doOnDestroy {
        unloadKoinModules(modules)
    }
}
