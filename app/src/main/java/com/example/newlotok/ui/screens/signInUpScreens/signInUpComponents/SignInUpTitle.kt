package com.example.lotok.ui.screens.signInUpScreens.signInUpComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SignInUPTitle(
    modifier: Modifier = Modifier,
    title: String,
    description: String
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp,end = 20.dp)
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = modifier.height(12.dp))
        Text(
            text = description,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF7D848D),
            textAlign = TextAlign.Center
        )
    }
}