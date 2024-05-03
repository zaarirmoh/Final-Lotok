package com.example.newlotok.ui.screens.signInUpScreens.otpVerificationScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.newlotok.ui.components.topBar.StartIconGoBack
import com.example.newlotok.ui.components.topBar.TopBar
import com.example.newlotok.ui.screens.signInUpScreens.signInUpComponents.SignInUPTitle
import com.example.newlotok.ui.screens.signInUpScreens.signInUpComponents.SignInUpButton


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtpVerificationScreen(
    modifier: Modifier = Modifier,
    onGoBackButtonClicked: () -> Unit = {},
    onVerifyButtonClicked: () -> Unit = {}
){
    Scaffold(
        topBar = {
            TopBar(
                startIcon = { StartIconGoBack(onButtonClicked = onGoBackButtonClicked) }
            )
        }
    ) {
        Column(
            modifier = modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = modifier.height(65.dp))
            SignInUPTitle(
                title = "OTP Verification",
                description = "Please check your email www.uihut@gmail.com to see the verification code"
            )
            Spacer(modifier = modifier.height(50.dp))
            OtpCode()
            Spacer(modifier = modifier.height(40.dp))
            SignInUpButton(text = "Verify")
        }
    }
}
