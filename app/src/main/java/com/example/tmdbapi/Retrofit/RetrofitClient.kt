package com.example.tmdbapi.Retrofit

import com.example.tmdbapi.Interfaces.ApiMethods
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val retrofitClient : Retrofit.Builder by lazy{
        Retrofit.Builder().baseUrl("https://api.themoviedb.org").addConverterFactory(GsonConverterFactory.create(Gson()))
    }

    val apiCall: ApiMethods by lazy {
        retrofitClient.build().create(ApiMethods::class.java)
    }
}