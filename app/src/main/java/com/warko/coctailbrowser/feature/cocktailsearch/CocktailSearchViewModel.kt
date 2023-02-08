package com.warko.coctailbrowser.feature.cocktailsearch

import com.warko.coctailbrowser.common.BaseViewModel
import com.warko.coctailbrowser.common.mvi.ExitEffect
import com.warko.coctailbrowser.common.navigator.ScreensNavigator
import com.warko.coctailbrowser.domain.di.UseCaseModule_ProvideLoadCocktailsUseCaseFactory
import com.warko.coctailbrowser.domain.usecase.LoadCocktailDetailsUseCase
import com.warko.coctailbrowser.domain.usecase.LoadCocktailsUseCase
import com.warko.coctailbrowser.feature.cocktailsearch.mvi.CocktailSearchAction
import com.warko.coctailbrowser.feature.cocktailsearch.mvi.CocktailSearchState
import com.warko.coctailbrowser.feature.cocktailsearch.mvi.CocktailSearchStateHandler
import com.warko.coctailbrowser.feature.cocktailsearch.mvi.CocktailSearchUiEvent
import javax.inject.Inject

class CocktailSearchViewModel @Inject constructor(
    cocktailSearchStateHandler: CocktailSearchStateHandler,
    private val screensNavigator: ScreensNavigator,
    private val loadCocktailsUseCase: LoadCocktailsUseCase,
    private val loadCocktailDetailsUseCase: LoadCocktailDetailsUseCase
) :
    BaseViewModel<CocktailSearchState, CocktailSearchUiEvent, CocktailSearchAction>(cocktailSearchStateHandler) {

    override fun handleUiEvent(event: CocktailSearchUiEvent) {
        when(event) {
            is CocktailSearchUiEvent.TextEntered -> {
                launch {
                    val cocktails = loadCocktailsUseCase.loadCocktails(event.term)
                    stateHandler.mutateState(CocktailSearchAction.ShowCocktails(cocktails))
                }
            }
            is CocktailSearchUiEvent.CocktailClicked -> {
                launch {
                    val cocktail = loadCocktailDetailsUseCase.loadCocktailDetails(event.cocktailId)
                    stateHandler.mutateState(CocktailSearchAction.ShowCocktailDetails(cocktail))
                }
            }
            is CocktailSearchUiEvent.BackClicked -> {
                val effect = stateHandler.mutateState(CocktailSearchAction.GoBack)
                if (effect == ExitEffect) {
                    screensNavigator.back()
                }
            }
        }
    }
}