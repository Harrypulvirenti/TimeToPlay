package com.ttp.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.ttp.network.calladapter.CoroutinesCallAdapterFactory
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
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
        val json = Json {
            prettyPrint = true
            ignoreUnknownKeys = true
        }

        val okHttpClient = OkHttpClient.Builder()
            .apply {
                connectTimeout(connectionTimeoutSeconds, TimeUnit.SECONDS)
                readTimeout(connectionTimeoutSeconds, TimeUnit.SECONDS)
                writeTimeout(connectionTimeoutSeconds, TimeUnit.SECONDS)

                interceptors.forEach { addInterceptor(it) }
            }.build()

        retrofit = Retrofit.Builder()
            .addCallAdapterFactory(CoroutinesCallAdapterFactory())
            .addConverterFactory(json.asConverterFactory(JSON_CONTENT_TYPE.toMediaType()))
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()
    }

    override fun <R : Any> create(klass: KClass<R>): R =
        retrofit.create(klass.java)

    companion object {
        private const val JSON_CONTENT_TYPE = "application/json"
    }
}

inline fun <reified R : Any> ServiceFactory.create(): R = create(R::class)
