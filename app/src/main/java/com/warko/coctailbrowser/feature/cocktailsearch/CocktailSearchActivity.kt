package com.warko.coctailbrowser.feature.cocktailsearch

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import com.warko.coctailbrowser.common.BaseActivity

class CocktailSearchActivity : BaseActivity<CocktailSearchViewModel>() {

    override val viewModel: CocktailSearchViewModel by viewModel()

    override fun injectDependencies() {
        DaggerCocktailSearchActivityComponent.factory()
            .create(this)
            .inject(this)
    }

    @Composable
    override fun ScreenContent() {
        SearchCocktailScreen(viewModel::handleUiEvent, emptyList())
    }

    companion object {
        fun newIntent(context: Context): Intent =
            Intent(context, CocktailSearchActivity::class.java)
    }
}