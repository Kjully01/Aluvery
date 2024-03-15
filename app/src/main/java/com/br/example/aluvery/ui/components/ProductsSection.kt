package com.br.example.aluvery.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.br.example.aluvery.R
import com.br.example.aluvery.model.Product
import java.math.BigDecimal

@Composable
fun ProductsSection(title: String) {
    Column {
        Text(
            text = title,
            Modifier.padding(start = 16.dp, end = 16.dp)
        )
        Row(
            Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .horizontalScroll(
                    rememberScrollState()
                )
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ProductItem(
                Product(
                    "Hamburguer",
                    BigDecimal(13.00),
                    R.drawable.burger
                )
            )
            ProductItem(
                Product(
                    "Pizza",
                    BigDecimal(24.99),
                    R.drawable.pizza
                )
            )
            ProductItem(
                Product(
                    "Batata Frita",
                    BigDecimal(7.50),
                    R.drawable.fries
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductsSectionPreview() {
    ProductsSection("Example")
}