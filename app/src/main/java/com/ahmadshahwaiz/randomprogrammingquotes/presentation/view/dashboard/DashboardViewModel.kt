package com.ahmadshahwaiz.randomprogrammingquotes.presentation.view.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ahmadshahwaiz.networksdk.dto.QuotationDto
import com.ahmadshahwaiz.randomprogrammingquotes.R
import com.ahmadshahwaiz.randomprogrammingquotes.data.AppUserPreferences
import com.ahmadshahwaiz.randomprogrammingquotes.domain.ConnectivityWatcher
import com.ahmadshahwaiz.randomprogrammingquotes.domain.TextProvider
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import org.json.JSONObject
import timber.log.Timber
import java.lang.reflect.Type
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


class DashboardViewModel @Inject constructor(
    private val dashboardInteractor: DashboardInteractor,
    private val textProvider: TextProvider,
    private val connectivityWatcher: ConnectivityWatcher
) : ViewModel() {
    @JvmField val compositeDisposable = CompositeDisposable()

    private val randomQuoteResponse = MutableLiveData<QuotationDto>()
    private val retrievalStatus = MutableLiveData<String>()

    fun getRandomQuote() {
        compositeDisposable.add(connectivityWatcher.connectivity().firstElement().subscribe { isOnline ->
            if (isOnline) {
                dashboardInteractor.getRandomQuote()
                    .doOnSubscribe {
                        retrievalStatus.postValue(textProvider.getText(R.string.label_loading))
                    }
                    .subscribe(
                        {
                            randomQuoteResponse.postValue(it)
                            retrievalStatus.postValue(textProvider.getText(R.string.online_msg_scenario))
                            val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
                            val currentDate = sdf.format(Date())
                            it.lastSeenDate = currentDate
                            val gson : Gson = Gson()
                            dashboardInteractor.saveResponseLocally(gson.toJson(it))
                        },
                        {
                            retrievalStatus.postValue(it.message)
                        })
            } else {
                dashboardInteractor.loadQuote()
                    .doOnSubscribe {
                        retrievalStatus.postValue(textProvider.getText(R.string.label_loading))
                    }
                    .subscribe(
                        {
                            retrievalStatus.postValue(textProvider.getText(R.string.offline_msg_scenario))
                             if(it.quote.isNotEmpty()) {
                                randomQuoteResponse.postValue(it)
                            }else{
                                 retrievalStatus.postValue(textProvider.getText(R.string.label_need_internet))
                            }
                        },
                        {
                            retrievalStatus.postValue(it.message)
                        })
            }
        })
    }

    fun getQuoteResponse(): LiveData<QuotationDto> = randomQuoteResponse
    fun getRetrievalStatus(): LiveData<String> = retrievalStatus

}