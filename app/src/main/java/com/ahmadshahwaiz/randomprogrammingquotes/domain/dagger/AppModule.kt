package com.ahmadshahwaiz.randomprogrammingquotes.domain.dagger

import android.app.Application
import android.content.Context
import com.ahmadshahwaiz.networksdk.NetworkApi
import com.ahmadshahwaiz.randomprogrammingquotes.data.AppUserPreferences
import com.ahmadshahwaiz.randomprogrammingquotes.domain.AppConfiguration
import com.ahmadshahwaiz.randomprogrammingquotes.domain.ConnectivityWatcher
import com.ahmadshahwaiz.randomprogrammingquotes.domain.TextProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * This module is responsible for creating the dependencies the `app` module needs to provide.
 */
@Module()
class AppModule {
    /**
     * Provide a [AppConfiguration] object across the whole app.
     */
    @Provides
    @Singleton
    fun provideConfiguration(): AppConfiguration = AppConfiguration()

    /**
     * Provide a [Context] object across the whole app.
     */
    @Provides
    @Singleton
    fun provideContext(app: Application) = app.applicationContext

    @Provides
    @Singleton
    fun provideNetworkApi(context: Context, configuration : AppConfiguration): NetworkApi {
        return NetworkApi.Builder(context)
            .networkHost(configuration.apiHost)
            .build()
    }

    @Provides
    @Singleton
    fun provideAppUserPreferences(context: Context) = AppUserPreferences(context)

    @Provides
    @Singleton
    fun provideConnectivityWatcher() = ConnectivityWatcher()

    @Provides
    @Singleton
    fun provideTextProvider(context: Context) = TextProvider(context)


}