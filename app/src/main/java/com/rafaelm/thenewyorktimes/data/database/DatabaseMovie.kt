package com.rafaelm.thenewyorktimes.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rafaelm.thenewyorktimes.data.dao.MovieDAO
import com.rafaelm.thenewyorktimes.data.entity.MovieEntity

@Database(entities = [MovieEntity::class],version = 1, exportSchema = false)
abstract class DatabaseMovie: RoomDatabase() {

    abstract val databaseMovie: MovieDAO

    companion object{
        @Volatile
        private var INSTANCE: DatabaseMovie? = null

        fun getInstance(context: Context): DatabaseMovie{
            synchronized(this){
                var instance = INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DatabaseMovie::class.java,
                        "movie_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }

                return instance
            }
        }

    }
}