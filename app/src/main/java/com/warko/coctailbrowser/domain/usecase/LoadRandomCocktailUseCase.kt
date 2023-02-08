package com.warko.coctailbrowser.domain.usecase

import com.warko.coctailbrowser.domain.datasource.CocktailsDataSource
import com.warko.coctailbrowser.domain.model.Cocktail

class LoadRandomCocktailUseCase(
    private val cocktailsDataSource: CocktailsDataSource
) {

    suspend fun loadRandomCocktail(): Cocktail = doOnBackground {
        cocktailsDataSource.loadRandomCocktail()
    }

}