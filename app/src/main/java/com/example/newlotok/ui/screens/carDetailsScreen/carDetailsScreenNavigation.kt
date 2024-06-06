package com.example.newlotok.ui.screens.carDetailsScreen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.newlotok.model.Data
import com.example.newlotok.ui.TokensViewModel
import com.example.newlotok.ui.navigation.LotokScreen

fun NavGraphBuilder.carDetailsScreenNavigation(
    navController: NavHostController,
    tokensViewModel: TokensViewModel
){
    composable(route = LotokScreen.CarDetailsScreen.name){
        CarDetailsScreen(
            carPost = tokensViewModel.carPost ?: Data.carPostsList[0],
            bookButtonClicked = { navController.navigate(LotokScreen.BookingScreen.name)},
            onGoBackIconClicked = {navController.navigateUp()},
            onProfileIconClicked = {navController.navigate(LotokScreen.ProfileScreen.name)}
        )
    }
}