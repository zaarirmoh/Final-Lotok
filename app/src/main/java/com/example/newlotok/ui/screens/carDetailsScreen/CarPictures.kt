package com.example.newlotok.ui.screens.carDetailsScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newlotok.model.Data

@Composable
fun CarPictures(
    modifier : Modifier = Modifier,
    imgSrc : List<Int> = listOf(),
    onButtonClicked : () -> Unit = {}

){
    var currentPosition by remember { mutableIntStateOf(0) }
    val maxPosition = imgSrc.size

    Box(modifier = modifier
        .fillMaxWidth()
        .height(224.dp)) {
        Image(
            painter = painterResource(id = imgSrc[currentPosition]),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 20.dp)
                .background(Color.Gray)
        )
        Button(
            onClick = onButtonClicked,
            colors = ButtonDefaults.buttonColors(Color(android.graphics.Color.parseColor("#B3261E"))),
            modifier = Modifier
                .height(36.dp)
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp)
                .align(alignment = Alignment.BottomCenter)
        ) {
            Text(
                text = "Book",
                fontSize = 18.sp ,
                color = Color.White   ,
                fontWeight = FontWeight.Bold,
                modifier= Modifier.align(alignment = Alignment.CenterVertically)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 5.dp, end = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            IconButton(
                onClick = { if (currentPosition > 0) currentPosition-- },
                enabled = currentPosition > 0 ,
                modifier = Modifier
                    .size(40.dp)


            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "Previous",
                    modifier = Modifier.fillMaxSize(),
                    tint = if (currentPosition > 0) Color.White else Color.Gray
                )
            }

            IconButton(
                onClick = { if (currentPosition < maxPosition) currentPosition++ },
                enabled = currentPosition < maxPosition-1 ,
                modifier = Modifier
                    .size(40.dp)

            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Next",
                    modifier = Modifier.fillMaxSize(),
                    tint = if (currentPosition < maxPosition - 1)Color.White else Color.Gray
                )
            }
        }
    }
}


