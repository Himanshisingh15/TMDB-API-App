package com.example.tmdbapi.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdbapi.Interfaces.PersonalityRecyclerViewClickListener
import com.example.tmdbapi.Response.PersonalityResult
import com.example.tmdbapi.databinding.CustomPersonalityListBinding
import com.squareup.picasso.Picasso

class PersonalityRecyclerViewAdapter(private var context: Context, var personlist : PersonalityResult, var personalityRecyclerViewClickListener: PersonalityRecyclerViewClickListener): RecyclerView.Adapter<PersonalityRecyclerViewAdapter.MyViewHolder>() {

    inner class MyViewHolder(val bindingPerson: CustomPersonalityListBinding?) : RecyclerView.ViewHolder(bindingPerson!!.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var bindingPerson = CustomPersonalityListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(bindingPerson)
    }

    override fun getItemCount(): Int {
        return personlist.Result.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var person = personlist.Result[position]

        var startUrl = "https://image.tmdb.org/t/p/w500"
        Picasso.get().load("$startUrl${person.profilePath}").into(holder.bindingPerson!!.tvPersonImage)
        holder.bindingPerson!!.tvName.text = "Name : ${person.name}"
        holder.bindingPerson!!.tvTitle.text = "Popularity : ${person.popularity}"

        holder.itemView.setOnClickListener {
            personalityRecyclerViewClickListener.onPersonalityItemClick(position,personlist)
        }
    }

}