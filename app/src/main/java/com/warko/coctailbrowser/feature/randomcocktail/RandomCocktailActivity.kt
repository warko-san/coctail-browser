package com.warko.coctailbrowser.feature.randomcocktail

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import com.warko.coctailbrowser.common.BaseActivity

class RandomCocktailActivity : BaseActivity<RandomCocktailViewModel>() {

    override val viewModel: RandomCocktailViewModel
        get() = TODO("Not yet implemented")

    override fun injectDependencies() {
        TODO("Not yet implemented")
    }

    @Composable
    override fun ScreenContent() {
        TODO("Not yet implemented")
    }

    companion object {
        fun newIntent(context: Context): Intent =
            Intent(context, RandomCocktailActivity::class.java)
    }

}