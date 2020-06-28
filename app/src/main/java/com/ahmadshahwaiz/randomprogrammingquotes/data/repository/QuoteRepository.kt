package com.ahmadshahwaiz.randomprogrammingquotes.data.repository

import com.ahmadshahwaiz.networksdk.NetworkApi
import com.ahmadshahwaiz.networksdk.dto.QuotationDto
import com.ahmadshahwaiz.randomprogrammingquotes.data.AppUserPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Observable
import io.reactivex.Single
import org.json.JSONObject
import java.lang.reflect.Type
import java.util.HashMap
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val networkApi: NetworkApi,
    private val appUserPreferences: AppUserPreferences
) {
    //From Server (API Call)
    fun fetchRandomQuote(): Single<QuotationDto> =
        networkApi.fetchRandomQuote()

    //From shared preference
    fun loadQuote(): Observable<String?> {
        return Observable.just(appUserPreferences.getLastQuote())
    }

}