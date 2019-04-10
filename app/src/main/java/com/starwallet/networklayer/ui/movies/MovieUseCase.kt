package com.starwallet.networklayer.ui.movies

import com.starwallet.networklayer.repository.NetworkRepository
import com.starwallet.networklayer.repository.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Named

class MovieUseCase
    @Inject
    constructor(private val networkRepo: NetworkRepository,
                @Named("UseCaseScope") scope: CoroutineScope,
                @Named("UseCaseDispatcher") dispatcher: CoroutineDispatcher)
    : UseCase<List<Movie>, UseCase.None>(scope, dispatcher) {

    override suspend fun run(params: None) = networkRepo.movies()
}