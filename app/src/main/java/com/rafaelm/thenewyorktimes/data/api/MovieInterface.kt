package com.rafaelm.thenewyorktimes.data.api

import com.rafaelm.thenewyorktimes.data.classSaveTemp.Constansts.Companion.API_KEY
import com.rafaelm.thenewyorktimes.data.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieInterface {

    @GET("reviews/search.json?api-key=${API_KEY}")
    fun getMovie(): Call<MovieResponse>
}