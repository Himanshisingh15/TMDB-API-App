package com.example.tmdbapi.Interfaces

import com.example.tmdbapi.Response.MovieResult


interface MovieRecyclerViewClickListener {

    fun onMovieItemClick(position: Int, movieList: MovieResult)
}