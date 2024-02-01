package com.example.tmdbapi.Response

import com.example.tmdbapi.ModelClass.TvShowData
import com.google.gson.annotations.SerializedName

data class TvShowResult(

    @SerializedName("results")
    var Result : List<TvShowData>
)