package com.warko.coctailbrowser.feature.main.mvi

import com.warko.coctailbrowser.common.mvi.AppAction

sealed class MainAppAction : AppAction {

    object NavigateToCocktailSearch : MainAppAction()
    object NavigateToIngredientSearch : MainAppAction()
    object NavigateToRandomCocktail : MainAppAction()

}
