package com.warko.coctailbrowser.feature.cocktailsearch.mvi

import com.warko.coctailbrowser.common.mvi.UiEvent

sealed class CocktailSearchUiEvent : UiEvent {

    object BackClicked : CocktailSearchUiEvent()

    data class TextEntered(val term: String) : CocktailSearchUiEvent()
    data class CocktailClicked(val cocktailId: String) : CocktailSearchUiEvent()

}