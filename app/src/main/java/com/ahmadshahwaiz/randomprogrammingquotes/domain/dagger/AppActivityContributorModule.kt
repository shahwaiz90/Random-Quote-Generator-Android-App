package com.ahmadshahwaiz.randomprogrammingquotes.domain.dagger

import com.ahmadshahwaiz.randomprogrammingquotes.presentation.view.dashboard.DashboardActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Let all activities from the `app` module be injected.
 */
@Module
abstract class AppActivityContributorModule {

    @ContributesAndroidInjector
    abstract fun contributeDashboardActivity(): DashboardActivity

}