package com.warko.coctailbrowser.remote.model

import com.google.gson.annotations.SerializedName

class Drinks(
    @SerializedName("drinks")
    val drinks: List<RemoteCocktail>

)

class RemoteCocktail(
    @SerializedName("idDrink")
    val id: String,
    @SerializedName("strDrink")
    val name: String,
    @SerializedName("strTags")
    val tagsString: String?,
    @SerializedName("strCategory")
    val category: String,
    @SerializedName("strVideo")
    val videoUrl: String?,
    @SerializedName("strDrinkThumb")
    val imageUrl: String,
    @SerializedName("strInstructions")
    val instructions: String
)