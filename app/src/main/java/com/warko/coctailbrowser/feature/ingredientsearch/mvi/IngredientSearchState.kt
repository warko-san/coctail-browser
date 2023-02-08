package com.warko.coctailbrowser.feature.ingredientsearch.mvi

import com.warko.coctailbrowser.common.mvi.UiState
import com.warko.coctailbrowser.domain.model.Cocktail

data class IngredientSearchState(
    val term: String = "",
    val cocktails: List<Cocktail> = emptyList(),
    val selectedCocktail: Cocktail? = null,
    val currentScreen: IngredientSearchScreen = IngredientSearchScreen.SEARCH
) : UiState