package com.warko.coctailbrowser.feature.cocktailsearch

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
        CocktailSearchActivityComponent.ActivityBindingsModule::class
    ]
)
interface CocktailSearchActivityComponent {

    fun inject(activity: CocktailSearchActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance activity: ComponentActivity): CocktailSearchActivityComponent
    }

    @Module
    interface ActivityBindingsModule {

        @Binds
        @IntoMap
        @ViewModelKey(CocktailSearchViewModel::class)
        fun bindCocktSearchViewModel(viewModel: CocktailSearchViewModel): ViewModel

    }

}