package com.ahmadshahwaiz.randomprogrammingquotes.domain

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.ahmadshahwaiz.randomprogrammingquotes.domain.dagger.Injectable
import com.ahmadshahwaiz.randomprogrammingquotes.data.ProgrammingQuoteApplication
import dagger.android.AndroidInjection


/**
 * Helper class to automatically inject Activities.
 */
object AppInjector {
    fun init(app: ProgrammingQuoteApplication) {
        app.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                handleActivity(activity)
            }

            override fun onActivityStarted(activity: Activity) {

            }

            override fun onActivityResumed(activity: Activity) {

            }

            override fun onActivityPaused(activity: Activity) {

            }

            override fun onActivityStopped(activity: Activity) {

            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle?) {

            }

            override fun onActivityDestroyed(activity: Activity) {

            }
        })
    }

    private fun handleActivity(activity: Activity) {
        if (activity is Injectable) {
            AndroidInjection.inject(activity)
        }
    }
}
