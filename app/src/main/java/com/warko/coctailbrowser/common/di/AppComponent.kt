package com.warko.coctailbrowser.common.di

import com.warko.coctailbrowser.common.navigator.ScreensNavigator
import dagger.Component

@Component(
    modules = [
        AppModule::class,
        NavigatorModule::class
    ]
)
interface AppComponent {

    fun provideNavigator(): ScreensNavigator

    @Component.Factory
    interface Factory {
        fun create(appModule: AppModule): AppComponent
    }

}