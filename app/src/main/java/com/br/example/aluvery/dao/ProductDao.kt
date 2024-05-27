package com.br.example.aluvery.dao

import androidx.compose.runtime.mutableStateListOf
import com.br.example.aluvery.model.Product
import com.br.example.aluvery.samples.sampleProducts

class ProductDao {

    companion object {
        private val products = mutableStateListOf<Product>()
    }

    fun products() = products.toList()

    fun save(product: Product) {
        products.add(product)
    }

}