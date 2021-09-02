package com.example.st_w3_activity

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {
    @GET("api/bestSeller.api")
    fun getBooks(
        @Query("key") key: String,
        @Query("categoryId") categoryId : Int,
        @Query("output") output: String
    ): Call<BookResponse>
}