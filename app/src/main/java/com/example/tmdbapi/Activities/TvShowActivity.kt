package com.example.tmdbapi.Activities

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbapi.Adapter.TvShowRecyclerViewAdapter
import com.example.tmdbapi.Interfaces.TvShowRecyclerViewClickListener
import com.example.tmdbapi.R
import com.example.tmdbapi.Response.TvShowResult
import com.example.tmdbapi.ViewModels.ViewModel
import com.example.tmdbapi.databinding.ActivityTvShowBinding
import com.example.tmdbapi.databinding.ActivityTvShowDetailsBinding
import com.example.tmdbapi.databinding.CustomTvshowListBinding

class TvShowActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTvShowBinding
    private lateinit var tvAdapter : TvShowRecyclerViewAdapter
    private lateinit var viewModel: ViewModel
    lateinit var progressBar: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)

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

        viewModel.getTvShow().observe(this, Observer {
            tvAdapter = TvShowRecyclerViewAdapter(this, it, object : TvShowRecyclerViewClickListener{
                override fun onTvShowItemClick(position: Int, tvShowList: TvShowResult) {
                    var tv = tvShowList.Result[position]
                    tvDetails(tv.name, tv.language, tv.overview, tv.popularity, tv.posterPath, tv.voteCount)

                }

            })
            binding.rvTv.layoutManager = LinearLayoutManager(this)
            binding.rvTv.adapter = tvAdapter
            tvAdapter.notifyDataSetChanged()
        })
    }

    fun tvDetails(name : String, language : String, overview : String, popularity : Double, posterpath : String, voteCount : Int){

        var intentTv = Intent(this, TvShowDetailsActivity::class.java)

        intentTv.putExtra("name", name)
        intentTv.putExtra("language", language)
        intentTv.putExtra("overview", overview)
        intentTv.putExtra("popularity", popularity)
        intentTv.putExtra("posterpath", posterpath)
        intentTv.putExtra("voteCount", voteCount)
        startActivity(intentTv)
    }
}