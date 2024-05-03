package com.example.newlotok.ui.screens.welcomeScreen

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.newlotok.ui.navigation.LotokScreen

fun NavGraphBuilder.welcomeScreenNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    onWelcomeScreenButtonClicked: () -> Unit,
){
    composable(route = LotokScreen.WelcomeScreen.name){
        WelcomeScreen(
            onButtonClicked = {
                onWelcomeScreenButtonClicked()
                navController.navigate(LotokScreen.HomeScreen.name) {
                    // Empty the back stack
                    popUpTo(navController.graph.startDestinationId) {
                        inclusive = true
                    }
                }
            }
        )
    }
}