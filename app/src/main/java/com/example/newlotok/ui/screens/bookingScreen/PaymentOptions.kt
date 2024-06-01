package com.example.newlotok.ui.screens.bookingScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun PaymentOptions(modifier: Modifier = Modifier,paymentMethod : (String) -> Unit) {
    var selectedOption by remember { mutableStateOf("Credit Card") }
    val options = listOf("Cash on Delivery", "Credit Card")

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        options.forEach { option ->
            Row(
                modifier = Modifier
                    .padding(start = 8.dp, end = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selectedOption == option,
                    onClick = {
                        selectedOption = option
                        paymentMethod(option)
                    }
                )
                Text(
                    text = option,
                    fontSize = 16.sp,
                )
            }
        }
    }
}