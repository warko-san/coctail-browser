package com.warko.coctailbrowser.remote.api

import com.warko.coctailbrowser.remote.model.Drinks
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailsApi {

    @GET("search.php")
    suspend fun loadCocktails(@Query("s") term: String): Drinks

}