package com.warko.coctailbrowser.feature.randomcocktail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.warko.coctailbrowser.R
import com.warko.coctailbrowser.domain.model.Cocktail
import com.warko.coctailbrowser.feature.randomcocktail.mvi.RandomCocktailUiEvent

@Composable
fun CocktailDetails(
    onEvent: (RandomCocktailUiEvent) -> Unit,
    cocktail: Cocktail?
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .clickable { onEvent(RandomCocktailUiEvent.BackClicked) }
                )
                Text(text = "Cocktail details", modifier = Modifier.padding(start = 16.dp))
            }
        }) {
        if (cocktail != null) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
            ) {
                AsyncImage(
                    model = cocktail.imageUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                        .padding(16.dp)
                        .wrapContentSize()
                )
                Text(text = cocktail.name, modifier = Modifier.padding(top = 16.dp))
                Text(text = cocktail.category, modifier = Modifier.padding(top = 8.dp))
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}