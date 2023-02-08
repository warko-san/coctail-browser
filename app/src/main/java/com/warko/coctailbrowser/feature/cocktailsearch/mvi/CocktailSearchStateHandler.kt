package com.warko.coctailbrowser.feature.cocktailsearch.mvi

import com.warko.coctailbrowser.common.mvi.BaseStateHandler
import com.warko.coctailbrowser.common.mvi.Effect
import com.warko.coctailbrowser.common.mvi.ExitEffect
import com.warko.coctailbrowser.common.mvi.NoEffect
import com.warko.coctailbrowser.domain.model.Cocktail
import javax.inject.Inject

class CocktailSearchStateHandler @Inject constructor() :
    BaseStateHandler<CocktailSearchState, CocktailSearchAction>() {

    override var state: CocktailSearchState = CocktailSearchState()

    override fun reduce(oldState: CocktailSearchState, action: CocktailSearchAction): Effect {
        return when (action) {
            is CocktailSearchAction.ShowCocktails -> doWithoutEffect {
                addCocktails(
                    action.list,
                    oldState
                )
            }
            is CocktailSearchAction.ShowCocktailDetails -> doWithoutEffect {
                addCocktailDetails(
                    action.cocktail,
                    oldState
                )
            }
            CocktailSearchAction.GoBack -> resolveState(oldState)
        }
    }

    private fun resolveState(oldState: CocktailSearchState): Effect {
        return when (oldState.currentScreen) {
            SearchCocktailScreen.DETAILS -> {
                state =
                    oldState.copy(
                        currentScreen = SearchCocktailScreen.SEARCH,
                        selectedCocktail = null
                    )
                NoEffect
            }
            SearchCocktailScreen.SEARCH -> ExitEffect
        }
    }

    private fun addCocktails(list: List<Cocktail>, oldState: CocktailSearchState) {
        state = oldState.copy(cocktails = list)
    }

    private fun addCocktailDetails(cocktail: Cocktail, oldState: CocktailSearchState) {
        state = oldState.copy(selectedCocktail = cocktail, currentScreen = SearchCocktailScreen.DETAILS)
    }

}