package com.br.example.aluvery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.br.example.aluvery.R
import com.br.example.aluvery.extension.toBrazilianCurrency
import com.br.example.aluvery.model.Product
import com.br.example.aluvery.ui.theme.AluveryTheme
import java.math.BigDecimal

@Composable
fun CardProductItem(
    product: Product,
    modifier: Modifier = Modifier,
    elevation: Dp = 4.dp,
    isExpanded: Boolean = false
) {
    var expanded by rememberSaveable { mutableStateOf(isExpanded) }
    Card(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(150.dp)
            .clickable { expanded = !expanded },
        elevation = CardDefaults.cardElevation(elevation)
    ) {
        Column {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                placeholder = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(16.dp)
            ) {
                Text(
                    text = product.name,
                    color = Color.Black
                )
                Text(
                    text = product.price.toBrazilianCurrency(),
                    color = Color.Black
                )
            }
            val textOverflow = if (expanded) TextOverflow.Visible else TextOverflow.Ellipsis
            val maxLines = if (expanded) Int.MAX_VALUE else 2
            product.description?.takeIf { it.isNotEmpty() }?.let {
                Text(
                    text = it,
                    Modifier
                        .padding(16.dp),
                    maxLines = maxLines,
                    overflow = textOverflow
                )
            }
        }
    }
}

@Preview
@Composable
private fun CardProductItemPreview() {
    AluveryTheme {
        Surface {
            CardProductItem(
                product = Product(
                    "teste",
                    BigDecimal(9.99)
                )
            )
        }
    }
}

@Preview
@Composable
private fun CardProductItemWithDescriptionEmpty() {
    AluveryTheme {
        Surface {
            CardProductItem(
                product = Product(
                    "teste",
                    BigDecimal(9.99),
                    description = ""
                )
            )
        }
    }
}

@Preview
@Composable
private fun CardProductItemWithDescription() {
    AluveryTheme {
        Surface {
            CardProductItem(
                product = Product(
                    name = "teste",
                    price = BigDecimal(9.99),
                    description = LoremIpsum(20).values.first()
                )
            )
        }
    }
}

@Preview
@Composable
private fun CardProductItemWithDescriptionExpanded() {
    AluveryTheme {
        Surface {
            CardProductItem(
                product = Product(
                    name = "teste",
                    price = BigDecimal(9.99),
                    description = LoremIpsum(20).values.first()
                ),
                isExpanded = true
            )
        }
    }
}