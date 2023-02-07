package com.warko.coctailbrowser.feature.main

import androidx.compose.runtime.Composable
import com.warko.coctailbrowser.common.BaseActivity

class MainActivity : BaseActivity<MainActivityViewModel>() {

    override val viewModel: MainActivityViewModel by viewModel()

    override fun injectDependencies() {
        DaggerMainActivityComponent.factory()
            .create(this)
            .inject(this)
    }

    @Composable
    override fun ScreenContent() {
        MainScreen()
    }
}