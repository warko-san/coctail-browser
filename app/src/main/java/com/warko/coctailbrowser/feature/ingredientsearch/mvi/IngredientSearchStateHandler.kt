package com.warko.coctailbrowser.feature.ingredientsearch.mvi

import com.warko.coctailbrowser.common.mvi.BaseStateHandler
import com.warko.coctailbrowser.common.mvi.Effect
import com.warko.coctailbrowser.common.mvi.ExitEffect
import com.warko.coctailbrowser.common.mvi.NoEffect
import com.warko.coctailbrowser.domain.model.Cocktail
import com.warko.coctailbrowser.feature.cocktailsearch.mvi.CocktailSearchAction
import com.warko.coctailbrowser.feature.cocktailsearch.mvi.CocktailSearchScreen
import com.warko.coctailbrowser.feature.cocktailsearch.mvi.CocktailSearchState
import javax.inject.Inject

class IngredientSearchStateHandler @Inject constructor() : BaseStateHandler<IngredientSearchState, IngredientSearchAction>() {

    override var state: IngredientSearchState = IngredientSearchState()

    override fun reduce(oldState: IngredientSearchState, action: IngredientSearchAction): Effect {
        return when (action) {
            is IngredientSearchAction.ShowCocktails -> doWithoutEffect {
                addCocktails(
                    action.list,
                    oldState
                )
            }
            is IngredientSearchAction.ShowCocktailDetails -> doWithoutEffect {
                addCocktailDetails(
                    action.cocktail,
                    oldState
                )
            }
            IngredientSearchAction.GoBack -> resolveState(oldState)
        }
    }

    private fun resolveState(oldState: IngredientSearchState): Effect {
        return when (oldState.currentScreen) {
            IngredientSearchScreen.DETAILS -> {
                state =
                    oldState.copy(
                        currentScreen = IngredientSearchScreen.SEARCH,
                        selectedCocktail = null
                    )
                NoEffect
            }
            IngredientSearchScreen.SEARCH -> ExitEffect
        }
    }

    private fun addCocktails(list: List<Cocktail>, oldState: IngredientSearchState) {
        state = oldState.copy(cocktails = list)
    }

    private fun addCocktailDetails(cocktail: Cocktail, oldState: IngredientSearchState) {
        state = oldState.copy(selectedCocktail = cocktail, currentScreen = IngredientSearchScreen.DETAILS)
    }

}