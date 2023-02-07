package com.warko.coctailbrowser.common.di.module

import android.content.Context
import androidx.activity.ComponentActivity
import com.warko.coctailbrowser.common.di.qualifier.ActivityContext
import com.warko.coctailbrowser.common.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: ComponentActivity) {

    @Provides
    @ActivityContext
    @ActivityScope
    fun provideActivityContext(): Context = activity
}