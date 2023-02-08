package com.warko.coctailbrowser.feature.randomcocktail.mvi

import com.warko.coctailbrowser.common.mvi.BaseStateHandler
import com.warko.coctailbrowser.common.mvi.Effect
import com.warko.coctailbrowser.domain.model.Cocktail
import javax.inject.Inject

class RandomCocktailStateHandler @Inject constructor() : BaseStateHandler<RandomCocktailState, RandomCocktailAction>() {

    override var state: RandomCocktailState = RandomCocktailState()

    override fun reduce(oldState: RandomCocktailState, action: RandomCocktailAction): Effect {
        return when(action) {
            is RandomCocktailAction.CocktailLoad -> doWithoutEffect { addCocktail(action.cocktail, oldState) }
        }
    }

    private fun addCocktail(cocktail: Cocktail, oldState: RandomCocktailState) {
        state = oldState.copy(cocktail = cocktail)
    }
}