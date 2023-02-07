package com.warko.coctailbrowser.feature.cocktailsearch

import com.warko.coctailbrowser.common.BaseViewModel
import com.warko.coctailbrowser.feature.cocktailsearch.mvi.CocktailSearchAction
import com.warko.coctailbrowser.feature.cocktailsearch.mvi.CocktailSearchState
import com.warko.coctailbrowser.feature.cocktailsearch.mvi.CocktailSearchStateHandler
import com.warko.coctailbrowser.feature.cocktailsearch.mvi.CocktailSearchUiEvent
import javax.inject.Inject

class CocktailSearchViewModel @Inject constructor(
    cocktailSearchStateHandler: CocktailSearchStateHandler
) :
    BaseViewModel<CocktailSearchState, CocktailSearchUiEvent, CocktailSearchAction>(cocktailSearchStateHandler) {

    override fun handleUiEvent(event: CocktailSearchUiEvent) {

    }
}