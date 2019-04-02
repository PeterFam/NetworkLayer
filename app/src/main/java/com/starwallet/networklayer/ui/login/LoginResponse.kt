package com.starwallet.networklayer.ui.login

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @field:SerializedName("token_type")
    val tokenType: String,

    @field:SerializedName("Bearer")
    val bearer: String,

    @field:SerializedName("expires_in")
    val expiresIn: Int,

    @field:SerializedName("access_token")
    val accessToken: String,

    @field:SerializedName("refresh_token")
    val refreshToken: String
)