package com.ahmadshahwaiz.networksdk

import android.content.Context
import com.ahmadshahwaiz.networksdk.dto.QuotationDto
import com.google.gson.JsonObject
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkApi private constructor(builder: Builder) {
    private var apiHost: String
    private lateinit var networkApi: NetworkApiService

    init {
        this.apiHost = builder.networkHost
        initNetworkApi()
    }

    fun fetchRandomQuote(): Single<QuotationDto> =
        networkApi.fetchRandomQuote()

    private fun initNetworkApi() {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        val clientBuilder = OkHttpClient.Builder()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        clientBuilder.addInterceptor(httpLoggingInterceptor)

        clientBuilder
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)

        val apiClient = clientBuilder.build()
        networkApi = Retrofit.Builder()
            .baseUrl(apiHost)
            .client(apiClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(NetworkApiService::class.java)
    }

    class Builder(private val context: Context) {

        lateinit var networkHost: String
            private set

        fun networkHost(networkHost: String) = apply { this.networkHost = networkHost }

        fun build(): NetworkApi {

            if (networkHost.isNullOrEmpty()) {
                throw IllegalArgumentException("NetworkHost Server host is required")
            }
            return NetworkApi(this)
        }
    }
}
