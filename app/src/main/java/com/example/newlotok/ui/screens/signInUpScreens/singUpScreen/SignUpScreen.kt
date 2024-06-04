package com.example.newlotok.ui.screens.signInUpScreens.singUpScreen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
    onSignInTextClicked: () -> Unit = {},
    onSignUpButtonClicked: () -> Unit = {},
    onDismissButtonClicked: () -> Unit = {},
    onConfirmButtonClicked: () -> Unit = {},
    scrollBehavior: TopAppBarScrollBehavior,
    signUpScreenViewModel: SignUpScreenViewModel,
){

    val firstName = remember { mutableStateOf("")}
    val lastName = remember { mutableStateOf("")}
    val emailAddress = remember { mutableStateOf("")}
    val password = remember { mutableStateOf("")}
    val confirmPassword = remember { mutableStateOf("")}

    signUpScreenViewModel.firstName = firstName.value
    signUpScreenViewModel.lastName = lastName.value
    signUpScreenViewModel.emailAddress = emailAddress.value
    signUpScreenViewModel.password = password.value
    signUpScreenViewModel.confirmPassword = confirmPassword.value

    Scaffold(
        topBar = {
            TopBar(
                startIcon = { StartIconGoBack(onButtonClicked = onGoBackButtonClicked) },
                scrollBehavior = scrollBehavior
            )
        }
    ) {
        val context = LocalContext.current
        when(signUpScreenViewModel.signUpScreenUiState){
            is SignUpScreenUiState.Error -> {
                Toast.makeText(context, signUpScreenViewModel.errorMessage, Toast.LENGTH_SHORT).show()
                signUpScreenViewModel.resetErrorMessage()
            }
            is SignUpScreenUiState.Loading -> Log.d(null, "Loading")
            is SignUpScreenUiState.Success -> Log.d(null, "Success")
        }
        Column(
            modifier = modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = modifier.height(65.dp))
            SignInUPTitle(
                title = "Sign Up Now",
                description = "Please fill the details and create an account"
            )
            Spacer(modifier = modifier.height(50.dp))
            SignUpTextFields(
                firstName = firstName,
                lastName = lastName,
                emailAddress = emailAddress,
                password = password,
                confirmPassword = confirmPassword
            )
            Spacer(modifier = modifier.height(40.dp))
            SignInUpButton(
                text = "Sign Up",
                onSignInButtonClicked = {
                    onSignUpButtonClicked()
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
                    onTextClicked = onSignInTextClicked
                )
                Spacer(modifier = modifier.height(40.dp))
                SignInGoogleFacebook()
            }
            WantToBecomeServiceProviderDialog(
                signUpScreenViewModel = signUpScreenViewModel,
                onDismissButtonClicked = onDismissButtonClicked,
                onConfirmButtonClicked = onConfirmButtonClicked
            )
        }
    }
}