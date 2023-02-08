package com.warko.coctailbrowser.domain.usecase

import com.warko.coctailbrowser.domain.datasource.CocktailsDataSource
import com.warko.coctailbrowser.domain.model.Cocktail

class LoadCocktailsUseCase(
    private val cocktailsDataSource: CocktailsDataSource
) {

    suspend fun loadCocktails(term: String): List<Cocktail> = doOnBackground {
        cocktailsDataSource.loadCocktails(term)
    }

}