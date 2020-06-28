package com.ahmadshahwaiz.randomprogrammingquotes.presentation.view.dashboard

import com.ahmadshahwaiz.networksdk.dto.QuotationDto
import com.ahmadshahwaiz.randomprogrammingquotes.data.AppUserPreferences
import com.ahmadshahwaiz.randomprogrammingquotes.data.repository.QuoteRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.lang.reflect.Type
import javax.inject.Inject

class DashboardInteractor @Inject constructor(
    private val quoteRepository: QuoteRepository,
    private val appUserPreferences: AppUserPreferences
) {
    fun getRandomQuote(): Single<QuotationDto> =
        quoteRepository.fetchRandomQuote()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun loadQuote(): Observable<QuotationDto> =
        quoteRepository.loadQuote()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { it->
                val gson = Gson()
                val type: Type = object : TypeToken<QuotationDto>() {}.getType()
                val quotationDto: QuotationDto =  gson.fromJson(it, type)
                return@map quotationDto
            }

    fun saveResponseLocally(response: String){
        appUserPreferences.saveQuote(response)
    }

}