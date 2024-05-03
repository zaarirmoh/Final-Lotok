package com.example.newlotok.ui.screens.profileDetailsScreens.profileDetailsScreen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.newlotok.ui.navigation.LotokScreen

fun NavGraphBuilder.profileDetailsScreenNavigation(
    navController: NavHostController
){
    composable(route = LotokScreen.ProfileDetailsScreen.name){
        ProfileDetailsScreen(
            onGoBackButtonClicked = {
                navController.navigateUp()
            },
            onEditButtonClicked = {
                navController.navigate(LotokScreen.EditProfileScreen.name)
            }
        )
    }
}