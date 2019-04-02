package com.starwallet.networklayer.data.remote

import com.starwallet.networklayer.data.model.AppResponses
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

internal interface NetworkAPI {

//    @GET("/3/movie/popular")
//    fun getMovies(@Query("page") pageNumber: Int): Call<NetworkResponse>
//
//    @GET("")
//    fun getMoviesDetails(): Call<AppResponses>

    @GET("oauth/token")
    fun loginRequest(): Call<AppResponses>

}