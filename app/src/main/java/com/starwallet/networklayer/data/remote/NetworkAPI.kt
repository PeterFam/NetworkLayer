package com.starwallet.networklayer.data.remote

import com.starwallet.networklayer.data.model.AppResponses
import com.starwallet.networklayer.data.remote.request.LoginRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

internal interface NetworkAPI {

    @POST("oauth/token")
    fun loginRequest(@Body loginRequest: LoginRequest
    ): Call<AppResponses>

}