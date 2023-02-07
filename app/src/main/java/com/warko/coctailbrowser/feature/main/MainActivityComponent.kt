package com.warko.coctailbrowser.feature.main

import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModel
import com.warko.coctailbrowser.common.di.ViewModelFactoryModule
import com.warko.coctailbrowser.common.di.ViewModelKey
import com.warko.coctailbrowser.common.di.scope.ActivityScope
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.multibindings.IntoMap

@ActivityScope
@Component(
    modules = [
        ViewModelFactoryModule::class,
        MainActivityComponent.ActivityBindingsModule::class
    ]
)
interface MainActivityComponent {

    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance activity: ComponentActivity): MainActivityComponent
    }

    @Module
    interface ActivityBindingsModule {

        @Binds
        @IntoMap
        @ViewModelKey(MainActivityViewModel::class)
        fun bindMainViewModel(viewModel: MainActivityViewModel): ViewModel

    }

}