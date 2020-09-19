package com.rafaelm.thenewyorktimes.data.api

import com.rafaelm.thenewyorktimes.data.dao.Constansts.Companion.API_KEY
import com.rafaelm.thenewyorktimes.data.dao.Constansts.Companion.BASE_URL
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MovieRetrofit {

    companion object {

        private fun getMovieRetrofitInstance(): Retrofit {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = (HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun apiConnection(): MovieInterface{
            return getMovieRetrofitInstance().create(MovieInterface::class.java)
        }

    }


}