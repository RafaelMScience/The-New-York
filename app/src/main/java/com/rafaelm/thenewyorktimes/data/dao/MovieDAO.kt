package com.rafaelm.thenewyorktimes.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.rafaelm.thenewyorktimes.data.entity.MovieEntity

@Dao
interface MovieDAO {
    @Insert
    fun insertMovie(movie: MovieEntity)

    @Query("SELECT * FROM movie_table order by movie_id DESC")
    fun get(): LiveData<List<MovieEntity>>
}