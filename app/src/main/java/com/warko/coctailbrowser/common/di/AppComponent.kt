package com.warko.coctailbrowser.common.di

import dagger.Component

@Component(
    modules = [
        AppModule::class,
        NavigatorModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(appModule: AppModule): AppComponent
    }

}