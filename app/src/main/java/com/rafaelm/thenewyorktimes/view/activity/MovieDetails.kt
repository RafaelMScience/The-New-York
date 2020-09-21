package com.rafaelm.thenewyorktimes.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.rafaelm.thenewyorktimes.R
import com.rafaelm.thenewyorktimes.data.SaveTemp.Prefs
import com.rafaelm.thenewyorktimes.data.entity.MovieEntity
import com.rafaelm.thenewyorktimes.data.repository.MovieRepository
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val sharedPreferences = Prefs(applicationContext)
        val movieId = sharedPreferences.getValueInt("movieId")
        val repository = MovieRepository(application)
        repository.getMovieExp(movieId)?.observe(this, {list ->
            list.forEach {
                Log.i("teste", it.movieId.toString())
                Log.i("teste", it.movieDateUpdate.toString())
                val itemImg = it.movieImage.toString()
                if (itemImg != null) {
                    val imgReplace = itemImg.replace("\\", "")
                    val img = img_movie_poster
                    Glide.with(applicationContext)
                        .load(imgReplace)
                        .into(img)
                }

                txt_movie_headline_details.text = it.movieHeadline
                txt_movie_summary_short_details.text = it.movieSummaryShort

                ic_share.setOnClickListener {view->
                    val shareIntent = Intent()
                    shareIntent.action = Intent.ACTION_SEND
                    shareIntent.type="text/plain"
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "title: "+it.movieTitle+"\nDescription: "+it.movieSummaryShort);
                    startActivity(Intent.createChooser(shareIntent,"send to"))
                }


                ic_favorite.setOnClickListener{view->
                    if(!it.movieFavorite) {
                        val movieFav = MovieEntity(movieId = it.movieId, movieTitle = it.movieTitle, movieImage = it.movieImage, movieSummaryShort = it.movieSummaryShort, movieHeadline = it.movieHeadline, movieDateUpdate = it.movieDateUpdate, movieFavorite = true)
                        Toast.makeText(this,"Movie is Favorite", Toast.LENGTH_SHORT).show()
                        repository.updateMovie(movieFav)
                    }else{
                        val movieFav = MovieEntity(movieId = it.movieId, movieTitle = it.movieTitle, movieImage = it.movieImage, movieSummaryShort = it.movieSummaryShort, movieHeadline = it.movieHeadline, movieDateUpdate = it.movieDateUpdate, movieFavorite = false)
                        Toast.makeText(this,"Movie is not Favorite", Toast.LENGTH_SHORT).show()
                        repository.updateMovie(movieFav)
                    }
                }
            }
        })
    }
}