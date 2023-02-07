package com.warko.coctailbrowser.feature.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.warko.coctailbrowser.feature.main.mvi.MainUiEvent
import com.warko.coctailbrowser.ui.theme.CoctailBrowserTheme

@Composable
fun MainScreen(
    onEvent: (MainUiEvent) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar() {
                Text(text = "Cocktail browser", modifier = Modifier.padding(start = 16.dp))
            }
        }) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(), verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { onEvent(MainUiEvent.SearchCocktailClicked) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(text = "Search for a cocktail")
            }
            Button(
                onClick = { onEvent(MainUiEvent.SearchIngredientClicked) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(text = "Search for an ingredient")
            }
            Button(
                onClick = { onEvent(MainUiEvent.GetRandomCocktailClicked) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(text = "Show random cocktail")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    CoctailBrowserTheme {
        MainScreen({})
    }
}