package com.rafaelm.thenewyorktimes.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rafaelm.thenewyorktimes.R
import com.rafaelm.thenewyorktimes.data.api.MovieRetrofit
import com.rafaelm.thenewyorktimes.data.entity.MovieEntity
import com.rafaelm.thenewyorktimes.data.model.MovieResponse
import com.rafaelm.thenewyorktimes.data.repository.MovieRepository
import com.rafaelm.thenewyorktimes.view.adapter.RecyclerviewAdapterMovie
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import java.security.acl.Owner

class MainActivity : AppCompatActivity() {

    override fun onStart() {
        val repository = MovieRepository(application)
        recyclerview_movie_list.layoutManager = LinearLayoutManager(applicationContext)
        repository.getMovie()?.observe(this, {
            recyclerview_movie_list.adapter = RecyclerviewAdapterMovie(it,applicationContext)
        })
        super.onStart()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = MovieRepository(application)
        val retrofit = MovieRetrofit.apiConnection().getMovie()

        retrofit.enqueue(object : retrofit2.Callback<MovieResponse> {
            override fun onResponse(
                call: Call<MovieResponse>,
                response: Response<MovieResponse>
            ) {

                response.body()?.results?.forEach { result ->

                    val movieEntity = MovieEntity(
                        movieId = 0,
                        movieTitle = result.displayTitle,
                        movieDateUpdate = result.dateUpdated,
                        movieHeadline = result.headline,
                        movieSummaryShort = result.summaryShort,
                        movieImage = result.multimedia.src,
                        movieFavorite = "false"
                    )

                    repository.insertMovie(movieEntity)
                }
            }


            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }


        })

        recyclerview_movie_list.layoutManager = LinearLayoutManager(applicationContext)
        repository.getMovie()?.observe(this, {
            recyclerview_movie_list.adapter = RecyclerviewAdapterMovie(it,applicationContext)
        })

    }
}