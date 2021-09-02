package com.example.st_w3_activity

import com.google.gson.annotations.SerializedName

data class BookResponse(
    @SerializedName(value = "item") val item : ArrayList<BestSellers>
)
