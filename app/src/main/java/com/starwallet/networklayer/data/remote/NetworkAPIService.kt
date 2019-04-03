package com.starwallet.networklayer.data.remote

import com.starwallet.networklayer.data.model.AppResponses
import com.starwallet.networklayer.data.remote.request.LoginRequest
import com.starwallet.networklayer.ui.login.LoginResponse
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkAPIService
@Inject constructor(retrofit: Retrofit) : NetworkAPI {
    private val networkAPI by lazy {
        retrofit.create(NetworkAPI::class.java)
    }

    override fun loginRequest(loginRequest: LoginRequest): Call<AppResponses> =
        networkAPI.loginRequest(loginRequest)
}