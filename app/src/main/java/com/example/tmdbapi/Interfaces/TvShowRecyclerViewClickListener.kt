package com.example.tmdbapi.Interfaces

import com.example.tmdbapi.Response.TvShowResult

interface TvShowRecyclerViewClickListener {

    fun onTvShowItemClick(position : Int, tvShowList: TvShowResult)
}