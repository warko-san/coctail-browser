package com.warko.coctailbrowser.feature.ingredientsearch

import com.warko.coctailbrowser.common.BaseViewModel
import com.warko.coctailbrowser.feature.ingredientsearch.mvi.IngredientSearchAction
import com.warko.coctailbrowser.feature.ingredientsearch.mvi.IngredientSearchState
import com.warko.coctailbrowser.feature.ingredientsearch.mvi.IngredientSearchStateHandler
import com.warko.coctailbrowser.feature.ingredientsearch.mvi.IngredientSearchUiEvent
import javax.inject.Inject

class IngredientSearchViewModel @Inject constructor(
    ingredientSearchStateHandler: IngredientSearchStateHandler
) : BaseViewModel<IngredientSearchState, IngredientSearchUiEvent, IngredientSearchAction>(ingredientSearchStateHandler) {

    override fun handleUiEvent(event: IngredientSearchUiEvent) {
        TODO("Not yet implemented")
    }
}