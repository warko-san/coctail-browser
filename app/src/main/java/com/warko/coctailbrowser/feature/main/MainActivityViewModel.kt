package com.warko.coctailbrowser.feature.main

import com.warko.coctailbrowser.common.BaseViewModel
import com.warko.coctailbrowser.common.mvi.EmptyUiState
import com.warko.coctailbrowser.feature.main.mvi.MainActivityStateHandler
import com.warko.coctailbrowser.feature.main.mvi.MainAppAction
import com.warko.coctailbrowser.feature.main.mvi.MainUiEvent
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    mainActivityStateHandler: MainActivityStateHandler
) : BaseViewModel<EmptyUiState, MainAppAction, MainUiEvent>(mainActivityStateHandler) {

    override fun handleUiEvent(event: MainUiEvent) {
        when(event) {
            MainUiEvent.SearchCocktailClicked -> stateHandler.mutateState(MainAppAction.NavigateToCocktailSearch)
            MainUiEvent.SearchIngredientClicked -> stateHandler.mutateState(MainAppAction.NavigateToIngredientSearch)
            MainUiEvent.GetRandomCocktailClicked -> stateHandler.mutateState(MainAppAction.NavigateToRandomCocktail)
        }
    }
}