package com.example.newlotok.ui.screens.signInUpScreens.singUpScreen

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.lifecycle.viewmodel.compose.viewModel
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
        val signUpScreenViewModel: SignUpScreenViewModel =
            viewModel(factory = SignUpScreenViewModel.Factory)
        SignUpScreen(
            onSignInTextClicked = {
                navController.navigate(LotokScreen.SignInScreen.name)
            },
            onGoBackButtonClicked = {
                navController.navigateUp()
            },
            scrollBehavior = scrollBehavior,
            signUpScreenViewModel = signUpScreenViewModel,
            onSignUpButtonClicked = {
                signUpScreenViewModel.postSignUpInformation()
            },
            onConfirmButtonClicked = {
                navController.navigate(LotokScreen.SignInScreen.name)
            },
            onDismissButtonClicked = {
                navController.navigate(LotokScreen.SignInScreen.name)
            }
        )
    }
}