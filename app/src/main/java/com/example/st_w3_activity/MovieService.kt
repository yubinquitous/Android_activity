package com.example.st_w3_activity

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("boxoffice/searchWeeklyBoxOfficeList.json")
    fun getMovies(
        @Query("key") key: String,
        @Query("targetDt") targetDt : String
    ): Call<MovieResponse>
}