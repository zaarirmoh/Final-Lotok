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
fun NameAndPrice(
    modifier : Modifier = Modifier,
    name : String,
    mark : String,
    dayPrice : Int,
    weekPrice :Int
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = name,
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text =  "$dayPrice DZA/day",
                color = Color(0xB3,0x26,0x1E),
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(7.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 6.dp, end = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = mark,
                color = Color(0x9B, 0x9B, 0x9B),
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal
            )

            Text(
                text =  "$weekPrice DZA/week",
                color = Color(0xB3,0x26,0x1E),
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}


@Composable
@Preview(showBackground = true)
fun NameAndPricePreview(){
    NameAndPrice(
        name = Data.carPostsList[0].model,
        mark = Data.carPostsList[0].make,
        dayPrice = Data.carPostsList[0].dayPrice.toInt(),
        weekPrice = Data.carPostsList[0].weekPrice.toInt()
    )
}