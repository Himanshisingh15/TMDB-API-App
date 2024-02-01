package com.example.tmdbapi.Repository

import androidx.lifecycle.MutableLiveData
import com.example.tmdbapi.Response.MovieResult
import com.example.tmdbapi.Response.PersonalityResult
import com.example.tmdbapi.Response.TvShowResult
import com.example.tmdbapi.Retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    var movieLiveData: MutableLiveData<MovieResult> = MutableLiveData<MovieResult>()
    var personLiveData : MutableLiveData<PersonalityResult> = MutableLiveData<PersonalityResult>()
    var tvShowLiveData : MutableLiveData<TvShowResult> = MutableLiveData<TvShowResult>()

    var isLoading : MutableLiveData<Boolean> = MutableLiveData<Boolean>().apply {
        value = true
    }

    fun getMovies(): MutableLiveData<MovieResult>{

        var call = RetrofitClient.apiCall.getMovies("e0ee72e426891d98d6e77019837aaea4")

        call.enqueue(object : Callback<MovieResult>{
            override fun onResponse(call: Call<MovieResult>, response: Response<MovieResult>) {
                if(response.isSuccessful){
                    movieLiveData.value = response.body()!!
                    isLoading.value = false
                }else{
                    isLoading.value = false
                }
            }

            override fun onFailure(call: Call<MovieResult>, t: Throwable) {
                isLoading.value = false
            }

        })
        return movieLiveData
    }

    fun getPerson(): MutableLiveData<PersonalityResult>{

        var call = RetrofitClient.apiCall.getPerson("e0ee72e426891d98d6e77019837aaea4")

        call.enqueue(object : Callback<PersonalityResult>{
            override fun onResponse(call: Call<PersonalityResult>, response: Response<PersonalityResult>) {
                if (response.isSuccessful){
                    personLiveData.value = response.body()!!
                    isLoading.value = false
                }else{
                    isLoading.value = false
                }
            }

            override fun onFailure(call: Call<PersonalityResult>, t: Throwable) {
                isLoading.value = false
            }
        })
        return personLiveData
    }

    fun getTvShow(): MutableLiveData<TvShowResult>{

        var call = RetrofitClient.apiCall.getTvShow("e0ee72e426891d98d6e77019837aaea4")

        call.enqueue(object : Callback<TvShowResult>{
            override fun onResponse(call: Call<TvShowResult>, response: Response<TvShowResult>) {
                if (response.isSuccessful){
                    tvShowLiveData.value = response.body()!!
                    isLoading.value = false
                }else{
                    isLoading.value = false
                }
            }

            override fun onFailure(call: Call<TvShowResult>, t: Throwable) {
                isLoading.value = false
            }
        })
        return  tvShowLiveData
    }


}