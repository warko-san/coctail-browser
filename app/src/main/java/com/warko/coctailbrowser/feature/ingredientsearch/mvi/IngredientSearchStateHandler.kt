package com.warko.coctailbrowser.feature.ingredientsearch.mvi

import com.warko.coctailbrowser.common.mvi.BaseStateHandler
import com.warko.coctailbrowser.common.mvi.Effect
import javax.inject.Inject

class IngredientSearchStateHandler @Inject constructor() : BaseStateHandler<IngredientSearchState, IngredientSearchAction>() {

    override var state: IngredientSearchState
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun reduce(oldState: IngredientSearchState, action: IngredientSearchAction): Effect {
        TODO("Not yet implemented")
    }
}