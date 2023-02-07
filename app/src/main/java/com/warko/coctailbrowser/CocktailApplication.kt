package com.warko.coctailbrowser

import android.app.Application
import com.warko.coctailbrowser.common.di.AppComponent
import com.warko.coctailbrowser.common.di.module.AppModule
import com.warko.coctailbrowser.common.di.DaggerAppComponent
import kotlin.properties.Delegates

class CocktailApplication : Application() {

    var component: AppComponent by Delegates.notNull()

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.factory()
            .create(AppModule(this))
    }
}