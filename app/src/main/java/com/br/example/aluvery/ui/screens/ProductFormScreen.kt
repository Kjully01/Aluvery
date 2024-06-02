package com.br.example.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.br.example.aluvery.R
import com.br.example.aluvery.dao.ProductDao
import com.br.example.aluvery.model.Product
import com.br.example.aluvery.states.ProductFormUiState
import com.br.example.aluvery.ui.theme.AluveryTheme
import java.math.BigDecimal
import java.text.DecimalFormat

private val dao = ProductDao()

@Composable
fun ProductFormScreen(
    onSaveClick: (Product) -> Unit = {}
) {
    var name by remember {
        mutableStateOf("")
    }
    var url by remember {
        mutableStateOf("")
    }
    var price by remember {
        mutableStateOf("")
    }
    var description by remember {
        mutableStateOf("")
    }
    val formatter = remember {
        DecimalFormat("#.##")
    }
    ProductFormScreen(
        state = ProductFormUiState(
            url = url,
            name = name,
            price = price,
            description = description,
            onValueChangeUrl = {
                url = it
            },
            onValueChangeName = {
                name = it
            },
            onValueChangePrice = {
                try {
                    price = formatter.format(BigDecimal(it))
                } catch (e: IllegalArgumentException) {
                    if (it.isBlank()) {
                        price = it
                    }
                }
            },
            onValueChangeDescription = {
                description = it
            }
        ),
        onSaveClick = {
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
            onSaveClick(product)
        }
    )
}

@Composable
fun ProductFormScreen(
    state: ProductFormUiState = ProductFormUiState(),
    onSaveClick: () -> Unit = {}
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        val url = state.url
        var name = state.name
        var price = state.price
        var description = state.description

        Text(
            text = "Criando o produto",
            Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth(),
            fontSize = 28.sp
        )

        if (state.isShowImage()) {
            AsyncImage(
                model = url, contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.placeholder),
                error = painterResource(id = R.drawable.placeholder)
            )
        }

        TextField(
            value = url,
            onValueChange = state.onValueChangeUrl,
            Modifier
                .fillMaxWidth(),
            label = {
                Text(text = "Url da Imagem")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Uri,
                imeAction = ImeAction.Next
            )
        )
        TextField(
            value = name, onValueChange = state.onValueChangeName,
            Modifier
                .fillMaxWidth(),
            label = {
                Text(text = "Nome")
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Words
            )
        )
        Column {
            TextField(
                value = price,
                onValueChange = {
                    state.onValueChangePrice
                },
                Modifier.fillMaxWidth(),
//                isError = isPriceError,
                label = {
                    Text(text = "Preço")
                },
                keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Decimal,
                    imeAction = ImeAction.Next,
                ),
            )
//            if (isPriceError) {
//                Text(
//                    text = "Preço deve ser um número decimal",
//                    color = MaterialTheme.colorScheme.error,
//                    style = MaterialTheme.typography.labelSmall,
//                    modifier = Modifier.padding(start = 16.dp)
//                )
//            }
        }
        TextField(
            value = description, onValueChange = state.onValueChangeDescription,
            Modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp),
            label = {
                Text(text = "Descrição")
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences
            )
        )
        Button(onClick = onSaveClick, Modifier.fillMaxWidth()) {
            Text(text = "Salvar")
        }
        Spacer(modifier = Modifier)
    }
}

@Preview
@Composable
private fun ProductFormScreenPreview() {
    AluveryTheme {
        Surface {
            ProductFormScreen()
        }
    }
}