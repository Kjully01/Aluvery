package com.br.example.aluvery.states

import java.math.BigDecimal

class ProductFormUiState(
    val url: String = "",
    val name: String = "",
    val price: String = "",
    val description: String = "",
    val onValueChangeUrl: (String) -> Unit = {},
    val onValueChangeName: (String) -> Unit = {},
    val onValueChangePrice: (String) -> Unit = {},
    val onValueChangeDescription: (String) -> Unit = {}
) {

    fun isPriceError(price: String): Boolean {
        return try {
            BigDecimal(price)
            false
        } catch (e: IllegalArgumentException) {
            price.isNotEmpty()
        }
    }

    fun isShowImage(): Boolean {
        return url.isNotBlank()
    }
}