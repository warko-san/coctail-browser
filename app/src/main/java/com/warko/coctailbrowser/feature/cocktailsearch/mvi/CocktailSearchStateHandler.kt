package com.warko.coctailbrowser.feature.cocktailsearch.mvi

import com.warko.coctailbrowser.common.mvi.BaseStateHandler
import com.warko.coctailbrowser.common.mvi.Effect
import javax.inject.Inject

class CocktailSearchStateHandler @Inject constructor() : BaseStateHandler<CocktailSearchState, CocktailSearchAction>() {

    override var state: CocktailSearchState
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun reduce(oldState: CocktailSearchState, action: CocktailSearchAction): Effect {
        TODO("Not yet implemented")
    }
}