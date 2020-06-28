package com.ahmadshahwaiz.randomprogrammingquotes.data

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.multidex.MultiDex
import com.ahmadshahwaiz.randomprogrammingquotes.domain.AppConfiguration
import com.ahmadshahwaiz.randomprogrammingquotes.domain.AppInjector
import com.ahmadshahwaiz.randomprogrammingquotes.domain.dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import timber.log.Timber
import javax.inject.Inject

class ProgrammingQuoteApplication : DaggerApplication(), HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var appConfiguration: AppConfiguration


    /** Returns an [AndroidInjector] of [Fragment]s.  */
    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        initTimberLogging()
    }

    private fun initTimberLogging() {
        if (appConfiguration.logsEnabled) {
            Timber.plant(Timber.DebugTree())
        }
    }

    /**
     * Implementations should return an [AndroidInjector] for the concrete [ ]. Typically, that injector is a [dagger.Component].
     */
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val daggerAppComponent = DaggerAppComponent.builder()
                .application(this)
                .build()

        daggerAppComponent.inject(this)

        AppInjector.init(this)

        return daggerAppComponent
    }

}