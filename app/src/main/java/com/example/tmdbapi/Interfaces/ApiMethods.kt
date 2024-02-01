package com.example.tmdbapi.Interfaces

import com.example.tmdbapi.Response.MovieResult
import com.example.tmdbapi.Response.PersonalityResult
import com.example.tmdbapi.Response.TvShowResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiMethods {

    @GET("/3/movie/popular")
    fun  getMovies(@Query("api_key") apiKey: String): Call<MovieResult>

    @GET("3/person/popular")
    fun getPerson(@Query("api_key") apiKey: String): Call<PersonalityResult>

    @GET("3/tv/popular")
    fun getTvShow(@Query("api_key") apiKey: String): Call<TvShowResult>
}