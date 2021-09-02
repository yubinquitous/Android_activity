package com.example.st_w3_activity

import com.google.gson.annotations.SerializedName

data class BoxOfficeResult(
    @SerializedName(value = "boxofficeType") val boxofficeType : String,
    @SerializedName(value = "showRange") val showRange : String,
    @SerializedName(value = "yearWeekTime") val yearWeekTime : String,
    @SerializedName(value = "weeklyBoxOfficeList") val weeklyBoxOfficeList : ArrayList<Movie>
)