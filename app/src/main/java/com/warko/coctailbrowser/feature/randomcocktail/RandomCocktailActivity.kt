package com.warko.coctailbrowser.feature.randomcocktail

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.warko.coctailbrowser.CocktailApplication
import com.warko.coctailbrowser.common.BaseActivity
import com.warko.coctailbrowser.common.di.module.ActivityModule
import com.warko.coctailbrowser.feature.randomcocktail.mvi.RandomCocktailState

class RandomCocktailActivity : BaseActivity<RandomCocktailViewModel>() {

    override val viewModel: RandomCocktailViewModel by viewModel()

    override fun injectDependencies() {
        DaggerRandomCocktailActivityComponent.factory()
            .create(ActivityModule(this), (application as CocktailApplication).component)
            .inject(this)
    }

    @Composable
    override fun ScreenContent() {
        val state by viewModel.uiStateData.observeAsState(RandomCocktailState())

        LaunchedEffect(key1 = null, block = {
            viewModel.loadRandomCockt()
        })
        CocktailDetails(viewModel::handleUiEvent, state.cocktail)
    }

    companion object {
        fun newIntent(context: Context): Intent =
            Intent(context, RandomCocktailActivity::class.java)
    }

}