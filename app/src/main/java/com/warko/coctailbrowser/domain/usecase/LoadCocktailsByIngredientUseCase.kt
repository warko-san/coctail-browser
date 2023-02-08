package com.warko.coctailbrowser.domain.usecase

import com.warko.coctailbrowser.domain.datasource.CocktailsDataSource
import com.warko.coctailbrowser.domain.model.Cocktail

class LoadCocktailsByIngredientUseCase(
    private val cocktailsDataSource: CocktailsDataSource
) {

    suspend fun loadCocktails(term: String): List<Cocktail> = doOnBackground {
        cocktailsDataSource.loadCocktailsByIngredient(term)
    }

}