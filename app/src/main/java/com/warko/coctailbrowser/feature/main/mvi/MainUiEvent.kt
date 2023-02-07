package com.warko.coctailbrowser.feature.main.mvi

import com.warko.coctailbrowser.common.mvi.UiEvent

sealed class MainUiEvent : UiEvent {

    object SearchCocktailClicked : MainUiEvent()
    object SearchIngredientClicked : MainUiEvent()
    object GetRandomCocktailClicked : MainUiEvent()

}
