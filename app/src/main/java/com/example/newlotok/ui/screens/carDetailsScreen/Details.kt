package com.example.newlotok.ui.screens.carDetailsScreen

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newlotok.model.Data

@Composable
fun Details(
    modifier: Modifier = Modifier,
    energyType : String,
    seats : String,
    engine : String,
    type : String,
    location : String

) {
    val details = listOf(
        "Energy Type" to energyType,
        "Seats" to seats,
        "Engine" to engine,
        "Type" to type,
        "Location" to location
    )

    Column(modifier = modifier) {
        Text(
            text = "Details",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))

        details.forEach { (title, value) ->
            Row( modifier = Modifier
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

@Composable
@Preview(showBackground = true)
fun DetailsPreview(){
    Details(
        energyType = Data.carPostsList[0].fuel,
        seats = Data.carPostsList[0].power.toString(),
        engine = Data.carPostsList[0].engine,
        type = Data.carPostsList[0].transmission,
        location = Data.carPostsList[0].location.toString()
    )
}