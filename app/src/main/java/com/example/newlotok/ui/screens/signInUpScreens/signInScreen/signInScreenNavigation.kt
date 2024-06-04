package com.example.newlotok.ui.screens.signInUpScreens.signInScreen

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.newlotok.model.AccessToken
import com.example.newlotok.ui.TokensViewModel
import com.example.newlotok.ui.navigation.LotokScreen
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

fun NavGraphBuilder.signInScreenNavigation(
    navController: NavHostController,
    tokensViewModel: TokensViewModel
){
    composable(route = LotokScreen.SignInScreen.name){
        val signInScreenViewModel: SignInScreenViewModel =
            viewModel(factory = SignInScreenViewModel.Factory)
        val context = LocalContext.current
        val coroutineScope = rememberCoroutineScope()
        SignInScreen(
            onSignUpTextClicked = {
                navController.navigate(LotokScreen.SignUpScreen.name)
            },
            onForgotPasswordTextClicked = {
                navController.navigate(LotokScreen.ForgotPasswordScreen.name)
            },
            onGoBackButtonClicked = {
                navController.navigateUp()
            },
            onSignInButtonClicked = {
                signInScreenViewModel.postSignInInformation()
            },
            signInScreenViewModel = signInScreenViewModel
        )
        if(signInScreenViewModel.shouldNavigateToHomeScreen){
            LaunchedEffect(Unit) {
                coroutineScope.launch {
                    Log.d("entered", "entered")
                    signInScreenViewModel.setAccessToken(context = context)
                    signInScreenViewModel.setRefreshToken(context = context)
                    navController.navigate(LotokScreen.HomeScreen.name)
                    tokensViewModel.verifyAccessToken(AccessToken(signInScreenViewModel.accessToken))
                }
            }

        }
    }
}