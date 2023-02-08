package com.warko.coctailbrowser.feature.cocktailsearch

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.warko.coctailbrowser.domain.model.Cocktail
import com.warko.coctailbrowser.feature.cocktailsearch.mvi.CocktailSearchUiEvent
import com.warko.coctailbrowser.ui.theme.CoctailBrowserTheme

@Composable
fun SearchCocktailScreen(
    onEvent: (CocktailSearchUiEvent) -> Unit,
    cocktails: List<Cocktail>
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar() {
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
                onValueChange = {term ->
                    text = term
                    onEvent(CocktailSearchUiEvent.TextEntered(term))
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp, start = 16.dp, end = 16.dp)
            )
        }
        LazyColumn(modifier = Modifier.padding(top = 16.dp)) {
            cocktails.forEach { cocktail ->
                item {
                    CocktailItem(cocktail = cocktail) { cocktId ->
                        onEvent(CocktailSearchUiEvent.CocktailClicked(cocktId))
                    }
                }
            }
        }
    }
}

@Composable
private fun CocktailItem(cocktail: Cocktail, onClick: (String) -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .clickable {
                onClick(cocktail.id)
            }) {
        AsyncImage(
            model = cocktail.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(120.dp)
        )
        Text(text = cocktail.name, modifier = Modifier.padding(top = 16.dp))
        Text(text = cocktail.category, modifier = Modifier.padding(top = 8.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchCocktailScreenPreview() {
    CoctailBrowserTheme {
        SearchCocktailScreen({}, emptyList())
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