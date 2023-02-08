package com.warko.coctailbrowser.common.di

import com.warko.coctailbrowser.common.di.module.AppModule
import com.warko.coctailbrowser.common.di.scope.AppScope
import com.warko.coctailbrowser.remote.api.CocktailsApi
import com.warko.coctailbrowser.remote.di.RetrofitModule
import dagger.Component

@AppScope
@Component(
    modules = [
        AppModule::class,
        RetrofitModule::class
    ]
)
interface AppComponent {

    fun cocktailsApi(): CocktailsApi

    @Component.Factory
    interface Factory {
        fun create(appModule: AppModule): AppComponent
    }

}