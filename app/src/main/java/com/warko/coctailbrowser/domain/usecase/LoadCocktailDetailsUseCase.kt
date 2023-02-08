package com.warko.coctailbrowser.domain.usecase

import com.warko.coctailbrowser.domain.datasource.CocktailsDataSource
import com.warko.coctailbrowser.domain.model.Cocktail

class LoadCocktailDetailsUseCase(
    private val cocktailsDataSource: CocktailsDataSource
) {

    suspend fun loadCocktailDetails(cocktailId: String): Cocktail = doOnBackground {
        cocktailsDataSource.loadCocktailDetails(cocktailId)
    }

}