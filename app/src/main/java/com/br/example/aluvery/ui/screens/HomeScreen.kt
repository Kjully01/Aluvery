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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.br.example.aluvery.model.Product
import com.br.example.aluvery.samples.sampleProducts
import com.br.example.aluvery.samples.sampleSections
import com.br.example.aluvery.ui.components.CardProductItem
import com.br.example.aluvery.ui.components.ProductsSection
import com.br.example.aluvery.ui.components.SearchTextField
import com.br.example.aluvery.ui.theme.AluveryTheme

class HomeScreenUiState(searchText: String = "") {

    var text by mutableStateOf(searchText)
        private set

    val searchedProducts
        get() =
            if (text.isNotBlank()) {
                sampleProducts.filter {
                    it.name.contains(text, ignoreCase = true)
                            || it.description?.contains(text, ignoreCase = true) ?: false
                }
            } else emptyList()

    fun isShowSections(): Boolean {
        return text.isBlank()
    }

    val onSearchChange: (String) -> Unit = { searchText ->
        text = searchText
    }

}

@Composable
fun HomeScreen(sections: Map<String, List<Product>>, state: HomeScreenUiState = HomeScreenUiState()) {
    Column {
        val text = state.text
        val searchedProducts = remember(text) {
            state.searchedProducts
        }

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
            HomeScreen(sampleSections)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenTextInitialPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(sampleSections, HomeScreenUiState("a"))
        }
    }
}