package com.starwallet.networklayer.repository

import com.starwallet.networklayer.data.remote.Either
import com.starwallet.networklayer.data.remote.Failure
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


abstract class UseCase<out Type, in Params>(private val scope: CoroutineScope)
        where Type : Any {


    //have to creat the job in the ViewModel to clear it after clearing the ViewModel
    abstract suspend fun run(params: Params): Either<Failure, Type>

    operator fun invoke(params: Params, onResult: (Either<Failure, Type>) -> Unit = {}) = {
        //        onResult(run(params))
        scope.launch(Dispatchers.Default) {
            onResult(run(params))
        }
    }

    class None

}