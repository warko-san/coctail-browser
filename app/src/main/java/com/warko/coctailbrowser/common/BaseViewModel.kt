package com.warko.coctailbrowser.common

import androidx.lifecycle.ViewModel
import com.warko.coctailbrowser.common.mvi.UiEvent

abstract class BaseViewModel<EVENT : UiEvent> : ViewModel() {

    abstract fun handleUiEvent(event: EVENT)

}