package com.example.lotok.ui.screens.signInUpScreens.signInScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.newlotok.ui.components.topBar.StartIconGoBack
import com.example.newlotok.ui.components.topBar.TopBar
import com.example.newlotok.ui.screens.signInUpScreens.signInUpComponents.SignInGoogleFacebook
import com.example.lotok.ui.screens.signInUpScreens.signInUpComponents.SignInUPTitle
import com.example.lotok.ui.screens.signInUpScreens.signInUpComponents.SignInUpButton
import com.example.lotok.ui.screens.signInUpScreens.signInUpComponents.SignInUpText

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    onGoBackButtonClicked: () -> Unit = {},
    onSignInTextClicked: () -> Unit = {},
    onForgotPasswordTextClicked: () -> Unit
){
    Scaffold(
        topBar = {
            TopBar(
                startIcon = { StartIconGoBack(onButtonClicked = onGoBackButtonClicked) }
            )
        }
    ) {
        Column(
            modifier = modifier.padding(it)
        ) {
            Spacer(modifier = modifier.height(65.dp))
            SignInUPTitle(
                title = "Sign In Now",
                description = "Please sign in to continue to our app"
            )
            Spacer(modifier = modifier.height(50.dp))
            SignInTextFields(onForgotPasswordTextClicked = onForgotPasswordTextClicked)
            Spacer(modifier = modifier.height(40.dp))
            SignInUpButton(text = "Sign In")
            Column(
                verticalArrangement = Arrangement.Bottom,
                modifier = modifier
                    .padding(bottom = 30.dp)
                    .fillMaxHeight()
            ) {
                SignInUpText(
                    text = "Sign Up",
                    onTextClicked = onSignInTextClicked
                )
                Spacer(modifier = modifier.height(40.dp))
                SignInGoogleFacebook()
            }
        }
    }
}