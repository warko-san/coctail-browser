package com.warko.coctailbrowser.feature.main.mvi

import com.warko.coctailbrowser.common.mvi.Effect

sealed class MainUiEffect : Effect {

    object GoToSearch : MainUiEffect()
    object GoToIngredientSearch : MainUiEffect()
    object GoToRandom : MainUiEffect()

}
