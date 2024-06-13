package com.br.example.aluvery.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.br.example.aluvery.samples.sampleCandies
import com.br.example.aluvery.samples.sampleDrinks
import com.br.example.aluvery.states.ProductFormUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductFormScreenViewModel : ViewModel() {

    private val _uiState: MutableStateFlow<ProductFormUiState> = MutableStateFlow(
        ProductFormUiState()
    )
    val uiState get() = _uiState.asStateFlow()

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
}