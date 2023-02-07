package com.warko.coctailbrowser.feature.main.mvi

import com.warko.coctailbrowser.common.mvi.BaseStateHandler
import com.warko.coctailbrowser.common.mvi.Effect
import com.warko.coctailbrowser.common.mvi.EmptyUiState
import javax.inject.Inject

class MainActivityStateHandler @Inject constructor() : BaseStateHandler<EmptyUiState, MainAppAction>() {

    override var state: EmptyUiState = EmptyUiState()

    override fun reduce(oldState: EmptyUiState, action: MainAppAction): Effect {
        return when (action) {
            MainAppAction.NavigateToCocktailSearch -> MainUiEffect.GoToSearch
            MainAppAction.NavigateToIngredientSearch -> MainUiEffect.GoToIngredientSearch
            MainAppAction.NavigateToRandomCocktail -> MainUiEffect.GoToRandom
        }
    }
}