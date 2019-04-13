package com.starwallet.networklayer.ui.movies

import android.os.Bundle
import android.util.Log
import com.starwallet.networklayer.R
import com.starwallet.networklayer.helpers.extention.observe
import com.starwallet.networklayer.helpers.extention.viewModel
import com.starwallet.networklayer.ui.BaseActivity

class MoviesActivity : BaseActivity() {

    private lateinit var movieViewModel: MoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        appComponent.inject(this)

        movieViewModel = viewModel(viewModelFactory){
            observe(movies, ::renderMovies)
        }

        movieViewModel.loadMovies()
    }

    private fun renderMovies(movies: List<MovieView>?) {
        Log.d("movieees","I'am Here")
        Log.d("movieees", movies.toString())
    }
}
