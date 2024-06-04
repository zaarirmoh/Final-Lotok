package com.example.newlotok.ui.screens.signInUpScreens.signInScreen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.newlotok.ui.components.topBar.StartIconGoBack
import com.example.newlotok.ui.components.topBar.TopBar
import com.example.newlotok.ui.screens.homeScreen.LoadingScreen
import com.example.newlotok.ui.screens.signInUpScreens.signInUpComponents.SignInGoogleFacebook
import com.example.newlotok.ui.screens.signInUpScreens.signInUpComponents.SignInUPTitle
import com.example.newlotok.ui.screens.signInUpScreens.signInUpComponents.SignInUpButton
import com.example.newlotok.ui.screens.signInUpScreens.signInUpComponents.SignInUpText
import org.w3c.dom.Text

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    onGoBackButtonClicked: () -> Unit = {},
    onSignUpTextClicked: () -> Unit = {},
    onForgotPasswordTextClicked: () -> Unit,
    onSignInButtonClicked: () -> Unit,
    signInScreenViewModel: SignInScreenViewModel
){
    val emailAddress = remember { mutableStateOf("")}
    val password = remember { mutableStateOf("")}
    signInScreenViewModel.emailAddress = emailAddress.value
    signInScreenViewModel.password = password.value

    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        topBar = {
            TopBar(
                startIcon = { StartIconGoBack(onButtonClicked = onGoBackButtonClicked) }
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) {
        val context = LocalContext.current
        when(signInScreenViewModel.signInScreenUiState){
            is SignInScreenUiState.Error ->  {
                Toast.makeText(context, signInScreenViewModel.errorMessage, Toast.LENGTH_SHORT).show()
                signInScreenViewModel.clearErrorMessage()
            }
            is SignInScreenUiState.Loading -> Log.d(null, "SignInScreen: Loading")
            is SignInScreenUiState.Success  -> Log.d(null, "SignInScreen: Success")
        }
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
                password = password,
            )
            Spacer(modifier = modifier.height(40.dp))
            SignInUpButton(
                text = "Sign In",
                onSignInButtonClicked = onSignInButtonClicked
            )
            Column(
                verticalArrangement = Arrangement.Bottom,
                modifier = modifier
                    .padding(bottom = 30.dp)
                    .fillMaxHeight()
            ) {
                SignInUpText(
                    text = "Sign Up",
                    onTextClicked = onSignUpTextClicked
                )
                Spacer(modifier = modifier.height(40.dp))
                SignInGoogleFacebook()
            }

        }
    }
}