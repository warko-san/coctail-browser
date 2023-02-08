package com.warko.coctailbrowser.feature.ingredientsearch.mvi

import com.warko.coctailbrowser.common.mvi.UiEvent

sealed class IngredientSearchUiEvent : UiEvent {

    data class TextEntered(val term: String) : IngredientSearchUiEvent()
    data class CocktailClicked(val cocktId: String) : IngredientSearchUiEvent()

    object BackClicked: IngredientSearchUiEvent()

}