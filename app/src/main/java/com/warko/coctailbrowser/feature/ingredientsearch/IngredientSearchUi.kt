package com.warko.coctailbrowser.feature.ingredientsearch

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.warko.coctailbrowser.R
import com.warko.coctailbrowser.domain.model.Cocktail
import com.warko.coctailbrowser.feature.cocktailsearch.CocktailItem
import com.warko.coctailbrowser.feature.cocktailsearch.mvi.CocktailSearchUiEvent
import com.warko.coctailbrowser.feature.ingredientsearch.mvi.IngredientSearchUiEvent
import com.warko.coctailbrowser.ui.theme.CoctailBrowserTheme

@Composable
fun SearchIngredientScreenUi(
    onEvent: (IngredientSearchUiEvent) -> Unit,
    cocktails: List<Cocktail>
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
                        .clickable { onEvent(IngredientSearchUiEvent.BackClicked) }
                )
                Text(text = "Search cocktail", modifier = Modifier.padding(start = 16.dp))
            }
        }) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            var text by remember {
                mutableStateOf("")
            }
            TextField(
                value = text,
                onValueChange = { term ->
                    text = term
                    onEvent(IngredientSearchUiEvent.TextEntered(term))
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp, start = 16.dp, end = 16.dp)
            )
            LazyColumn(modifier = Modifier.padding(top = 16.dp)) {
                cocktails.forEach { cocktail ->
                    item {
                        CocktailItem(cocktail = cocktail) { cocktId ->
                            onEvent(IngredientSearchUiEvent.CocktailClicked(cocktId))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CocktailDetails(
    onEvent: (IngredientSearchUiEvent) -> Unit,
    selectedCocktail: Cocktail
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
                        .clickable { onEvent(IngredientSearchUiEvent.BackClicked) }
                )
                Text(text = "Cocktail details", modifier = Modifier.padding(start = 16.dp))
            }
        }) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            AsyncImage(
                model = selectedCocktail.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .padding(16.dp)
                    .wrapContentSize()
            )
            Text(text = selectedCocktail.name, modifier = Modifier.padding(top = 16.dp))
            Text(text = selectedCocktail.category, modifier = Modifier.padding(top = 8.dp))
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchIngredientScreenPreview() {
    CoctailBrowserTheme {
        SearchIngredientScreenUi({}, emptyList())
    }
}

@Preview(showBackground = true)
@Composable
private fun CocktailPreview() {
    CoctailBrowserTheme {
        CocktailItem(
            cocktail = Cocktail(
                id = "",
                name = "Margarita",
                tags = emptyList(),
                category = "Drink",
                videoUrl = null,
                imageUrl = "https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg",
                instructions = "Blabla"
            )
        ) {}
    }
}