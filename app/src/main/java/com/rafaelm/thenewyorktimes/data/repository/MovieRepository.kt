package com.rafaelm.thenewyorktimes.data.repository

import android.app.Application
import com.rafaelm.thenewyorktimes.data.dao.MovieDAO
import com.rafaelm.thenewyorktimes.data.database.DatabaseMovie
import com.rafaelm.thenewyorktimes.data.entity.MovieEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class MovieRepository(application: Application): CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private var movieDao: MovieDAO?

    init {
        val db = DatabaseMovie.getInstance(application)
        movieDao = db.databaseMovie
    }

    fun getMovie() = movieDao?.get()

    fun getMovieExp(movieId: Int) = movieDao?.getMovieExp(movieId)

    fun insertMovie(movie: MovieEntity){
        launch {
            insert(movie)
        }
    }

    fun updateMovie(movieFavorite: String){
        launch {
            favoriteMovie(movieFavorite)
        }
    }

    private  suspend fun insert(movie: MovieEntity){
        withContext(Dispatchers.IO){
            movieDao?.insertMovie(movie)
        }
    }

    private suspend fun favoriteMovie(movieFavorite: String){
        withContext(Dispatchers.IO){
            movieDao?.updateMovieFavorite(movieFavorite)
        }
    }
}