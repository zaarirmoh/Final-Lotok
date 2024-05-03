package com.example.newlotok.ui.screens.signInUpScreens.singUpScreen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.newlotok.ui.navigation.LotokScreen

fun NavGraphBuilder.signUpScreenNavigation(
    navController: NavHostController
){
    composable(route = LotokScreen.SignUpScreen.name){
        SignUpScreen(
            onSignUPTextClicked = {
                navController.navigate(LotokScreen.SignInScreen.name)
            },
            onGoBackButtonClicked = {
                navController.navigateUp()
            }
        )
    }
}