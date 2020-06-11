package com.ttp.network.utils

import arrow.core.Either
import retrofit2.http.GET

internal interface Service {

    @GET("/suspend")
    suspend fun getTextSuspend(): Either<Throwable, String>
}