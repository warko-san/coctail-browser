package com.warko.coctailbrowser.common.di.module

import com.warko.coctailbrowser.common.navigator.ScreensNavigator
import com.warko.coctailbrowser.common.navigator.ScreensNavigatorImpl
import dagger.Binds
import dagger.Module

@Module
interface NavigatorModule {

    @Binds
    fun bindNavigatorModule(navigatorImpl: ScreensNavigatorImpl): ScreensNavigator

}