package com.warko.coctailbrowser.remote.datasource

import com.warko.coctailbrowser.domain.datasource.CocktailsDataSource
import com.warko.coctailbrowser.domain.model.Cocktail
import com.warko.coctailbrowser.remote.api.CocktailsApi
import javax.inject.Inject

class RemoteCocktailDataSource @Inject constructor(
    private val cocktailsApi: CocktailsApi
) : CocktailsDataSource {

    override suspend fun loadCocktails(term: String): List<Cocktail> {
        return cocktailsApi.loadCocktails(term).drinks.toDomain()
    }

    override suspend fun loadCocktailsByIngredient(term: String): List<Cocktail> {
        return cocktailsApi.loadCocktails(term).drinks.toDomain()
    }

    override suspend fun loadCocktailDetails(cocktailId: String): Cocktail {
        return cocktailsApi.loadCocktailDetails(cocktailId).drinks.toDomain().first()
    }

    override suspend fun loadRandomCocktail(): Cocktail {
        return cocktailsApi.loadRandomCocktail().drinks.toDomain().first()
    }
}