package com.example.st_w3_activity

import com.google.gson.annotations.SerializedName

data class BestSellers(
    @SerializedName(value = "coverSmallUrl") val imageUrl : String,
    @SerializedName(value = "coverLargeUrl") val coverLargeUrl : String,
    @SerializedName(value = "title") val title : String,
    @SerializedName(value = "description") val description : String,
    @SerializedName(value = "publisher") val publisher : String,
    @SerializedName(value = "author") val author : String,
    @SerializedName(value = "priceSales") val priceSales : Int,
    @SerializedName(value = "categoryName") val categoryName : String,
    @SerializedName(value = "pubDate") val pubDate : String
    )
