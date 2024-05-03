package com.example.newlotok.ui.screens.selectBrandScreen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.newlotok.model.Data
import com.example.newlotok.ui.navigation.LotokScreen

fun NavGraphBuilder.selectBrandScreenNavigation(
    navController: NavHostController
){
    composable(route = LotokScreen.SelectBrandScreen.name){
        SelectBrandScreen(
            carBrandsList = Data.carBrandsList,
            onGoBackIconClicked = {
                navController.navigateUp()
            },
            onLogoClicked ={ navController.navigate(LotokScreen.CarDetailsScreen.name)}
        )
    }
}