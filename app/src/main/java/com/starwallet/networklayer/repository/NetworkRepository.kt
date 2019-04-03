package com.starwallet.networklayer.repository

import com.starwallet.networklayer.data.model.AppResponses
import com.starwallet.networklayer.data.model.Movies
import com.starwallet.networklayer.data.remote.Either
import com.starwallet.networklayer.data.remote.Failure
import com.starwallet.networklayer.data.remote.NetworkAPIService
import com.starwallet.networklayer.data.remote.NetworkHandler
import com.starwallet.networklayer.data.remote.request.LoginRequest
import com.starwallet.networklayer.ui.login.LoginResponse
import retrofit2.Call
import javax.inject.Inject

interface NetworkRepository {
    //Here will put all requests needed

    fun loginRquest(loginRequest: LoginRequest)
            : Either<Failure, AppResponses>

    class Network
    @Inject constructor(
        private val networkHandler: NetworkHandler,
        private val service: NetworkAPIService

    ) : NetworkRepository {
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
                when (response.isSuccessful) {
                    true -> Either.Right(transform(response.body() ?: default))
                    false -> Either.Left(Failure.ServerError)
                }
            } catch (exception: Throwable) {
                Either.Left(Failure.ServerError)
            }
        }
    }


}



