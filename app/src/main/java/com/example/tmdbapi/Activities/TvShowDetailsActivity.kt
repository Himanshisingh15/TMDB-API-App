package com.example.tmdbapi.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tmdbapi.R
import com.example.tmdbapi.databinding.ActivityTvShowDetailsBinding
import com.squareup.picasso.Picasso

class TvShowDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTvShowDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show_details)

        var data = intent
        var posterpath = data.getStringExtra("posterpath")
        var name = data.getStringExtra("name")
        var language = data.getStringExtra("language")
        var overview = data.getStringExtra("overview")
        var popularity = data.getDoubleExtra("popularity",0.0)
        var voteCount = data.getIntExtra("voteCount",1)

        var startUrl = "https://image.tmdb.org/t/p/w500"
        Picasso.get().load("$startUrl$posterpath").into(binding.showMovieImage)

        binding.showTitle.text = "Title : $name"
        binding.showLanguage.text = "Language : $language"
        binding.showOverview.text = "Overview : $overview"
        binding.showReleaseDate.text = "Popularity : $popularity"
        binding.showRating.text = "Rating : $voteCount"
    }
}