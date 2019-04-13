package com.starwallet.networklayer.data.model

import com.starwallet.networklayer.ui.movies.Movie

data class MovieEntity(private val id:Int, private val poster: String) {

    fun toMovie() = Movie(id, poster)
}