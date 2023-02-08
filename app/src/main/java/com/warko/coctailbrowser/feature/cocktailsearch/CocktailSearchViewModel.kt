package com.warko.coctailbrowser.feature.cocktailsearch

import com.warko.coctailbrowser.common.BaseViewModel
import com.warko.coctailbrowser.common.navigator.ScreensNavigator
import com.warko.coctailbrowser.feature.cocktailsearch.mvi.CocktailSearchAction
import com.warko.coctailbrowser.feature.cocktailsearch.mvi.CocktailSearchState
import com.warko.coctailbrowser.feature.cocktailsearch.mvi.CocktailSearchStateHandler
import com.warko.coctailbrowser.feature.cocktailsearch.mvi.CocktailSearchUiEvent
import javax.inject.Inject

class CocktailSearchViewModel @Inject constructor(
    cocktailSearchStateHandler: CocktailSearchStateHandler,
    private val screensNavigator: ScreensNavigator
) :
    BaseViewModel<CocktailSearchState, CocktailSearchUiEvent, CocktailSearchAction>(cocktailSearchStateHandler) {

    override fun handleUiEvent(event: CocktailSearchUiEvent) {
        when(event) {
            is CocktailSearchUiEvent.TextEntered -> {
                stateHandler.mutateState(CocktailSearchAction.ShowCocktails(emptyList()))
            }
            is CocktailSearchUiEvent.CocktailClicked -> {
                stateHandler.mutateState(CocktailSearchAction.ShowCocktailDetails(event.cocktailId))
            }
            is CocktailSearchUiEvent.BackClicked -> {
                screensNavigator.back()
            }
        }
    }
}