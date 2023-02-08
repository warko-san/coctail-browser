package com.warko.coctailbrowser.domain.di

import com.warko.coctailbrowser.common.di.scope.ActivityScope
import com.warko.coctailbrowser.domain.datasource.CocktailsDataSource
import com.warko.coctailbrowser.domain.usecase.LoadCocktailsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @ActivityScope
    @Provides
    fun provideLoadCocktailsUseCase(dataSource: CocktailsDataSource) = LoadCocktailsUseCase(dataSource)

}