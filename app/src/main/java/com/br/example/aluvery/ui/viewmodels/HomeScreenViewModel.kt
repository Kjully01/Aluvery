package com.br.example.aluvery.ui.viewmodels


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.br.example.aluvery.dao.ProductDao
import com.br.example.aluvery.model.Product
import com.br.example.aluvery.samples.sampleCandies
import com.br.example.aluvery.samples.sampleDrinks
import com.br.example.aluvery.samples.sampleProducts
import com.br.example.aluvery.states.HomeScreenUiState

class HomeScreenViewModel : ViewModel() {

    private val dao = ProductDao()
    var uiState: HomeScreenUiState by mutableStateOf(HomeScreenUiState(
        sections = mapOf(
            "Todos os produtos" to dao.products(),
            "Promoções" to sampleDrinks + sampleCandies,
            "Doces" to sampleCandies,
            "Bebidas" to sampleDrinks
        ),
        onSearchChange = {
            uiState = uiState.copy(searchText = it, searchedProducts = searchedProducts(it))
        }
    ))
        private set

    private fun containsInNameOrDescription(text: String): (Product) -> Boolean = {
        it.name.contains(
            text,
            ignoreCase = true
        )
                || it.description?.contains(
            text,
            ignoreCase = true
        ) ?: false
    }

    private fun searchedProducts(text: String): List<Product> =
        if (text.isNotBlank()) {
            sampleProducts.filter(containsInNameOrDescription(text)) +
                    dao.products().filter(containsInNameOrDescription(text))
        } else emptyList()


}