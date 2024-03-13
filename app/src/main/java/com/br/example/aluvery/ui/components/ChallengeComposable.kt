package com.br.example.aluvery.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.style.TextOverflow.Companion.Ellipsis
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.br.example.aluvery.R
import com.br.example.aluvery.ui.theme.BlueChallenge
import com.br.example.aluvery.ui.theme.Purple500
import com.br.example.aluvery.ui.theme.PurpleChallenge
import com.br.example.aluvery.ui.theme.Teal200

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
            Text(
                text = "Test 1",
                Modifier
                    .background(Color.LightGray)
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Text(
                text = "Test 2", Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductItemChallenge() {
    Surface(
        Modifier.padding(8.dp),
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .heightIn(200.dp)
        ) {
            val imageSize = 100.dp
            Box(
                modifier = Modifier
                    .height(300.dp)
                    .width(imageSize)
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                BlueChallenge,
                                PurpleChallenge
                            )
                        )
                    )

            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    Modifier
                        .offset(x = imageSize / 2)
                        .border(
                            BorderStroke(
                                3.dp,
                                brush = Brush.verticalGradient(
                                    listOf(
                                        PurpleChallenge,
                                        BlueChallenge
                                    )
                                )
                            ), CircleShape
                        )
                        .clip(CircleShape)
                        .align(Alignment.CenterEnd)
                        .size(imageSize)


                )
            }
            Spacer(modifier = Modifier.width(imageSize / 2))
            Text(
                text = LoremIpsum(50).values.first(),
                Modifier
                    .align(CenterVertically)
                    .padding(32.dp),
                maxLines = 6,
                overflow = Ellipsis,
                fontSize = 16.sp,
                lineHeight = 1.5.em
            )
        }
    }
}

@Composable
fun ProductsSectionChallenge() {
    Column {
        Text(
            text = "Promoções",
            Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)
        )
        Row(
            Modifier
                .padding(top = 8.dp, bottom = 16.dp)
                .fillMaxWidth()
                .horizontalScroll(
                    rememberScrollState()
                )
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ProductItemChallenge(LoremIpsum(100).values.first())
            ProductItemChallenge()
            ProductItemChallenge(LoremIpsum(15).values.first())
        }
    }
}

@Composable
fun ProductItemChallenge(description: String = "") {
    Surface(
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp
    ) {
        Column(
            Modifier
                .width(200.dp)
                .heightIn(250.dp, 260.dp)
                .verticalScroll(rememberScrollState())
        ) {
            val imageSize = 100.dp
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageSize)
                    .background(brush = Brush.horizontalGradient(listOf(Purple500, Teal200)))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    Modifier
                        .size(imageSize)
                        .offset(y = imageSize / 2)
                        .clip(shape = CircleShape)
                        .align(Alignment.BottomCenter)
                )
            }
            Spacer(modifier = Modifier.height(imageSize / 2))
            Column(Modifier.padding(16.dp)) {
                Text(
                    text = LoremIpsum(50).values.first(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = Ellipsis
                )
                Text(
                    text = "R$ 14,99",
                    Modifier.padding(top = 8.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
            }
            if (description.isNotEmpty()) {
                Text(
                    text = description,
                    color = Color.White,
                    modifier = Modifier
                        .background(Purple500)
                        .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductsSectionChallengePreview() {
    ProductsSectionChallenge()
}

@Preview(showBackground = true)
@Composable
private fun ProductItemChallengePreview() {
    ProductItemChallenge(LoremIpsum(100).values.first())
}

