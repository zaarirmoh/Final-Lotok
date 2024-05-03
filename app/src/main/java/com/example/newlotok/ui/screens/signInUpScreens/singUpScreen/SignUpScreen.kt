package com.example.newlotok.ui.screens.signInUpScreens.singUpScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
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
fun SignUpScreen(
    modifier: Modifier = Modifier,
    onGoBackButtonClicked: () -> Unit = {},
    onSignUPTextClicked: () -> Unit = {},
    openServiceProviderDialog: MutableState<Boolean> = mutableStateOf(false)
){
    Scaffold(
        topBar = {
            TopBar(
                startIcon = { StartIconGoBack(onButtonClicked = onGoBackButtonClicked) }
            )
        }
    ) {
        WantToBecomeServiceProviderDialog(openDialog = openServiceProviderDialog)
        Column(
            modifier = modifier.padding(it)
        ) {
            Spacer(modifier = modifier.height(65.dp))
            SignInUPTitle(
                title = "Sign Up Now",
                description = "Please fill the details and create an account"
            )
            Spacer(modifier = modifier.height(50.dp))
            SignUpTextFields()
            Spacer(modifier = modifier.height(40.dp))
            SignInUpButton(
                text = "Sign Up",
                onSignInButtonClicked = {
                    openServiceProviderDialog.value = true
                }
            )
            Column(
                verticalArrangement = Arrangement.Bottom,
                modifier = modifier
                    .padding(bottom = 30.dp)
                    .fillMaxHeight()
            ) {
                SignInUpText(
                    text = "Sign In",
                    onTextClicked = onSignUPTextClicked
                )
                Spacer(modifier = modifier.height(40.dp))
                SignInGoogleFacebook()
            }

        }
    }
}