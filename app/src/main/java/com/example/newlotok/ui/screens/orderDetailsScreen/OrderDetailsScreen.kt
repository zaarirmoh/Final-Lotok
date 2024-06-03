package com.example.newlotok.ui.screens.orderDetailsScreen

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newlotok.model.OrderDetails

@Composable
fun OrderDetailsScreen(
    uiState : OrderDetails,
    modifier: Modifier = Modifier,
    context: Context,
    onDoneButtonClicked: () -> Unit = {},
) {
    Column(modifier = modifier.fillMaxSize()) {
        CardDetails(
            title = "Car Details",
            texts = listOf(
                { Text(text = "Make:") },
                { Text(text = uiState.carPost.make )},
                { Text(text = "Model:") },
                { Text(text = uiState.carPost.model) },
                { Text(text = "Car Number:") },
                { Text(text = uiState.carPost.dayPrice.toString())},
                { Text(text = "Location:") },
                { Text(text = uiState.carPost.location.toString()) }
            )

        )

        Spacer(modifier = Modifier.height(20.dp))

        CardDetails(
            title = "Client Details",
            texts = listOf(
                { Text("First Name:") },
                { Text(uiState.firstName) },
                { Text("Last Name:") },
                { Text(uiState.lastName) },
                { Text("Phone Number:") },
                { Text(uiState.phoneNumber) },
                { Text("Licence Number:") },
                { Text(uiState.licenceNumber) },
                { Text("Expiration Date:") },
                { Text(uiState.expirationDate) },
                { Text("Rented ") },
                { Text("From : ${uiState.fromDate}") },
                { Text("") },
                { Text("To :     ${uiState.toDate}") }
            )
        )
        Spacer(modifier = Modifier.height(20.dp))

        CardDetails(
            title = "Payment :",
            texts = listOf(
                { Text("Total Price :") },
                { Text(uiState.totalPrice.toString()) },
                { Text("Payment method :") },
                { Text(uiState.paymentMethod) }
            )
        )

        Spacer(modifier = Modifier.height(60.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.End)
                .padding(end= 20.dp, start = 20.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Button(
                onClick = {
                    shareOrderDetails(context, uiState)
                },
                colors = ButtonDefaults.buttonColors(Color(android.graphics.Color.parseColor("#B3261E"))),
            ) {
                Text(
                    text = "Share",
                    fontSize = 15.sp ,
                    color = androidx.compose.ui.graphics.Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier= Modifier
                        .padding(end = 8.dp)
                        .fillMaxWidth(0.25f)
                        .align(alignment = Alignment.CenterVertically),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
            }

            Button(
                onClick = onDoneButtonClicked
                ,
                colors = ButtonDefaults.buttonColors(Color(android.graphics.Color.parseColor("#B3261E"))),
            ) {
                Text(
                    text = "Done",
                    fontSize = 15.sp ,
                    color = androidx.compose.ui.graphics.Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier= Modifier
                        .fillMaxWidth(0.5f)
                        .padding(start = 8.dp)
                        .align(alignment = Alignment.CenterVertically),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
            }
        }


    }


}

@Composable
fun CardDetails(modifier: Modifier = Modifier, title : String, texts : List<@Composable () -> Unit> ){
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp),
        shape = RoundedCornerShape(16.dp),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Spacer(modifier = Modifier.height(8.dp))
            for (i in texts.indices step 2) {
                val firstItem = texts[i]
                val secondItem = texts[i + 1]

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    firstItem()
                    secondItem()
                }
                Spacer(modifier = Modifier.height(4.dp))
            }

        }
    }
}


