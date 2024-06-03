package com.example.newlotok.ui.screens.signInUpScreens.singUpScreen

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.newlotok.ui.navigation.LotokScreen

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.signUpScreenNavigation(
    navController: NavHostController,
    scrollBehavior: TopAppBarScrollBehavior,
){
    composable(route = LotokScreen.SignUpScreen.name){
        SignUpScreen(
            onSignUPTextClicked = {
                navController.navigate(LotokScreen.SignInScreen.name)
            },
            onGoBackButtonClicked = {
                navController.navigateUp()
            },
            scrollBehavior = scrollBehavior
        )
    }
}