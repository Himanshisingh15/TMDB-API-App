package com.example.tmdbapi.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.tmdbapi.R
import com.example.tmdbapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnMovies.setOnClickListener(this)
        binding.btnTvShow.setOnClickListener(this)
        binding.btnPersonality.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view!!.id){
            R.id.btn_movies -> {
                var intentMovies = Intent(this@MainActivity, MoviesActivity::class.java)
                startActivity(intentMovies)
            }

            R.id.btn_personality -> {
                var intentMovies = Intent(this@MainActivity, PersonalityActivity::class.java)
                startActivity(intentMovies)
            }

            R.id.btn_tvShow -> {
                var intentMovies = Intent(this@MainActivity, TvShowActivity::class.java)
                startActivity(intentMovies)
            }

        }
    }
}