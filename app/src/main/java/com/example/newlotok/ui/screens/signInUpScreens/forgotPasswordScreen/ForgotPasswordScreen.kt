package com.example.newlotok.ui.screens.signInUpScreens.forgotPasswordScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.example.newlotok.ui.screens.signInUpScreens.signInScreen.EmailTextField
import com.example.newlotok.ui.screens.signInUpScreens.signInUpComponents.SignInUPTitle
import com.example.newlotok.ui.screens.signInUpScreens.signInUpComponents.SignInUpButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordScreen(
    modifier: Modifier = Modifier,
    onGoBackButtonClicked: () -> Unit = {},
    isCheckEmailDialogOpen: MutableState<Boolean> = mutableStateOf(false),
    onForgotPasswordButtonClicked: () -> Unit = {}
){
    Scaffold(
        topBar = {
            TopBar(
                startIcon = { StartIconGoBack(onButtonClicked = onGoBackButtonClicked) }
            )
        }
    ) {
        ForgotPasswordAlertDialog(
            openDialog = isCheckEmailDialogOpen,
            onForgotPasswordButtonClicked = onForgotPasswordButtonClicked
        )
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
                .padding(it)
        ) {
            Spacer(modifier = modifier.height(65.dp))
            SignInUPTitle(
                title = "Forgot password",
                description = "enter your email account to reset your password"
            )
            Spacer(modifier = modifier.height(50.dp))
            EmailTextField()
            Spacer(modifier = modifier.height(40.dp))
            SignInUpButton(
                text = "Reset password",
                onSignInButtonClicked = {
                    isCheckEmailDialogOpen.value = true
                }
            )
        }
    }
}