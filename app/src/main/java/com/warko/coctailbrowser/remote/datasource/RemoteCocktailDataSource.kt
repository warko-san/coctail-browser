package com.warko.coctailbrowser.remote.datasource

import com.warko.coctailbrowser.domain.datasource.CocktailsDataSource
import com.warko.coctailbrowser.domain.model.Cocktail
import com.warko.coctailbrowser.remote.api.CocktailsApi

class RemoteCocktailDataSource(
    private val cocktailsApi: CocktailsApi
) : CocktailsDataSource {

    override suspend fun loadCocktails(term: String): List<Cocktail> {
        return cocktailsApi.loadCocktails(term).toDomain()
    }
}