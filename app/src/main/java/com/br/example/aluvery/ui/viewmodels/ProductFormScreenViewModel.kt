package com.br.example.aluvery.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.br.example.aluvery.dao.ProductDao
import com.br.example.aluvery.model.Product
import com.br.example.aluvery.states.ProductFormUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.math.BigDecimal

class ProductFormScreenViewModel : ViewModel() {

    private val _uiState: MutableStateFlow<ProductFormUiState> = MutableStateFlow(
        ProductFormUiState()
    )
    val uiState get() = _uiState.asStateFlow()
    private val dao = ProductDao()

    init {
        _uiState.update { currentState ->
            currentState.copy(
                onValueChangeUrl = {
                    _uiState.value = _uiState.value.copy(
                        url = it
                    )
                },
                onValueChangeName = {
                    _uiState.value = _uiState.value.copy(
                        name = it
                    )
                },
                onValueChangePrice = {
                    _uiState.value = _uiState.value.copy(
                        price = it
                    )
                },
                onValueChangeDescription = {
                    _uiState.value = _uiState.value.copy(
                        description = it
                    )
                }
            )
        }
    }

    fun save() {
        _uiState.value.run {
            val convertedPrice = try {
                BigDecimal(price)
            } catch (e: NumberFormatException) {
                BigDecimal.ZERO
            }
            val product = Product(
                name = name,
                image = url,
                price = convertedPrice,
                description = description
            )
            dao.save(product)
        }
    }
}