package com.br.example.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.br.example.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
                    MyFirstComposable()
                }
            }
        }
    }
}

@Composable
fun MyFirstComposable() {
    Text(text = "texto 1")
    Text(text = "texto 2")
}

@Preview(showBackground = true)
@Composable
fun ColumnPreview() {
    AluveryTheme {
        Surface {
            Column {
                MyFirstComposable()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RowPreview() {
    AluveryTheme {
        Surface {
            Row {
                MyFirstComposable()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BoxPreview() {
    AluveryTheme {
        Surface {
            Box {
                MyFirstComposable()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomPreview() {
    AluveryTheme {
        Surface {
            Column {
                Text(text = "texto 1")
                Text(text = "texto 2")
                Row {
                    Text(text = "texto 3")
                    Text(text = "texto 4")
                }
                Box {
                    Row {
                        Text(text = "texto 5")
                        Text(text = "texto 6")
                    }
                    Column {
                        Text(text = "texto 7")
                        Text(text = "texto 8")
                    }
                }
            }
        }
    }
}