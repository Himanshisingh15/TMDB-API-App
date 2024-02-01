package com.example.tmdbapi.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tmdbapi.R
import com.example.tmdbapi.databinding.ActivityMovieDetailsBinding
import com.squareup.picasso.Picasso

class MovieDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details)

        var data = intent
        var adult = data.getBooleanExtra("adult", true)
        var backDropPath = data.getStringExtra("backdrop_Path")
        var id = data.getIntExtra("id", 0)
        var original_language = data.getStringExtra("language")
        var original_title = data.getStringExtra("original_title")
        var overview = data.getStringExtra("overview")
        var popularity = data.getStringExtra("popularity")
        var poster_path = data.getStringExtra("imageUrl")
        var release_date = data.getStringExtra("releaseDate")
        var title = data.getStringExtra("title")
        var video = data.getStringExtra("video")
        var vote_average = data.getDoubleExtra("voteAverage",0.0)
        var vote_count = data.getStringExtra("vote_count")

        var startUrl = "https://image.tmdb.org/t/p/w500"
        Picasso.get().load("$startUrl$poster_path").into(binding.showMovieImage)

        binding.showTitle.text = "Title :  $title"
        binding.showLanguage.text = "Language : $original_language"
        binding.showReleaseDate.text = "Release Date : $release_date"
        binding.showRating.text = "Vote Average : $vote_average"
        binding.showOverview.text = "Overview : $overview"
    }
}