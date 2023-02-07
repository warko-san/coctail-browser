package com.warko.coctailbrowser.common.di

import com.warko.coctailbrowser.common.di.module.AppModule
import dagger.Component

@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(appModule: AppModule): AppComponent
    }

}