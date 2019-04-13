package com.starwallet.networklayer.ui.movies

import androidx.lifecycle.MutableLiveData
import com.starwallet.networklayer.repository.UseCase
import com.starwallet.networklayer.ui.BaseViewModel
import javax.inject.Inject

class MoviesViewModel
@Inject constructor(private val movieUseCase: MovieUseCase) : BaseViewModel() {

    var movies: MutableLiveData<List<MovieView>> = MutableLiveData()

    fun loadMovies() =
        movieUseCase(UseCase.None())
    { it.either(::handleFailure,
        ::handleMoviesList) }

    private fun handleMoviesList(movies: List<Movie>) {
        this.movies.value = movies.map { MovieView(it.id, it.poster) }
    }


}