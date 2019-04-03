package com.starwallet.networklayer.ui.login

import com.starwallet.networklayer.data.model.AppResponses
import com.starwallet.networklayer.data.remote.Either
import com.starwallet.networklayer.data.remote.Failure
import com.starwallet.networklayer.data.remote.NetworkResponse
import com.starwallet.networklayer.data.remote.request.LoginRequest
import com.starwallet.networklayer.repository.NetworkRepository
import com.starwallet.networklayer.repository.UseCase
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class LoginUseCase
@Inject constructor(
    private val networkWorkRepository: NetworkRepository,
    private var scope: CoroutineScope)

    : UseCase<AppResponses, LoginUseCase.Params>() {
    override fun coroutiesScope(): CoroutineScope = scope


    override suspend fun run(params: Params): Either<Failure, AppResponses> =
        networkWorkRepository.loginRquest(params.loginRequest)

    data class Params(val loginRequest: LoginRequest)



}
