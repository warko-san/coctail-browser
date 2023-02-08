package com.warko.coctailbrowser.feature.ingredientsearch

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
import com.warko.coctailbrowser.feature.ingredientsearch.mvi.IngredientSearchScreen
import com.warko.coctailbrowser.feature.ingredientsearch.mvi.IngredientSearchState

class IngredientSearchActivity : BaseActivity<IngredientSearchViewModel>() {

    override val viewModel: IngredientSearchViewModel by viewModel()

    override fun injectDependencies() {
        DaggerIngredientSearchActivityComponent.factory()
            .create(ActivityModule(this), (application as CocktailApplication).component)
            .inject(this)
    }

    @Composable
    override fun ScreenContent() {
        val state by viewModel.uiStateData.observeAsState(IngredientSearchState())

        when(state.currentScreen) {
            IngredientSearchScreen.SEARCH -> {
                SearchIngredientScreenUi(
                    viewModel::handleUiEvent,
                    state.cocktails
                )
            }
            IngredientSearchScreen.DETAILS -> {
                CocktailDetails(
                    viewModel::handleUiEvent,
                    state.selectedCocktail!!
                )
            }
        }
    }

    companion object {
        fun newIntent(context: Context): Intent =
            Intent(context, IngredientSearchActivity::class.java)
    }
}