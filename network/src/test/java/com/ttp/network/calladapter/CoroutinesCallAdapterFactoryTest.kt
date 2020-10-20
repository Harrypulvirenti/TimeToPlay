package com.ttp.network.calladapter

import arrow.core.Either
import com.ttp.network.utils.StringConverterFactory
import com.ttp.network.utils.typeOf
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe
import java.util.concurrent.Executors
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Call
import retrofit2.Retrofit

internal class CoroutinesCallAdapterFactoryTest {

    private val mockWebServer = MockWebServer()
    private val executor = Executors.newSingleThreadExecutor()
    private lateinit var retrofit: Retrofit

    private val sut = CoroutinesCallAdapterFactory()

    @Before
    fun setup() {
        retrofit = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(StringConverterFactory())
            .addCallAdapterFactory(sut)
            .callbackExecutor(executor)
            .build()
    }

    @Test
    fun `Should return a CoroutinesCallAdapter with the correct response type`() {
        val bodyClass = typeOf<Call<Either<Throwable, String>>>()

        sut.get(bodyClass, emptyArray(), retrofit)?.responseType() shouldBe String::class.java
    }

    @Test
    fun `Should return null if is not a call of Either type`() {
        val bodyClass = typeOf<Call<String>>()

        sut.get(bodyClass, emptyArray(), retrofit).shouldBeNull()
    }

    @Test
    fun `Should return null if the Error type of the Either is not Throwable`() {
        val bodyClass = typeOf<Call<Either<String, String>>>()

        sut.get(bodyClass, emptyArray(), retrofit).shouldBeNull()
    }

    @After
    fun tearDown() {
        mockWebServer.close()
        executor.shutdownNow()
    }
}
