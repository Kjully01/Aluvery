package com.br.example.aluvery.states

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import java.math.BigDecimal

class ProductFormUiState {
    var url by mutableStateOf("")
        private set
    var name by mutableStateOf("")
    var price by mutableStateOf("")
    var description by mutableStateOf("")
    var isPriceError by mutableStateOf(false)

    fun isShowImage(): Boolean {
        return url.isNotBlank()
    }

    val onValueChangeUrl: (String) -> Unit = {
        url = it
    }

    val onValueChangeName: (String) -> Unit = {
        name = it
    }

    val onValueChangePrice: (String) -> Unit = {
        isPriceError = try {
            BigDecimal(it)
            false
        } catch (e: IllegalArgumentException) {
            it.isNotEmpty()
        }
        price = it
    }

    val onValueChangeDescription: (String) -> Unit = {
        description = it
    }
}