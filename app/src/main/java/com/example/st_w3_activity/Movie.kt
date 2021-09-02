package com.example.st_w3_activity

import com.google.gson.annotations.SerializedName

data class Movie(
//    @SerializedName(value = "rnum") val rnum : String,
    @SerializedName(value = "rank") val rank : String,
    @SerializedName(value = "rankInten") val rankInten : String,
    @SerializedName(value = "rankOldAndNew") val rankOldAndNew : String,
    @SerializedName(value = "movieCd") val movieCd : String,
    @SerializedName(value = "movieNm") val movieNm : String,
    @SerializedName(value = "openDt") val openDt : String,
//    @SerializedName(value = "salesAmt") val salesAmt : String,
//    @SerializedName(value = "salesShare") val salesShare : String,
//    @SerializedName(value = "salesInten") val salesInten : String,
//    @SerializedName(value = "salesChange") val salesChange : String,
//    @SerializedName(value = "salesAcc") val salesAcc : String,
    @SerializedName(value = "audiCnt") val audiCnt : String,
    @SerializedName(value = "audiInten") val audiInten : String,
    @SerializedName(value = "audiChange") val audiChange : String,
    @SerializedName(value = "audiAcc") val audiAcc : String
//    @SerializedName(value = "scrnCnt") val scrnCnt : String,
//    @SerializedName(value = "showCnt") val showCnt : String
    )
