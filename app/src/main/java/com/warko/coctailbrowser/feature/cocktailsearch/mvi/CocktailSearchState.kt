package com.warko.coctailbrowser.feature.cocktailsearch.mvi

import com.warko.coctailbrowser.common.mvi.UiState
import com.warko.coctailbrowser.domain.model.Cocktail

data class CocktailSearchState(
    val term: String = "",
    val cocktails: List<Cocktail> = emptyList(),
    val selectedCocktail: Cocktail? = null,
    val currentScreen: SearchCocktailScreen = SearchCocktailScreen.SEARCH
) : UiState

enum class SearchCocktailScreen {
    SEARCH,
    DETAILS
}