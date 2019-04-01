package com.starwallet.networklayer.data.remote.request

import com.starwallet.networklayer.BuildConfig

data class LoginRequest(
    val username: String,
    val password: String,
    val client_id: Int = 2,
    val client_secret: String = BuildConfig.API_KEY,
    var grant_type: String = "password"
)