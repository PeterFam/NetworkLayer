package com.starwallet.networklayer.repository

import androidx.annotation.WorkerThread
import com.starwallet.networklayer.data.remote.Either
import com.starwallet.networklayer.data.remote.Failure
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async


abstract class UseCase <out Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): Either<Failure, Type>

    operator fun invoke(params: Params, onResult: (Either<Failure, Type>) -> Unit= {}) = {

    }
}