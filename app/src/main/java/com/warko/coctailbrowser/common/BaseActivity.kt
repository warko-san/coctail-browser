package com.warko.coctailbrowser.common

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

abstract class BaseActivity<VIEW_MODEL : BaseViewModel> : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected abstract val viewModel: VIEW_MODEL

    abstract fun injectDependencies()

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        super.onCreate(savedInstanceState)
    }

    inline fun <reified VIEW_MODEL : ViewModel> viewModel(): Lazy<VIEW_MODEL> = lazy {
        ViewModelProvider(this, viewModelFactory)[VIEW_MODEL::class.java]
    }

}