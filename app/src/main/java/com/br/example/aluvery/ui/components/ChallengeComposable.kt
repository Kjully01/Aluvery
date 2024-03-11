package com.br.example.aluvery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun Challenge() {
    Row {
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(150.dp)
                .background(Color.Blue)
        )
        Column() {
            Row(
                Modifier
                    .background(Color.LightGray)
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Test 1"
                )
            }

            Text(
                text = "Test 2", Modifier.padding(16.dp)
            )
        }
    }
}