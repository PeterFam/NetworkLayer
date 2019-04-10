package com.starwallet.networklayer.ui.movies

data class Movie(val id :Int,val poster: String) {

    companion object {
        val empty = Movie(0, "")
    }
}