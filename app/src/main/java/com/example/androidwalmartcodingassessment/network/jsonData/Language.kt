package com.example.androidwalmartcodingassessment.network.jsonData

import com.google.gson.annotations.SerializedName

data class Language (
    @SerializedName("code")
    var code : String? = null,
    @SerializedName("name")
    var name : String? = null
)