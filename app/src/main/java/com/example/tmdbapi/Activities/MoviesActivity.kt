package com.example.tmdbapi.Activities

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbapi.Adapter.MovieRecyclerViewAdapter
import com.example.tmdbapi.Interfaces.MovieRecyclerViewClickListener
import com.example.tmdbapi.R
import com.example.tmdbapi.Response.MovieResult
import com.example.tmdbapi.ViewModels.ViewModel
import com.example.tmdbapi.databinding.ActivityMoviesBinding

class MoviesActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMoviesBinding

    private lateinit var viewModel: ViewModel
    private lateinit var movieAdapter : MovieRecyclerViewAdapter
    lateinit var progressBar : ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_movies)
        viewModel = ViewModelProvider(this)[ViewModel::class.java]

        progressBar = ProgressDialog(this)
        progressBar.setMessage("Loading, Please wait...")
        progressBar.setCancelable(false)
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        progressBar.show()

        viewModel.isLoading.observe(this, Observer {
            if (it) {
                progressBar.show()
            } else {
                progressBar.dismiss()
            }
        })

        viewModel.getMovies().observe(this, Observer {
            movieAdapter = MovieRecyclerViewAdapter(this, it, object : MovieRecyclerViewClickListener{
                override fun onMovieItemClick(position: Int, movieList: MovieResult) {
                    var movie = movieList.Result[position]
                    movieDetails(movie.adult, movie.backDropPath, movie.id, movie.language, movie.originalTitle, movie.overview, movie.imageUrl, movie.popularity, movie.releaseDate, movie.title, movie.video, movie.voteAverage, movie.voteCount)
                }

            })

            binding.rvMovies.layoutManager = LinearLayoutManager(this)
            binding.rvMovies.adapter = movieAdapter
            movieAdapter.notifyDataSetChanged()
        })
    }

    fun movieDetails(
        adult: Boolean, backDropPath: String, id: Int, language: String, originalTitle: String, overview: String, imageUrl: String, popularity: Double,
        releaseDate: String, title: String, video: Boolean, voteAverage: Double, voteCount: Int){

        var intentMovieDetails = Intent(this, MovieDetailsActivity::class.java)

        intentMovieDetails.putExtra("adult", adult)
        intentMovieDetails.putExtra("backDropPath", backDropPath)
        intentMovieDetails.putExtra("id", id)
        intentMovieDetails.putExtra("language", language)
        intentMovieDetails.putExtra("originalTitle", originalTitle)
        intentMovieDetails.putExtra("overview", overview)
        intentMovieDetails.putExtra("imageUrl", imageUrl)
        intentMovieDetails.putExtra("popularity", popularity)
        intentMovieDetails.putExtra("releaseDate", releaseDate)
        intentMovieDetails.putExtra("title", title)
        intentMovieDetails.putExtra("video", video)
        intentMovieDetails.putExtra("voteAverage", voteAverage)
        intentMovieDetails.putExtra("voteCount", voteCount)
        startActivity(intentMovieDetails)
    }

}