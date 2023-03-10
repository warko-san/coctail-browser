package com.warko.coctailbrowser.domain.di

import com.warko.coctailbrowser.common.di.scope.ActivityScope
import com.warko.coctailbrowser.domain.datasource.CocktailsDataSource
import com.warko.coctailbrowser.domain.usecase.LoadCocktailDetailsUseCase
import com.warko.coctailbrowser.domain.usecase.LoadCocktailsByIngredientUseCase
import com.warko.coctailbrowser.domain.usecase.LoadCocktailsUseCase
import com.warko.coctailbrowser.domain.usecase.LoadRandomCocktailUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @ActivityScope
    @Provides
    fun provideLoadCocktailsUseCase(dataSource: CocktailsDataSource) = LoadCocktailsUseCase(dataSource)

    @ActivityScope
    @Provides
    fun provideLoadCocktailsByIngredientUseCase(dataSource: CocktailsDataSource) = LoadCocktailsByIngredientUseCase(dataSource)

    @ActivityScope
    @Provides
    fun provideLoadCocktailDetailsUseCase(dataSource: CocktailsDataSource) = LoadCocktailDetailsUseCase(dataSource)

    @ActivityScope
    @Provides
    fun provideRandomCocktailUseCase(dataSource: CocktailsDataSource) = LoadRandomCocktailUseCase(dataSource)

}