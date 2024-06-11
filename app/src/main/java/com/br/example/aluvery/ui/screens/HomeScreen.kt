package com.br.example.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.br.example.aluvery.model.Product
import com.br.example.aluvery.samples.sampleCandies
import com.br.example.aluvery.samples.sampleDrinks
import com.br.example.aluvery.samples.sampleProducts
import com.br.example.aluvery.samples.sampleSections
import com.br.example.aluvery.states.HomeScreenUiState
import com.br.example.aluvery.ui.components.CardProductItem
import com.br.example.aluvery.ui.components.ProductsSection
import com.br.example.aluvery.ui.components.SearchTextField
import com.br.example.aluvery.ui.theme.AluveryTheme
import com.br.example.aluvery.ui.viewmodels.HomeScreenViewModel

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel
) {
    val state = viewModel.uiState

    HomeScreen(state = state)
}

@Composable
fun HomeScreen(state: HomeScreenUiState = HomeScreenUiState()) {
    Column {
        val sections = state.sections
        val text = state.searchText
        val searchedProducts = state.searchedProducts

        SearchTextField(searchText = text, onSearchChange = state.onSearchChange)
        LazyColumn(
            Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            if (state.isShowSections()) {
                sections.forEach { section ->
                    val title = section.key
                    val products = section.value
                    item {
                        ProductsSection(
                            title = title,
                            products = products
                        )
                    }
                }
            } else {
                items(searchedProducts) {
                    CardProductItem(
                        product = it,
                        Modifier.padding(horizontal = 16.dp)
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(HomeScreenUiState(sections = sampleSections))
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenTextInitialPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(HomeScreenUiState(sections = sampleSections, searchText = "a"))
        }
    }
}