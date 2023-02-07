package com.warko.coctailbrowser.common.navigator

import android.content.Context
import com.warko.coctailbrowser.feature.cocktailsearch.CocktailSearchActivity
import com.warko.coctailbrowser.feature.ingredientsearch.IngredientSearchActivity
import com.warko.coctailbrowser.feature.randomcocktail.RandomCocktailActivity

class ScreensNavigatorImpl(private val context: Context) : ScreensNavigator {

    private var currentScreen: Screen = AppScreens.None

    override fun navigateTo(screen: Screen) {
        when (screen) {
            AppScreens.CocktailSearch -> {
                currentScreen = AppScreens.CocktailSearch
                context.startActivity(CocktailSearchActivity.newIntent(context))
            }
            AppScreens.IngredientSearch -> {
                currentScreen = AppScreens.IngredientSearch
                context.startActivity(IngredientSearchActivity.newIntent(context))
            }
            AppScreens.RandomCocktail -> {
                currentScreen = AppScreens.RandomCocktail
                context.startActivity(RandomCocktailActivity.newIntent(context))
            }
        }
    }

    override fun back() {

    }

}