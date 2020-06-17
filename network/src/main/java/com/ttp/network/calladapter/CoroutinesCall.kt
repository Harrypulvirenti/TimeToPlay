package com.ttp.network.calladapter

import arrow.core.Either
import com.orhanobut.logger.Logger
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

internal class CoroutinesCall<T : Any>(
    private val proxyCall: Call<T>
) : Call<Either<Throwable, T>> {

    override fun enqueue(callback: Callback<Either<Throwable, T>>) =
        proxyCall.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {

                with(response) {
                    if (isSuccessful && body() != null) {
                        callback.notifyResult(Either.right(body()!!))
                    } else {
                        callback.notifyResult(Either.left(HttpException(this)))
                    }
                }
            }

            override fun onFailure(call: Call<T>, throwable: Throwable) {
                callback.notifyResult(Either.left(throwable))
                Logger.e(throwable.message.orEmpty(), throwable)
            }
        })

    override fun execute(): Response<Either<Throwable, T>> {
        throw UnsupportedOperationException("Coroutines call does not support synchronous execution")
    }

    override fun isCanceled(): Boolean = proxyCall.isCanceled

    override fun cancel() = proxyCall.cancel()

    override fun isExecuted(): Boolean = proxyCall.isExecuted

    override fun clone(): Call<Either<Throwable, T>> = CoroutinesCall(proxyCall.clone())

    override fun request(): Request = proxyCall.request()

    override fun timeout(): Timeout = proxyCall.timeout()

    internal fun Callback<Either<Throwable, T>>.notifyResult(result: Either<Throwable, T>) =
        onResponse(this@CoroutinesCall, Response.success(result))
}