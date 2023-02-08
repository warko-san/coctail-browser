package com.warko.coctailbrowser.feature.cocktailsearch

import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModel
import com.warko.coctailbrowser.common.di.AppComponent
import com.warko.coctailbrowser.common.di.ViewModelFactoryModule
import com.warko.coctailbrowser.common.di.ViewModelKey
import com.warko.coctailbrowser.common.di.module.ActivityModule
import com.warko.coctailbrowser.common.di.module.NavigatorModule
import com.warko.coctailbrowser.common.di.scope.ActivityScope
import com.warko.coctailbrowser.domain.di.DataSourceModule
import com.warko.coctailbrowser.domain.di.UseCaseModule
import com.warko.coctailbrowser.remote.api.CocktailsApi
import dagger.Binds
import dagger.BindsInstance
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
        CocktailSearchActivityComponent.ActivityBindingsModule::class
    ], dependencies = [
        AppComponent::class
    ]
)
interface CocktailSearchActivityComponent {

    fun inject(activity: CocktailSearchActivity)

    @Component.Factory
    interface Factory {
        fun create(activityModule: ActivityModule, appComponent: AppComponent): CocktailSearchActivityComponent
    }

    @Module
    interface ActivityBindingsModule {

        @Binds
        @IntoMap
        @ViewModelKey(CocktailSearchViewModel::class)
        fun bindCocktSearchViewModel(viewModel: CocktailSearchViewModel): ViewModel

    }

}