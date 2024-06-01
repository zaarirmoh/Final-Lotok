package com.example.newlotok.ui.screens.signInUpScreens.signInScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.newlotok.ui.components.topBar.StartIconGoBack
import com.example.newlotok.ui.components.topBar.TopBar
import com.example.newlotok.ui.screens.signInUpScreens.signInUpComponents.SignInGoogleFacebook
import com.example.newlotok.ui.screens.signInUpScreens.signInUpComponents.SignInUPTitle
import com.example.newlotok.ui.screens.signInUpScreens.signInUpComponents.SignInUpButton
import com.example.newlotok.ui.screens.signInUpScreens.signInUpComponents.SignInUpText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    onGoBackButtonClicked: () -> Unit = {},
    onSignInTextClicked: () -> Unit = {},
    onForgotPasswordTextClicked: () -> Unit
){
    val emailAddress = remember { mutableStateOf("")}
    val password = remember { mutableStateOf("")}
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
            SignInTextFields(
                onForgotPasswordTextClicked = onForgotPasswordTextClicked,
                emailAddress = emailAddress,
                password = password
            )
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