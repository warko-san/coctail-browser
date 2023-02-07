package com.warko.coctailbrowser.feature.randomcocktail

import com.warko.coctailbrowser.common.BaseViewModel
import com.warko.coctailbrowser.feature.randomcocktail.mvi.RandomCocktailAction
import com.warko.coctailbrowser.feature.randomcocktail.mvi.RandomCocktailState
import com.warko.coctailbrowser.feature.randomcocktail.mvi.RandomCocktailStateHandler
import com.warko.coctailbrowser.feature.randomcocktail.mvi.RandomCocktailUiEvent
import javax.inject.Inject

class RandomCocktailViewModel @Inject constructor(
    randomCocktailStateHandler: RandomCocktailStateHandler
) : BaseViewModel<RandomCocktailState, RandomCocktailUiEvent, RandomCocktailAction>(randomCocktailStateHandler) {

    override fun handleUiEvent(event: RandomCocktailUiEvent) {

    }
}