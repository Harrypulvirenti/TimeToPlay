package com.ttp.network

import retrofit2.http.GET

internal interface TestService {

    @GET("test")
    fun test()
}
