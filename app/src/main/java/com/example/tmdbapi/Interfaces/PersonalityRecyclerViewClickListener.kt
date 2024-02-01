package com.example.tmdbapi.Interfaces

import com.example.tmdbapi.Response.PersonalityResult

interface PersonalityRecyclerViewClickListener {

    fun onPersonalityItemClick(position: Int, personalityList: PersonalityResult)
}