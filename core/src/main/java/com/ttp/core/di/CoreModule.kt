package com.ttp.core.di

import com.ttp.core.dispatcher.DispatcherProviderImpl
import com.ttp.core.initializer.CoreInitializer
import com.ttp.shared.interfaces.ApplicationBundle
import com.ttp.shared.interfaces.DispatcherProvider
import com.ttp.shared.interfaces.extensions.appInitializer
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

internal fun createCoreModule(isDebug: Boolean): Module = module {

    factory { ApplicationBundle(androidContext(), isDebug) }

    appInitializer { CoreInitializer(get()) }

    single<DispatcherProvider> { DispatcherProviderImpl() }
}
