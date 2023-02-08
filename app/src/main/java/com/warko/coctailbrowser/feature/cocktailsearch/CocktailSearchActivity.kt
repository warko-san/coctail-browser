package com.warko.coctailbrowser.feature.cocktailsearch

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.warko.coctailbrowser.common.BaseActivity
import com.warko.coctailbrowser.feature.cocktailsearch.mvi.CocktailSearchState

class CocktailSearchActivity : BaseActivity<CocktailSearchViewModel>() {

    override val viewModel: CocktailSearchViewModel by viewModel()

    override fun injectDependencies() {
        DaggerCocktailSearchActivityComponent.factory()
            .create(this)
            .inject(this)
    }

    @Composable
    override fun ScreenContent() {
        val state by viewModel.uiStateData.observeAsState(CocktailSearchState())

        SearchCocktailScreen(viewModel::handleUiEvent, state)
    }

    companion object {
        fun newIntent(context: Context): Intent =
            Intent(context, CocktailSearchActivity::class.java)
    }
}