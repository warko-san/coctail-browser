package com.warko.coctailbrowser.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.warko.coctailbrowser.common.mvi.AppAction
import com.warko.coctailbrowser.common.mvi.BaseStateHandler
import com.warko.coctailbrowser.common.mvi.UiEvent
import com.warko.coctailbrowser.common.mvi.UiState
import kotlinx.coroutines.launch

abstract class BaseViewModel<STATE : UiState, EVENT : UiEvent, ACTION : AppAction>(
    protected val stateHandler: BaseStateHandler<STATE, ACTION>
) : ViewModel() {

    val uiStateData: LiveData<STATE> get() = stateHandler.uiStateData

    abstract fun handleUiEvent(event: EVENT)

    inline fun launch(crossinline block: suspend () -> Unit) = viewModelScope.launch {
        block()
    }

}