package com.ttp.network.calladapter

import arrow.core.Either
import com.ttp.network.utils.CompletableCall
import io.kotest.assertions.arrow.either.shouldBeLeft
import io.kotest.assertions.arrow.either.shouldBeRight
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Test
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

internal class CoroutinesCallTest {

    private val proxyCall = CompletableCall<String>()
    private val sut = CoroutinesCall(proxyCall)

    @Test
    fun `Should throw an error invoking execute`() {
        shouldThrow<UnsupportedOperationException> { sut.execute() }
    }

    @Test
    fun `Should delegate properties to proxyCall`() {
        with(sut) {
            isExecuted shouldBe proxyCall.isExecuted
            isCanceled shouldBe proxyCall.isCanceled
            request() shouldBe proxyCall.request()
        }
    }

    @Test
    fun `Should return new instance invoking clone`() {
        sut.clone() shouldNotBeSameInstanceAs sut
    }

    @Test
    fun `Should cancel proxyCall invoking cancel`() {
        sut.cancel()
        proxyCall.isCanceled shouldBe true
    }

    @Test
    fun `Should return successful call as Either right`() {
        val body = "body"

        sut.enqueueAsserting {
            isSuccessful shouldBe true
            body().shouldBeTypeOf<Either.Right<String>>()
            body()!!.shouldBeRight(body)
        }

        proxyCall.complete(body)
    }

    @Test
    fun `Should return error body as Either left`() {
        val errorBody = "An error occurred".toResponseBody()
        val responseCode = 404

        sut.enqueueAsserting {
            body()!!.shouldBeLeft()
        }

        proxyCall.complete(Response.error(responseCode, errorBody))
    }

    @Test
    fun `Should return unsuccessful call with Exception as Either left`() {
        val expectedException = IOException("exception")

        sut.enqueueAsserting {
            body()!!.shouldBeLeft(expectedException)
        }

        proxyCall.completeWithException(expectedException)
    }

    private fun <T : Any> CoroutinesCall<T>.enqueueAsserting(assert: Response<Either<Throwable, T>>.() -> Unit) =
        enqueue(object : Callback<Either<Throwable, T>> {
            override fun onResponse(
                call: Call<Either<Throwable, T>>,
                response: Response<Either<Throwable, T>>
            ) {
                response.assert()
            }

            override fun onFailure(call: Call<Either<Throwable, T>>, t: Throwable) =
                throw IllegalStateException()
        })
}