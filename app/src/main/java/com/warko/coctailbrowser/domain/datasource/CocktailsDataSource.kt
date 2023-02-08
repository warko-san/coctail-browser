package com.warko.coctailbrowser.domain.datasource

import com.warko.coctailbrowser.domain.model.Cocktail

interface CocktailsDataSource {

    suspend fun loadCocktails(term: String): List<Cocktail>
    suspend fun loadCocktailDetails(cocktailId: String): Cocktail
    suspend fun loadRandomCocktail(): Cocktail

}