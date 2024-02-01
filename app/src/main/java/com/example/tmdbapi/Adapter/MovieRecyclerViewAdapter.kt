package com.example.tmdbapi.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdbapi.Interfaces.MovieRecyclerViewClickListener
import com.example.tmdbapi.Response.MovieResult
import com.example.tmdbapi.databinding.CustomMovieListBinding
import com.squareup.picasso.Picasso

class MovieRecyclerViewAdapter(private var context: Context, var movieList: MovieResult, var movieRecyclerViewClickListener: MovieRecyclerViewClickListener): RecyclerView.Adapter<MovieRecyclerViewAdapter.MyViewHolder>() {

    inner class MyViewHolder(val bindingMovie: CustomMovieListBinding?): RecyclerView.ViewHolder(bindingMovie!!.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var bindingMovie = CustomMovieListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(bindingMovie)
    }

    override fun getItemCount(): Int {
        return movieList.Result.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var movies = movieList.Result[position]

        var startUrl = "https://image.tmdb.org/t/p/w500"
        Picasso.get().load("$startUrl${movies.imageUrl}").into(holder.bindingMovie!!.tvMovieImage)
        holder.bindingMovie!!.tvTitle.text = "Title : ${movies.title}"

        holder.itemView.setOnClickListener {
            movieRecyclerViewClickListener.onMovieItemClick(position, movieList)
        }
    }


}