package com.warko.coctailbrowser.feature.main

import androidx.lifecycle.ViewModel
import com.warko.coctailbrowser.common.di.AppComponent
import com.warko.coctailbrowser.common.di.ViewModelFactoryModule
import com.warko.coctailbrowser.common.di.ViewModelKey
import com.warko.coctailbrowser.common.di.module.ActivityModule
import com.warko.coctailbrowser.common.di.module.NavigatorModule
import com.warko.coctailbrowser.common.di.scope.ActivityScope
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.multibindings.IntoMap

@ActivityScope
@Component(
    modules = [
        ActivityModule::class,
        NavigatorModule::class,
        ViewModelFactoryModule::class,
        MainActivityComponent.ActivityBindingsModule::class
    ],
    dependencies = [AppComponent::class]
)
interface MainActivityComponent {

    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(
            activityModule: ActivityModule,
            appComponent: AppComponent
        ): MainActivityComponent
    }

    @Module
    interface ActivityBindingsModule {

        @Binds
        @IntoMap
        @ViewModelKey(MainActivityViewModel::class)
        fun bindMainViewModel(viewModel: MainActivityViewModel): ViewModel

    }

}