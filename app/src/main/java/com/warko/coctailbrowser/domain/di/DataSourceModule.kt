package com.warko.coctailbrowser.domain.di

import com.warko.coctailbrowser.domain.datasource.CocktailsDataSource
import com.warko.coctailbrowser.remote.datasource.RemoteCocktailDataSource
import dagger.Binds
import dagger.Module

@Module
interface DataSourceModule {

    @Binds
    fun bindCocktailDataSource(remote: RemoteCocktailDataSource): CocktailsDataSource

}