package com.starwallet.networklayer.ui.login

import com.starwallet.networklayer.data.remote.Either
import com.starwallet.networklayer.data.remote.Failure
import com.starwallet.networklayer.data.remote.NetworkResponse
import com.starwallet.networklayer.repository.NetworkRepository
import com.starwallet.networklayer.repository.UseCase
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class LoginUseCase
@Inject constructor(private val networkWorkRepository: NetworkRepository,
                    private val scope: CoroutineScope)
    : UseCase<LoginResponse, UseCase.None>(scope) {

    override suspend fun run(params: None): Either<Failure, LoginResponse> {
        networkWorkRepository.loginRquest()
    }
}
