package com.br.example.aluvery.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.br.example.aluvery.dao.ProductDao
import com.br.example.aluvery.model.Product
import com.br.example.aluvery.samples.sampleCandies
import com.br.example.aluvery.samples.sampleDrinks
import com.br.example.aluvery.samples.sampleProducts
import com.br.example.aluvery.samples.sampleSections
import com.br.example.aluvery.ui.screens.HomeScreen
import com.br.example.aluvery.ui.screens.HomeScreenUiState
import com.br.example.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {

    private val dao = ProductDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(onFabClick = {
                startActivity(Intent(this, ProductFormActivity::class.java))
            }) {
                val products = dao.products()
                val sections = mapOf(
                    "Todos os produtos" to products,
                    "Promoções" to sampleDrinks + sampleCandies,
                    "Doces" to sampleCandies,
                    "Bebidas" to sampleDrinks
                )
                var text by remember() {
                    mutableStateOf("")
                }

                fun containsInNameOrDescription(): (Product) -> Boolean = {
                    it.name.contains(
                        text,
                        ignoreCase = true
                    )
                            || it.description?.contains(
                        text,
                        ignoreCase = true
                    ) ?: false
                }

                val searchedProducts = remember(text, products) {
                    if (text.isNotBlank()) {
                        sampleProducts.filter(containsInNameOrDescription()) +
                                products.filter(containsInNameOrDescription())
                    } else emptyList()
                }

                val state = remember(products, text) {
                    HomeScreenUiState(
                        sections = sections,
                        searchedProducts = searchedProducts,
                        searchText = text,
                        onSearchChange = {
                            text = it
                        }
                    )
                }
                HomeScreen(state = state)
            }
        }
    }
}

@Composable
fun App(onFabClick: () -> Unit = {}, content: @Composable () -> Unit = {}) {
    AluveryTheme {
        Surface {
            Scaffold(floatingActionButton = {
                FloatingActionButton(onClick = onFabClick, shape = CircleShape) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                }
            }) { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                    content()
                }
            }
        }
    }
}

@Preview
@Composable
private fun AppPreview() {
    App {
        HomeScreen(HomeScreenUiState(sections = sampleSections))
    }
}