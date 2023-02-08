package com.warko.coctailbrowser.feature.randomcocktail.mvi

import com.warko.coctailbrowser.common.mvi.UiState
import com.warko.coctailbrowser.domain.model.Cocktail

data class RandomCocktailState(val cocktail: Cocktail? = null) : UiState