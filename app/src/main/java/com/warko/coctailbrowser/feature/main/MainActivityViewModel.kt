package com.warko.coctailbrowser.feature.main

import com.warko.coctailbrowser.common.BaseViewModel
import com.warko.coctailbrowser.common.mvi.EmptyUiState
import com.warko.coctailbrowser.common.navigator.AppScreens
import com.warko.coctailbrowser.common.navigator.ScreensNavigator
import com.warko.coctailbrowser.feature.main.mvi.MainActivityStateHandler
import com.warko.coctailbrowser.feature.main.mvi.MainAppAction
import com.warko.coctailbrowser.feature.main.mvi.MainUiEvent
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    mainActivityStateHandler: MainActivityStateHandler,
    private val screensNavigator: ScreensNavigator
) : BaseViewModel<EmptyUiState, MainUiEvent, MainAppAction>(mainActivityStateHandler) {

    override fun handleUiEvent(event: MainUiEvent) {
        when (event) {
            MainUiEvent.SearchCocktailClicked -> screensNavigator.navigateTo(AppScreens.CocktailSearch)
            MainUiEvent.SearchIngredientClicked -> screensNavigator.navigateTo(AppScreens.IngredientSearch)
            MainUiEvent.GetRandomCocktailClicked -> screensNavigator.navigateTo(AppScreens.RandomCocktail)
        }
    }
}