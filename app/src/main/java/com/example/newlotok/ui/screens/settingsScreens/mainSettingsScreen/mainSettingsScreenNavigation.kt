package com.example.newlotok.ui.screens.settingsScreens.mainSettingsScreen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.newlotok.ui.navigation.LotokScreen

fun NavGraphBuilder.mainSettingsScreenNavigation(
    navController: NavHostController
){
    composable(route = LotokScreen.MainSettingsScreen.name){
        MainSettingsScreen(
            onGoBackButtonClicked = {
                navController.navigateUp()
            }
        )
    }
}