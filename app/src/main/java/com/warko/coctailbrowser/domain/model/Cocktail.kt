package com.warko.coctailbrowser.domain.model

data class Cocktail(
    val id: String,
    val name: String,
    val tags: List<String>,
    val category: String,
    val videoUrl: String?,
    val imageUrl: String,
    val instructions: String
)