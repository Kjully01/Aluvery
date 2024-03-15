package com.br.example.aluvery.samples

import com.br.example.aluvery.R
import com.br.example.aluvery.model.Product
import java.math.BigDecimal

val sampleProducts = listOf(
    Product(
        "Hamburguer",
        BigDecimal(13.00),
        R.drawable.burger
    ),
    Product(
        "Pizza",
        BigDecimal(24.99),
        R.drawable.pizza
    ),
    Product(
        "Batata Frita",
        BigDecimal(7.50),
        R.drawable.fries
    )
)