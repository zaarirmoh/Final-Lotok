package com.example.newlotok.ui.screens.addPostScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newlotok.model.VinResult

@Composable
fun VinDetails(
    modifier: Modifier = Modifier,
    vinResult: VinResult
) {
    val details = listOf(
        "Year" to vinResult.year.toString(),
        "Make" to vinResult.make,
        "Model" to vinResult.model,
        "Engine" to vinResult.engine,
        "Horsepower" to vinResult.horsePower.toString(),
        "Fuel" to vinResult.fuel
    )

    Column(modifier = modifier) {
        Text(
            text = "Details",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))

        details.forEach { (title, value) ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 40.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "$title : ",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = value,
                    color = Color(0x9B, 0x9B, 0x9B),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}