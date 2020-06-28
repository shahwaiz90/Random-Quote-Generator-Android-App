package com.ahmadshahwaiz.networksdk

import com.ahmadshahwaiz.networksdk.dto.QuotationDto
import com.google.gson.JsonObject
import io.reactivex.Single
import org.json.JSONObject
import retrofit2.http.GET


interface NetworkApiService {
    @GET(Urls.RANDOM_QUOTE)
    fun fetchRandomQuote(): Single<QuotationDto>

}