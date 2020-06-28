package com.ahmadshahwaiz.randomprogrammingquotes.domain.dagger


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ahmadshahwaiz.randomprogrammingquotes.presentation.view.dashboard.DashboardViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module()
abstract class AppViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(DashboardViewModel::class)
    abstract fun bindDashboardViewModel(dashboardViewModel: DashboardViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}
