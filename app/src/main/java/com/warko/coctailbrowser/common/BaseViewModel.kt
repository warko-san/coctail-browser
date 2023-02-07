package com.warko.coctailbrowser.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.warko.coctailbrowser.common.mvi.AppAction
import com.warko.coctailbrowser.common.mvi.BaseStateHandler
import com.warko.coctailbrowser.common.mvi.UiEvent
import com.warko.coctailbrowser.common.mvi.UiState

abstract class BaseViewModel<STATE : UiState,  EVENT : UiEvent, ACTION : AppAction,>(
    protected val stateHandler: BaseStateHandler<STATE, ACTION>
) : ViewModel() {

    val uiStateData: LiveData<STATE> get() = stateHandler.uiStateData

    abstract fun handleUiEvent(event: EVENT)

}