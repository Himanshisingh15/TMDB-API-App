package com.example.tmdbapi.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tmdbapi.Repository.Repository
import com.example.tmdbapi.Response.MovieResult
import com.example.tmdbapi.Response.PersonalityResult
import com.example.tmdbapi.Response.TvShowResult

class ViewModel: ViewModel() {
    var repository = Repository()
    var isLoading: MutableLiveData<Boolean> = repository.isLoading

    fun getMovies(): MutableLiveData<MovieResult>{
       return repository.getMovies()
    }

    fun getPerson(): MutableLiveData<PersonalityResult>{
        return repository.getPerson()
    }

    fun getTvShow(): MutableLiveData<TvShowResult>{
        return repository.getTvShow()
    }

}