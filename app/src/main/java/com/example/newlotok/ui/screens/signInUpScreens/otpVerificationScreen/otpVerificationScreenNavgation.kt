package com.example.newlotok.ui.screens.signInUpScreens.otpVerificationScreen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.newlotok.ui.navigation.LotokScreen

fun NavGraphBuilder.otpVerificationScreenNavigation(
    navController: NavHostController
){
    composable(route = LotokScreen.OtpVerificationScreen.name){
        OtpVerificationScreen(
            onGoBackButtonClicked = {navController.navigateUp()}
        )
    }
}