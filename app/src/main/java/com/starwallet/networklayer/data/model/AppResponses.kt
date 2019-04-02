package com.starwallet.networklayer.data.model


data class AppResponses<Body> (
    val code: Int,
    val message: String,
    val body: Body
){
    companion object {
        fun empty() = AppResponses(0, "", null)
    }

}