package com.rafaelm.thenewyorktimes.data.model


import com.google.gson.annotations.SerializedName

data class Link(
    @SerializedName("suggested_link_text")
    val suggestedLinkText: String = "Read the New York Times Review of Rifkin's Festival",
    val type: String = "article",
    val url: String = "http://www.nytimes.com/2020/09/18/movies/rifkins-festival-review.html"
)