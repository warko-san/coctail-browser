package com.warko.coctailbrowser.feature.randomcocktail.mvi

import com.warko.coctailbrowser.common.mvi.BaseStateHandler
import com.warko.coctailbrowser.common.mvi.Effect
import javax.inject.Inject

class RandomCocktailStateHandler @Inject constructor() : BaseStateHandler<RandomCocktailState, RandomCocktailAction>() {

    override var state: RandomCocktailState
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun reduce(oldState: RandomCocktailState, action: RandomCocktailAction): Effect {
        TODO("Not yet implemented")
    }
}