package com.rafaelm.thenewyorktimes.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.rafaelm.thenewyorktimes.data.entity.MovieEntity

@Dao
interface MovieDAO {
    @Insert
    fun insertMovie(movie: MovieEntity)

    @Query("SELECT * FROM movie_table order by movie_id DESC")
    fun get(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM movie_table WHERE movie_id=:movieId")
    fun getMovieExp(movieId: Int): LiveData<List<MovieEntity>>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateMovieFavorite(favoriteMovie: MovieEntity)
}