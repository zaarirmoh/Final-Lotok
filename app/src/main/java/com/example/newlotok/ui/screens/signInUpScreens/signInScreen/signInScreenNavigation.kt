package com.example.newlotok.ui.screens.signInUpScreens.signInScreen

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.newlotok.ui.navigation.LotokScreen

fun NavGraphBuilder.signInScreenNavigation(
    navController: NavHostController
){
    composable(route = LotokScreen.SignInScreen.name){
        val signInScreenViewModel: SignInScreenViewModel =
            viewModel(factory = SignInScreenViewModel.Factory)
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
    }
}