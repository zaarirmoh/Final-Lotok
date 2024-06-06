package com.example.newlotok.ui.screens.filterCars

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.newlotok.ui.TokensViewModel
import com.example.newlotok.ui.navigation.LotokScreen
import com.example.newlotok.ui.screens.filterCars.FilteredCars

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.userCarPostsScreenNavigation(
    navController: NavHostController,
    tokensViewModel: TokensViewModel,
){
    composable(route = LotokScreen.UserPostsScreen.name) {
        val context = LocalContext.current
        var id: Int? = 0
        LaunchedEffect(Unit) {
            id = tokensViewModel.getID(context)
            if(!tokensViewModel.shouldSendUser) id = null
            tokensViewModel.getCarPosts(user = id,make = tokensViewModel.make)
        }
        FilteredCars(
            tokensViewModel = tokensViewModel,
            navController = navController,
            getCarPostsUiState = tokensViewModel.getCarPostsUiState,
            retryAction = { tokensViewModel.getCarPosts(user = id, make = tokensViewModel.make) },
            onGoBackIconClicked = {navController.navigateUp()},
            onProfileIconClicked = {navController.navigate(LotokScreen.ProfileScreen.name)}
        )
    }
}