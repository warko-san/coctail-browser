package com.warko.coctailbrowser.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Provider


class ViewModelProviderFactory(@JvmSuppressWildcards val creators: Map<Class<out ViewModel>, Provider<ViewModel>>) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator: Provider<ViewModel>? = creators[modelClass]

        return creator?.let {
            it.get() as T
        } ?: throw IllegalStateException("Unknown model class $modelClass")
    }
}