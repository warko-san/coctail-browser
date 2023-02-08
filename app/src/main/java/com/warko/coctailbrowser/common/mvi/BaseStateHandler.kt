package com.warko.coctailbrowser.common.mvi

import androidx.lifecycle.MutableLiveData

abstract class BaseStateHandler<STATE : UiState, ACTION : AppAction> {

    val uiStateData = MutableLiveData<STATE>()

    protected abstract var state: STATE

    abstract fun reduce(oldState: STATE, action: ACTION) : Effect

    fun mutateState(action: ACTION): Effect {
        val effect = reduce(state, action)
        uiStateData.postValue(state)

        return effect
    }

    protected inline fun doWithoutEffect(block: () -> Unit): Effect {
        block()
        return NoEffect
    }

}