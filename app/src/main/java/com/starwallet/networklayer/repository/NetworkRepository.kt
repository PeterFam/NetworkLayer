package com.starwallet.networklayer.repository

import com.starwallet.networklayer.data.model.Movies
import com.starwallet.networklayer.data.remote.Either
import com.starwallet.networklayer.data.remote.Failure
import com.starwallet.networklayer.data.remote.NetworkAPIService
import com.starwallet.networklayer.data.remote.NetworkHandler
import javax.inject.Inject

interface NetworkRepository{
    //Here will put all requests needed
    fun movies(): Either<Failure, List<Movies>>

    class Network
    @Inject constructor(private val networkHandler: NetworkHandler,
                        private val service: NetworkAPIService)

}



