package com.warko.coctailbrowser.feature.cocktailsearch

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.warko.coctailbrowser.ui.theme.CoctailBrowserTheme

@Composable
fun SearchCocktailScreen() {
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
                .fillMaxSize(), verticalArrangement = Arrangement.Center
        ) {
            var text by remember {
                mutableStateOf("")
            }
            TextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchCocktailScreenPreview() {
    CoctailBrowserTheme {
        SearchCocktailScreen()
    }
}