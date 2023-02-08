package com.warko.coctailbrowser.feature.ingredientsearch

import com.warko.coctailbrowser.common.BaseViewModel
import com.warko.coctailbrowser.common.mvi.ExitEffect
import com.warko.coctailbrowser.common.navigator.ScreensNavigator
import com.warko.coctailbrowser.domain.usecase.LoadCocktailDetailsUseCase
import com.warko.coctailbrowser.domain.usecase.LoadCocktailsByIngredientUseCase
import com.warko.coctailbrowser.feature.cocktailsearch.mvi.CocktailSearchAction
import com.warko.coctailbrowser.feature.cocktailsearch.mvi.CocktailSearchUiEvent
import com.warko.coctailbrowser.feature.ingredientsearch.mvi.IngredientSearchAction
import com.warko.coctailbrowser.feature.ingredientsearch.mvi.IngredientSearchState
import com.warko.coctailbrowser.feature.ingredientsearch.mvi.IngredientSearchStateHandler
import com.warko.coctailbrowser.feature.ingredientsearch.mvi.IngredientSearchUiEvent
import javax.inject.Inject

class IngredientSearchViewModel @Inject constructor(
    ingredientSearchStateHandler: IngredientSearchStateHandler,
    private val loadCocktailDetailsUseCase: LoadCocktailDetailsUseCase,
    private val loadCocktailsByIngredientUseCase: LoadCocktailsByIngredientUseCase,
    private val screensNavigator: ScreensNavigator
) : BaseViewModel<IngredientSearchState, IngredientSearchUiEvent, IngredientSearchAction>(ingredientSearchStateHandler) {

    override fun handleUiEvent(event: IngredientSearchUiEvent) {
        when(event) {
            is IngredientSearchUiEvent.TextEntered -> {
                launch {
                    val cocktails = loadCocktailsByIngredientUseCase.loadCocktails(event.term)
                    stateHandler.mutateState(IngredientSearchAction.ShowCocktails(cocktails))
                }
            }
            is IngredientSearchUiEvent.CocktailClicked -> {
                launch {
                    val cocktail = loadCocktailDetailsUseCase.loadCocktailDetails(event.cocktailId)
                    stateHandler.mutateState(IngredientSearchAction.ShowCocktailDetails(cocktail))
                }
            }
            is IngredientSearchUiEvent.BackClicked -> {
                val effect = stateHandler.mutateState(IngredientSearchAction.GoBack)
                if (effect == ExitEffect) {
                    screensNavigator.back()
                }
            }
        }
    }
}