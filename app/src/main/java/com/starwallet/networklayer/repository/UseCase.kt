package com.starwallet.networklayer.repository

import android.content.Context
import com.starwallet.networklayer.data.remote.Either
import com.starwallet.networklayer.data.remote.Failure
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


abstract class UseCase<out Type, in Params>(private val scope: CoroutineScope) where Type : Any {
    //have to creat the job in the ViewModel to clear it after clearing the ViewModel
    abstract suspend fun run(params: Params): Either<Failure, Type>

   suspend operator fun invoke(params: Params, onResult: (Either<Failure, Type>) -> Unit = {}) = {
        scope.launch(Dispatchers.IO) {
            onResult(run(params))
        }
    }
}