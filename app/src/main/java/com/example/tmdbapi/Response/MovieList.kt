package com.example.tmdbapi.Response

import com.example.tmdbapi.ModelClass.MoviesData
import com.google.gson.annotations.SerializedName

data class MovieResult(
    @SerializedName("results")
    var Result : List<MoviesData>
)