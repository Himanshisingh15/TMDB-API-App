package com.example.tmdbapi.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdbapi.Interfaces.TvShowRecyclerViewClickListener
import com.example.tmdbapi.Response.TvShowResult
import com.example.tmdbapi.databinding.CustomTvshowListBinding
import com.squareup.picasso.Picasso

class TvShowRecyclerViewAdapter (private var context: Context, var tvList : TvShowResult, var tvShowRecyclerViewClickListener: TvShowRecyclerViewClickListener): RecyclerView.Adapter<TvShowRecyclerViewAdapter.MyViewHolder>() {

    inner class MyViewHolder(val bindingTv: CustomTvshowListBinding?) : RecyclerView.ViewHolder(bindingTv!!.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var bindingTv = CustomTvshowListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(bindingTv)
    }

    override fun getItemCount(): Int {
        return tvList.Result.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var tv = tvList.Result[position]

        var startUrl = "https://image.tmdb.org/t/p/w500"
        Picasso.get().load("$startUrl${tv.posterPath}").into(holder.bindingTv!!.tvShowImage)
        holder.bindingTv!!.tvShow.text = "Name : ${tv.name}"
        holder.bindingTv!!.tvTitle.text = "Popularity : ${tv.popularity}"

        holder.itemView.setOnClickListener {
            tvShowRecyclerViewClickListener.onTvShowItemClick(position, tvList)
        }
    }

}