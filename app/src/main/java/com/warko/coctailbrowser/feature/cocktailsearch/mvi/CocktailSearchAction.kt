package com.warko.coctailbrowser.feature.cocktailsearch.mvi

import com.warko.coctailbrowser.common.mvi.AppAction
import com.warko.coctailbrowser.common.mvi.UiEvent
import com.warko.coctailbrowser.domain.model.Cocktail

sealed class CocktailSearchAction : AppAction {

    data class ShowCocktails(val list: List<Cocktail>) : CocktailSearchAction()
    data class ShowCocktailDetails(val cocktailId: String) : CocktailSearchAction()

}