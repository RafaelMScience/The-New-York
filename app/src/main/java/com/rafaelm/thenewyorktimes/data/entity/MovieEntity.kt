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
    var movieTitle: String?,

    @ColumnInfo(name = "headline")
    var movieHeadline: String?,

    @ColumnInfo(name = "date_updated")
    var movieDateUpdate: String?,

    @ColumnInfo(name = "summary_short")
    var movieSummaryShort: String?,

    @ColumnInfo(name = "movie_image")
    var movieImage: String?,

    @ColumnInfo(name = "movie_favorite")
    var movieFavorite: Boolean
)