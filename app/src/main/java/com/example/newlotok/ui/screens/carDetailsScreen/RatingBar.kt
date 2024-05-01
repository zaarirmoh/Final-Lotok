package com.example.lotok.ui.screens.carDetailsScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RatingBar(ratings : List<Int>,modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Reviews & Ratings",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0x1D,0x1B,0x20)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth() ,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column {
                Text(
                    text = "4.3",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 44.sp,
                    color = Color(0x22, 0x22, 0x22)
                )
                Text(
                    text = "23 ratings",
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = Color(0x9B, 0x9B, 0x9B)
                )
            }

            Spacer(modifier = Modifier.width(28.dp))

            Column{
                ratings.indices.reversed().forEach { index ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        RatingStar(starCount = index + 1)
                        Spacer(modifier = Modifier.width(8.dp))
                        LinearProgressIndicator(
                            progress = ratings[ratings.size - index - 1].toFloat() / ratings.maxOrNull()!!,
                            color = Color(0xFF, 0xBA, 0x49),
                            modifier = Modifier
                                .height(8.dp)
                                .width(75.dp)
                                .align(Alignment.CenterVertically)

                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if ((ratings[ratings.size - index - 1])>9) ratings[ratings.size - index - 1].toString() else 0.toString()+ratings[ratings.size - index - 1].toString(),
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            softWrap = false

                        )


                    }
                }
            }
        }
    }
}

@Composable
fun RatingStar(starCount: Int) {
    Row(horizontalArrangement = Arrangement.End) {
        repeat(starCount) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Star Icon",
                tint = Color.Red
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRatingBar() {
    RatingBar(listOf(12, 5, 4, 2, 0))
}