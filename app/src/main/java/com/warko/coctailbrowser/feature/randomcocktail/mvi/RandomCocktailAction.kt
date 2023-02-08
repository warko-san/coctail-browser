package com.warko.coctailbrowser.feature.randomcocktail.mvi

import com.warko.coctailbrowser.common.mvi.AppAction
import com.warko.coctailbrowser.common.mvi.UiEvent
import com.warko.coctailbrowser.domain.model.Cocktail

sealed class RandomCocktailAction : AppAction {

    data class CocktailLoad(val cocktail: Cocktail) : RandomCocktailAction()

}