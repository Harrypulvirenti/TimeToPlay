package com.ttp.network.di

import com.ttp.network.BuildConfig.BASE_URL
import com.ttp.network.ServiceFactory
import com.ttp.network.ServiceFactoryImpl
import com.ttp.network.interceptor.LoggingInterceptor
import okhttp3.Interceptor
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule = module {

    factory { LoggingInterceptor(get()) } bind Interceptor::class

    factory<ServiceFactory>(override = true) { ServiceFactoryImpl(BASE_URL, getAll()) }
}
