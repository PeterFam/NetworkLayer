package com.starwallet.networklayer.data.model

import com.google.gson.annotations.SerializedName


data class AppResponses(

    @field:SerializedName("code")
    val code: Int,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("item")
    val body: Any?
) {
    companion object {
        fun empty() = AppResponses(0, "", null)
    }

    fun toAppResponses() = AppResponses(code, message, body)

}