package com.example.newlotok.ui.screens.selectACarScreen

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.newlotok.ui.navigation.LotokScreen

fun NavGraphBuilder.selectACarScreenNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
){
    composable(route = LotokScreen.SelectACarScreen.name){
        SelectACarScreen(
            onProfileIconClicked = {
            },
            onGoBackIconClicked = {
                navController.navigateUp()
            },
            onHomeIconClicked = {
                navController.navigateUp()
            }
        )
    }
}