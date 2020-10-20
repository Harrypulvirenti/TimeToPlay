package com.ttp.network.calladapter

import com.ttp.network.utils.Service
import com.ttp.network.utils.StringConverterFactory
import io.kotest.assertions.arrow.either.shouldBeLeft
import io.kotest.assertions.arrow.either.shouldBeRight
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.SocketPolicy
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.create
import java.util.concurrent.Executors

internal class ServiceTest {

    private val mockWebServer = MockWebServer()
    private val executor = Executors.newSingleThreadExecutor()
    private lateinit var retrofit: Retrofit

    private lateinit var service: Service

    @Before
    fun setup() {
        retrofit = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(StringConverterFactory())
            .addCallAdapterFactory(CoroutinesCallAdapterFactory())
            .callbackExecutor(executor)
            .build()

        service = retrofit.create()
    }

    @Test
    fun `Should return successful result`() {
        val responseBody = "Hi!"
        mockWebServer.enqueue(
            MockResponse()
                .setBody(responseBody)
                .setResponseCode(200)
                .setHeader("TEST", "test")
        )

        val response = runBlocking {
            service.getTextSuspend()
        }

        response.shouldBeRight(responseBody)
    }

    @Test
    fun `Should return error result for error response`() {
        val responseCode = 404
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(responseCode)
                .setHeader("TEST", "test")
        )
        val response = runBlocking { service.getTextSuspend() }

        response.shouldBeLeft()
    }

    @Test
    fun `Should return error result for network exception`() {
        mockWebServer.enqueue(
            MockResponse().apply {
                socketPolicy = SocketPolicy.DISCONNECT_AFTER_REQUEST
            }
        )

        val response = runBlocking { service.getTextSuspend() }

        response.shouldBeLeft()
    }

    @After
    fun tearDown() {
        mockWebServer.close()
        executor.shutdownNow()
    }
}
