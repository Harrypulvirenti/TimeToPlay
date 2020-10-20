package com.ttp.network.calladapter

import arrow.core.Either
import java.lang.reflect.Type
import retrofit2.Call
import retrofit2.CallAdapter

internal class CoroutinesCallAdapter<T : Any>(
    private val successType: Type
) : CallAdapter<T, Call<Either<Throwable, T>>> {

    override fun responseType(): Type = successType

    override fun adapt(call: Call<T>): Call<Either<Throwable, T>> = CoroutinesCall(call)
}
