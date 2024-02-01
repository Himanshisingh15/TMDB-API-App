package com.example.tmdbapi.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbapi.Adapter.PersonKnownForAdapter
import com.example.tmdbapi.R
import com.example.tmdbapi.ViewModels.ViewModel
import com.example.tmdbapi.databinding.ActivityPersonalityDetailsBinding

class PersonalityDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPersonalityDetailsBinding
    private lateinit var viewModel: ViewModel
    private lateinit var myAdapter: PersonKnownForAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_personality_details)

        var data = intent

        var position = data.getIntExtra("position", 0)
        viewModel = ViewModelProvider(this)[ViewModel::class.java]

        // iska adapter kaha hai
        binding.rvPersonKnown.layoutManager = LinearLayoutManager(this)
        viewModel.getPerson().observe(this, Observer {
            myAdapter = PersonKnownForAdapter(it.Result[position])
            binding.rvPersonKnown.adapter = myAdapter
            myAdapter.notifyDataSetChanged()
        })
    }
}