package com.rafaelm.thenewyorktimes.view.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rafaelm.thenewyorktimes.R
import com.rafaelm.thenewyorktimes.data.api.MovieRetrofit
import com.rafaelm.thenewyorktimes.data.model.MovieResponse
import com.rafaelm.thenewyorktimes.view.adapter.RecyclerviewAdapterMovie
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = MovieRetrofit.apiConnection().getMovie()

        retrofit.enqueue(object : retrofit2.Callback<MovieResponse> {
            override fun onResponse(
                call: Call<MovieResponse>,
                response: Response<MovieResponse>
            ) {

                response.body()?.results?.let { list ->
                    recyclerview_movie_list.layoutManager =
                        LinearLayoutManager(applicationContext)
                    recyclerview_movie_list.adapter = RecyclerviewAdapterMovie(list, applicationContext)
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }
}