package com.rafaelm.thenewyorktimes.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_table")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "movie_id")
    var movieId: Int,

    @ColumnInfo(name = "display_title")
    var movie_title: String?,

    @ColumnInfo(name = "headline")
    var MovieHeadline: String?,

    @ColumnInfo(name = "summary_short")
    var MovieSummaryShort: String?,

    @ColumnInfo(name = "movie_image")
    var movieImage: String?,
)