package com.br.example.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.br.example.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
                    CustomPreview()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomPreview() {
    AluveryTheme {
        Surface {
            Column(
                Modifier
                    .padding(8.dp)
                    .background(Color.Blue)
                    .padding(8.dp)
                    .fillMaxSize()
            ) {
                Text(text = "texto 1")
                Text(text = "texto 2")
                Row(
                    Modifier
                        .fillMaxWidth(0.9f)
                        .padding(horizontal = 8.dp, vertical = 16.dp)
                        .background(Color.Green)
                ) {
                    Text(text = "texto 3")
                    Text(text = "texto 4")
                }
                Box(
                    Modifier
                        .background(Color.Red)
                        .padding(16.dp)
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .background(Color.Cyan)
                    ) {
                        Text(text = "texto 5")
                        Text(text = "texto 6")
                    }
                    Column(
                        Modifier
                            .background(Color.Yellow)
                    ) {
                        Text(text = "texto 7")
                        Text(text = "texto 8")
                    }
                }
            }
        }
    }
}