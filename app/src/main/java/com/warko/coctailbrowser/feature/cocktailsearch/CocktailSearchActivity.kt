package com.warko.coctailbrowser.feature.cocktailsearch

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.warko.coctailbrowser.CocktailApplication
import com.warko.coctailbrowser.common.BaseActivity
import com.warko.coctailbrowser.common.di.module.ActivityModule
import com.warko.coctailbrowser.feature.cocktailsearch.mvi.CocktailSearchState
import com.warko.coctailbrowser.feature.cocktailsearch.mvi.CocktailSearchScreen

class CocktailSearchActivity : BaseActivity<CocktailSearchViewModel>() {

    override val viewModel: CocktailSearchViewModel by viewModel()

    override fun injectDependencies() {
        DaggerCocktailSearchActivityComponent.factory()
            .create(ActivityModule(this), (application as CocktailApplication).component)
            .inject(this)
    }

    @Composable
    override fun ScreenContent() {
        val state by viewModel.uiStateData.observeAsState(CocktailSearchState())

        when(state.currentScreen) {
            CocktailSearchScreen.SEARCH -> {
                SearchCocktailScreenUi(viewModel::handleUiEvent, state.cocktails)
            }
            CocktailSearchScreen.DETAILS -> {
                CocktailDetails(viewModel::handleUiEvent, state.selectedCocktail!!)
            }
        }
    }

    companion object {
        fun newIntent(context: Context): Intent =
            Intent(context, CocktailSearchActivity::class.java)
    }
}