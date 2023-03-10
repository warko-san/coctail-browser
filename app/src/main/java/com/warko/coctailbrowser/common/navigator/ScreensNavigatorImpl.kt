package com.warko.coctailbrowser.common.navigator

import android.app.Activity
import android.content.Context
import com.warko.coctailbrowser.common.di.qualifier.ActivityContext
import com.warko.coctailbrowser.feature.cocktailsearch.CocktailSearchActivity
import com.warko.coctailbrowser.feature.ingredientsearch.IngredientSearchActivity
import com.warko.coctailbrowser.feature.randomcocktail.RandomCocktailActivity
import javax.inject.Inject

class ScreensNavigatorImpl @Inject constructor(private val context: Activity) : ScreensNavigator {

    override fun navigateTo(screen: Screen) {
        when (screen) {
            AppScreens.CocktailSearch -> {
                context.startActivity(CocktailSearchActivity.newIntent(context))
            }
            AppScreens.IngredientSearch -> {
                context.startActivity(IngredientSearchActivity.newIntent(context))
            }
            AppScreens.RandomCocktail -> {
                context.startActivity(RandomCocktailActivity.newIntent(context))
            }
        }
    }

    override fun back() {
        context.onBackPressed()
    }

}