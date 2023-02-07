package com.warko.coctailbrowser.common.di.module

import android.app.Application
import android.content.Context
import com.warko.coctailbrowser.common.di.qualifier.AppContext
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val application: Application) {

    @Provides
    @AppContext
    fun provideContext(): Context = application

}