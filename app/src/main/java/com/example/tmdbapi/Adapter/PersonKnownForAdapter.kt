package com.example.tmdbapi.Adapter
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdbapi.ModelClass.PersonInfo
import com.example.tmdbapi.R
import com.example.tmdbapi.databinding.CustomViewPersonKnownForBinding
import com.squareup.picasso.Picasso

class PersonKnownForAdapter ( var personlist : PersonInfo): RecyclerView.Adapter<PersonKnownForAdapter.MyViewHolder>() {

    inner class MyViewHolder(val bindingPerson: CustomViewPersonKnownForBinding?) : RecyclerView.ViewHolder(bindingPerson!!.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var bindingPerson = CustomViewPersonKnownForBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(bindingPerson)
    }

    override fun getItemCount(): Int {
        return personlist.knownFor.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var person = personlist.knownFor[position]

        var startUrl = "https://image.tmdb.org/t/p/w500"
        Picasso.get().load("$startUrl${person.posterPath}").into(holder.bindingPerson!!.ivKnownFor)
        holder.bindingPerson!!.tvName.text = "Video : ${person.video}"
        holder.bindingPerson!!.tvTitle.text = "Title : ${person.title}"
        holder.bindingPerson!!.tvMediaType.text = "Media Type : ${person.mediaType}"
        holder.bindingPerson!!.tvOverview.text = "Overview : ${person.overview}"
        holder.bindingPerson!!.tvPopularity.text = "Original Language : ${person.originalLang}"
        holder.bindingPerson!!.tvAverageCount.text = "Average Count : ${person.average}"
        holder.bindingPerson!!.tvReleaseDate.text = "Release Date : ${person.releaseDate}"


    }

}