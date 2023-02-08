package com.warko.coctailbrowser.feature.ingredientsearch.mvi

import com.warko.coctailbrowser.common.mvi.AppAction
import com.warko.coctailbrowser.common.mvi.UiEvent
import com.warko.coctailbrowser.domain.model.Cocktail
import com.warko.coctailbrowser.feature.cocktailsearch.mvi.CocktailSearchAction

sealed class IngredientSearchAction : AppAction {

    data class ShowCocktails(val list: List<Cocktail>) : IngredientSearchAction()
    data class ShowCocktailDetails(val cocktail: Cocktail) : IngredientSearchAction()

    object GoBack : IngredientSearchAction()

}