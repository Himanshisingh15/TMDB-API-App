package com.example.tmdbapi.ModelClass

import com.google.gson.annotations.SerializedName

data class PersonalityData(

    @SerializedName("adult")
    var adult : Boolean,

    @SerializedName("backdrop_path")
    var backdropPath : String,

    @SerializedName("id")
    var id : Int,

    @SerializedName("media_type")
    var mediaType : String,

    @SerializedName("original_language")
    var originalLang : String,

    @SerializedName("original_title")
    var originalTitle : String,

    @SerializedName("overview")
    var overview : String,

    @SerializedName("poster_path")
    var posterPath : String,

    @SerializedName("release_date")
    var releaseDate : String,

    @SerializedName("title")
    var title : String,

    @SerializedName("video")
    var video : Boolean,

    @SerializedName("vote_average")
    var average : Float,

    @SerializedName("vote_count")
    var count: Long
    )
// yeh keys aayengi dekho aa rhi hin n
// ha ye aa rhi h // pr personinfo wali nhi aa rhi