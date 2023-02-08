package com.warko.coctailbrowser.domain.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend inline fun <T> doOnBackground(crossinline block: suspend () -> T) =
    withContext(Dispatchers.IO) {
        block()
    }