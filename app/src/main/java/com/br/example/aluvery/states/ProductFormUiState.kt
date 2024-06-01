package com.br.example.aluvery.states

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class ProductFormUiState {
    var url by mutableStateOf("")
    var name by mutableStateOf("")
    var price by mutableStateOf("")
    var description by mutableStateOf("")
    var isPriceError by mutableStateOf(false)

    fun isShowImage(): Boolean {
        return url.isNotBlank()
    }
}