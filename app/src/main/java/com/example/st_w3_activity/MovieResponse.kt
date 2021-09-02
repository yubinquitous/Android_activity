package com.example.st_w3_activity

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName(value = "boxOfficeResult") val boxOfficeResult : BoxOfficeResult
)