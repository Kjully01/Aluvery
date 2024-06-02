package com.br.example.aluvery.states

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

    fun isShowImage(): Boolean {
        return url.isNotBlank()
    }
}