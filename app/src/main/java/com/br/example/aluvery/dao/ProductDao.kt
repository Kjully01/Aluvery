package com.br.example.aluvery.dao

import com.br.example.aluvery.samples.sampleProducts

class ProductDao {

    companion object {
        private val products = sampleProducts.toMutableList()
    }

    fun products() = products.toList()

}