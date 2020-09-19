package com.rafaelm.thenewyorktimes.data.model


import com.google.gson.annotations.SerializedName

data class Result(
    val byline: String = "Jessica Kiang",
    @SerializedName("critics_pick")
    val criticsPick: Int = 0,
    @SerializedName("date_updated")
    val dateUpdated: String = "2020-09-18 22:56:02",
    @SerializedName("display_title")
    val displayTitle: String = "Rifkin's Festival",
    val headline: String = "‘Rifkin’s Festival’ Review: Woody Allen Travels to Movie Memory Lane",
    val link: Link = Link(),
    @SerializedName("mpaa_rating")
    val mpaaRating: String = "",
    val multimedia: Multimedia = Multimedia(),
    @SerializedName("opening_date")
    val openingDate: Any = Any(),
    @SerializedName("publication_date")
    val publicationDate: String = "2020-09-18",
    @SerializedName("summary_short")
    val summaryShort: String = "The filmmaker seems to acknowledge the world has changed in this light tale of a director (Wallace Shawn) at a European film festival."
)