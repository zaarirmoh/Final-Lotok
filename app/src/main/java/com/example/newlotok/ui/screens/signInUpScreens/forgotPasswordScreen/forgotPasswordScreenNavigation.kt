package com.example.newlotok.ui.screens.signInUpScreens.forgotPasswordScreen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.newlotok.ui.navigation.LotokScreen

fun NavGraphBuilder.forgotPasswordScreenNavigation(
    navController: NavHostController
){
    composable(route = LotokScreen.ForgotPasswordScreen.name){
        ForgotPasswordScreen(
            onGoBackButtonClicked = {
                navController.navigateUp()
            },
            onForgotPasswordButtonClicked = {
                navController.navigate(LotokScreen.OtpVerificationScreen.name)
            }
        )
    }
}