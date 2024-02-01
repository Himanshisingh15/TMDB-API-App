package com.example.tmdbapi.ModelClass

import com.google.gson.annotations.SerializedName

data class PersonInfo(

    @SerializedName("adult")
    var adult : Boolean,

    @SerializedName("gender")
    var gender : Int,

    @SerializedName("id")
    var id : Int,

    @SerializedName("known_for")
    var knownFor : List<PersonalityData>,

    @SerializedName("known_for_department")
    var knownForDept : String,

    @SerializedName("name")
    var name : String,

    @SerializedName("popularity")
    var popularity : String,

    @SerializedName("profile_path")
    var profilePath : String
)


