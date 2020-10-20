package com.ttp.network.interceptor

import com.ttp.shared.interfaces.ApplicationBundle
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

internal class LoggingInterceptor(
    applicationBundle: ApplicationBundle,
    loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
) : Interceptor by loggingInterceptor {

    init {
        loggingInterceptor.level =
            if (applicationBundle.isDebug) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
    }
}
