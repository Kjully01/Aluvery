package com.br.example.aluvery.dao

import com.br.example.aluvery.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductDao {

    companion object {
        private val products = MutableStateFlow<List<Product>>(emptyList())
    }

    fun products(): StateFlow<List<Product>> = products.asStateFlow()

    fun save(product: Product) {
        products.value += product
    }

}