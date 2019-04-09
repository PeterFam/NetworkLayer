package com.starwallet.networklayer.ui.login

import com.starwallet.networklayer.data.model.AppResponses
import com.starwallet.networklayer.data.remote.request.LoginRequest
import com.starwallet.networklayer.repository.NetworkRepository
import com.starwallet.networklayer.repository.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Named

class LoginUseCase
@Inject
constructor(
    private val networkWorkRepository: NetworkRepository,
    @Named("UseCaseScope") scope: CoroutineScope,
    @Named("UseCaseDispatcher") dispatcher: CoroutineDispatcher
) :
    UseCase<AppResponses, LoginUseCase.Params>(scope, dispatcher) {

    override suspend fun run(params: Params) =
        networkWorkRepository.loginRquest(params.loginRequest)

    data class Params(val loginRequest: LoginRequest)
}
