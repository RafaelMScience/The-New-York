package com.rafaelm.thenewyorktimes.data.model


import com.google.gson.annotations.SerializedName

data class MovieResponse(
    val copyright: String = "Copyright (c) 2020 The New York Times Company. All Rights Reserved.",
    @SerializedName("has_more")
    val hasMore: Boolean = true,
    @SerializedName("num_results")
    val numResults: Int = 20,
    val results: List<Result> = listOf(),
    val status: String = "OK"
)