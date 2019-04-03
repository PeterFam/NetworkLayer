package com.starwallet.networklayer.data.remote

import com.starwallet.networklayer.data.model.AppResponses
import com.starwallet.networklayer.data.remote.request.LoginRequest
import com.starwallet.networklayer.ui.login.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

internal interface NetworkAPI {

    @POST("oauth/token")
    fun loginRequest(@Body loginRequest: LoginRequest
    ): Call<AppResponses>

}