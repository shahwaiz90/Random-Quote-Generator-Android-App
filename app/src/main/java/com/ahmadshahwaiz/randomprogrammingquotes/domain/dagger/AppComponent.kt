package com.ahmadshahwaiz.randomprogrammingquotes.domain.dagger

import android.app.Application
import com.ahmadshahwaiz.randomprogrammingquotes.data.AppUserPreferences
import com.ahmadshahwaiz.randomprogrammingquotes.domain.ConnectivityWatcher
import com.ahmadshahwaiz.randomprogrammingquotes.data.ProgrammingQuoteApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class,
    AppViewModelsModule::class,
    AppActivityContributorModule::class,
    AndroidInjectionModule::class])
interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(app: ProgrammingQuoteApplication)

    fun appUserPreferences(): AppUserPreferences

    fun connectivityWatcher(): ConnectivityWatcher
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}