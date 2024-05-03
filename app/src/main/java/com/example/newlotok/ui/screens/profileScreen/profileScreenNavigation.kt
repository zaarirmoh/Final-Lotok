package com.example.newlotok.ui.screens.profileScreen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.newlotok.ui.navigation.LotokScreen

fun NavGraphBuilder.profileScreenNavigation(
    navController: NavHostController
){
    composable(route = LotokScreen.ProfileScreen.name){
        ProfileScreen(
            onEditIconClicked = {},
            onProfileCardClicked = {
                navController.navigate(LotokScreen.ProfileDetailsScreen.name)
            },
            onCarsPostedCardClicked = {},
            onSettingsCardClicked = {
                navController.navigate(LotokScreen.MainSettingsScreen.name)
            },
            onVersionCardClicked = {},
        )
    }
}