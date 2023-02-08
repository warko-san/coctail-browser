package com.warko.coctailbrowser.feature.randomcocktail

import com.warko.coctailbrowser.common.BaseViewModel
import com.warko.coctailbrowser.common.navigator.ScreensNavigator
import com.warko.coctailbrowser.domain.usecase.LoadRandomCocktailUseCase
import com.warko.coctailbrowser.feature.randomcocktail.mvi.RandomCocktailAction
import com.warko.coctailbrowser.feature.randomcocktail.mvi.RandomCocktailState
import com.warko.coctailbrowser.feature.randomcocktail.mvi.RandomCocktailStateHandler
import com.warko.coctailbrowser.feature.randomcocktail.mvi.RandomCocktailUiEvent
import javax.inject.Inject

class RandomCocktailViewModel @Inject constructor(
    randomCocktailStateHandler: RandomCocktailStateHandler,
    private val loadRandomCocktailUseCase: LoadRandomCocktailUseCase,
    private val screensNavigator: ScreensNavigator
) : BaseViewModel<RandomCocktailState, RandomCocktailUiEvent, RandomCocktailAction>(randomCocktailStateHandler) {

    override fun handleUiEvent(event: RandomCocktailUiEvent) {
        when(event) {
            RandomCocktailUiEvent.BackClicked -> screensNavigator.back()
        }
    }

    suspend fun loadRandomCockt() {
        val cocktail = loadRandomCocktailUseCase.loadRandomCocktail()
        stateHandler.mutateState(RandomCocktailAction.CocktailLoad(cocktail))
    }

}