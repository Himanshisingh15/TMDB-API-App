package com.example.tmdbapi.ModelClass

import com.google.gson.annotations.SerializedName

data class TvShowData(
    @SerializedName("backdrop_path")
    var backdropPath : String,

    @SerializedName("first_air_date")
    var firstAd : String,

    @SerializedName("id")
    var id : Int,

    @SerializedName("name")
    var name : String,

    @SerializedName("original_language")
    var language : String,

    @SerializedName("original_name")
    var originalName : String,

    @SerializedName("overview")
    var overview : String,

    @SerializedName("popularity")
    var popularity : Double,

    @SerializedName("poster_path")
    var posterPath : String,

    @SerializedName("vote_average")
    var voteAverage : Float,

    @SerializedName("vote_count")
    var voteCount : Int

)
