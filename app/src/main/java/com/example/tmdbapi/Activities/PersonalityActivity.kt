package com.example.tmdbapi.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbapi.Adapter.PersonalityRecyclerViewAdapter
import com.example.tmdbapi.Interfaces.PersonalityRecyclerViewClickListener
import com.example.tmdbapi.R
import com.example.tmdbapi.Response.PersonalityResult
import com.example.tmdbapi.ViewModels.ViewModel
import com.example.tmdbapi.databinding.ActivityPersonalityBinding

class PersonalityActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPersonalityBinding

    private lateinit var viewModel: ViewModel
    private lateinit var personAdapter : PersonalityRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_personality)

        viewModel = ViewModelProvider(this)[ViewModel::class.java]

        viewModel.getPerson().observe(this, Observer {
            personAdapter = PersonalityRecyclerViewAdapter(this,it, object : PersonalityRecyclerViewClickListener{
                override fun onPersonalityItemClick(position: Int, personList: PersonalityResult) {
//                    var person = personList.Result[position]
//                    personDetails(person.profilePath, person.name, person.popularity, person.mediaType, person.overview, person.title, person.average)
                    personDetails(position)

                }
            })

            binding.rvPerson.layoutManager = LinearLayoutManager(this)
            binding.rvPerson.adapter = personAdapter
            personAdapter.notifyDataSetChanged()
        })
    }
// ek min ruko session delete mat karna //
    fun personDetails(/*profilepath : String, name : String, popularity : String, mediaType : String, overview : String, title : String, average : Float,*/ position:Int){

        var intentPerson = Intent(this, PersonalityDetailsActivity::class.java)
//
//        intentPerson.putExtra("profilepath", profilepath)
//        intentPerson.putExtra("name", name)
//        intentPerson.putExtra("popularity",popularity)
//        intentPerson.putExtra("mediaType", mediaType)
//        intentPerson.putExtra("overview",overview)
//        intentPerson.putExtra("title",title)
//        intentPerson.putExtra("average", average)


    intentPerson.putExtra("position",position)
        startActivity(intentPerson)
    }
}