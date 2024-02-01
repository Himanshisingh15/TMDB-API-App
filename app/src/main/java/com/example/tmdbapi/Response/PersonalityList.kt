package com.example.tmdbapi.Response

import com.example.tmdbapi.ModelClass.PersonInfo
import com.example.tmdbapi.ModelClass.PersonalityData
import com.google.gson.annotations.SerializedName

data class PersonalityResult(

    @SerializedName("results")
    var Result : List<PersonInfo>
)