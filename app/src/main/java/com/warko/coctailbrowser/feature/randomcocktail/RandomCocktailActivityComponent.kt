package com.warko.coctailbrowser.feature.randomcocktail

import androidx.lifecycle.ViewModel
import com.warko.coctailbrowser.common.di.AppComponent
import com.warko.coctailbrowser.common.di.ViewModelFactoryModule
import com.warko.coctailbrowser.common.di.ViewModelKey
import com.warko.coctailbrowser.common.di.module.ActivityModule
import com.warko.coctailbrowser.common.di.module.NavigatorModule
import com.warko.coctailbrowser.common.di.scope.ActivityScope
import com.warko.coctailbrowser.domain.di.DataSourceModule
import com.warko.coctailbrowser.domain.di.UseCaseModule
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.multibindings.IntoMap

@ActivityScope
@Component(
    modules = [
        ActivityModule::class,
        ViewModelFactoryModule::class,
        NavigatorModule::class,
        DataSourceModule::class,
        UseCaseModule::class,
        RandomCocktailActivityComponent.ActivityBindingsModule::class
    ], dependencies = [
        AppComponent::class
    ]
)
interface RandomCocktailActivityComponent {

    fun inject(activity: RandomCocktailActivity)

    @Component.Factory
    interface Factory {
        fun create(
            activityModule: ActivityModule,
            appComponent: AppComponent
        ): RandomCocktailActivityComponent
    }

    @Module
    interface ActivityBindingsModule {

        @Binds
        @IntoMap
        @ViewModelKey(RandomCocktailViewModel::class)
        fun bindRandomCocktViewModel(viewModel: RandomCocktailViewModel): ViewModel

    }

}