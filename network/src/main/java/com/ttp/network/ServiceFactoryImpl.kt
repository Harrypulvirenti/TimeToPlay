package com.ttp.network

import com.ttp.network.calladapter.CoroutinesCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.reflect.KClass

private const val CONNECTION_TIMEOUT = 15L

internal class ServiceFactoryImpl(
    baseUrl: String,
    interceptors: List<Interceptor>,
    connectionTimeoutSeconds: Long = CONNECTION_TIMEOUT
) : ServiceFactory {

    private val retrofit: Retrofit

    init {

        val okHttpClient = OkHttpClient.Builder()
            .apply {
                connectTimeout(connectionTimeoutSeconds, TimeUnit.SECONDS)
                readTimeout(connectionTimeoutSeconds, TimeUnit.SECONDS)
                writeTimeout(connectionTimeoutSeconds, TimeUnit.SECONDS)

                interceptors.forEach { addInterceptor(it) }
            }.build()

        retrofit = Retrofit.Builder()
            .addCallAdapterFactory(CoroutinesCallAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()
    }

    override fun <R : Any> create(klass: KClass<R>): R =
        retrofit.create(klass.java)
}

inline fun <reified R : Any> ServiceFactory.create(): R = create(R::class)