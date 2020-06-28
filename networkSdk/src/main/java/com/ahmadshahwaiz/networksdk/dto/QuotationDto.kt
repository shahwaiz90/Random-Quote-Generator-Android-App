package com.ahmadshahwaiz.networksdk.dto

import com.google.gson.annotations.SerializedName

data class QuotationDto(
    @SerializedName("id") val id: Boolean,
    @SerializedName("en") val quote: String,
    @SerializedName("author") val author: String,
    var lastSeenDate: String
)