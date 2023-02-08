package com.warko.coctailbrowser.remote.datasource

import com.warko.coctailbrowser.domain.model.Cocktail
import com.warko.coctailbrowser.remote.model.RemoteCocktail

fun List<RemoteCocktail>.toDomain(): List<Cocktail> =
    map { Cocktail(
        it.id,
        it.name,
        it.tagsString?.split(",") ?: emptyList(),
        it.category,
        it.videoUrl,
        it.imageUrl,
        it.instructions
    ) }