package com.example.lotok.ui.screens.signInUpScreens.otpVerificationScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OtpCode(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        OtpText()
        Spacer(modifier = modifier.height(16.dp))
        FunctionalOtpTextField()
    }
}
@Composable
fun OtpText(
    modifier: Modifier = Modifier
){
    Text(
        text = "OTP Code",
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier.padding(start = 20.dp)
    )
}