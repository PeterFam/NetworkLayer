package com.starwallet.networklayer.repository

import com.starwallet.networklayer.data.model.AppResponses
import com.starwallet.networklayer.data.remote.Either
import com.starwallet.networklayer.data.remote.Failure
import com.starwallet.networklayer.data.remote.NetworkAPIService
import com.starwallet.networklayer.data.remote.NetworkHandler
import com.starwallet.networklayer.data.remote.request.LoginRequest
import com.starwallet.networklayer.ui.movies.Movie
import retrofit2.Call
import javax.inject.Inject

interface NetworkRepository {
    //Here will put all requests needed

    fun movies() : Either<Failure, List<Movie>>

    fun loginRquest(loginRequest: LoginRequest)
            : Either<Failure, AppResponses>


    class Network
    @Inject constructor(
        private val networkHandler: NetworkHandler,
        private val service: NetworkAPIService) : NetworkRepository {

        override fun movies(): Either<Failure, List<Movie>> {
            return when (networkHandler.isConnected) {
                true -> request(service.movies(), { it.map { it.toMovie() } }, emptyList())
                false, null -> Either.Left(Failure.NetworkConnection)
            }
        }

        override fun loginRquest(loginRequest: LoginRequest)
                : Either<Failure, AppResponses> {

            return when (networkHandler.isConnected) {
                true -> request(service.loginRequest(loginRequest), {it.toAppResponses()}, AppResponses.empty())
                false, null -> Either.Left(Failure.NetworkConnection)
            }
        }

        //this request is called when ever need to make a network call
        private fun <T, R> request(call: Call<T>, transform: (T) -> R, default: T): Either<Failure, R> {
            return try {
                val response = call.execute()
                when (response.code()) {
                    200 -> Either.Right(transform(response.body() ?: default))
                    401 -> Either.Left(Failure.Unauthorizes)
                    400 -> Either.Left(Failure.ServerError)
                    else -> Either.Left(Failure.NetworkConnection)

                }
            } catch (exception: Throwable) {
                Either.Left(Failure.ServerError)
            }
        }
    }
}



