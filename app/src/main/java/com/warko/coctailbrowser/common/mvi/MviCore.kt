package com.warko.coctailbrowser.common.mvi

interface UiState

interface UiEvent

interface AppAction

interface Effect

class EmptyUiState : UiState

object NoEffect : Effect
object ExitEffect : Effect