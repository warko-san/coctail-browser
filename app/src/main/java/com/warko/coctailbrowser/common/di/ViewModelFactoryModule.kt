package com.warko.coctailbrowser.common.di

import androidx.lifecycle.ViewModelProvider
import com.warko.coctailbrowser.common.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory

}