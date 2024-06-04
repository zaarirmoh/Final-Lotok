package com.example.newlotok.ui.screens.profileScreen

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.newlotok.ui.TokensViewModel
import com.example.newlotok.ui.navigation.LotokScreen
import com.example.newlotok.ui.screens.homeScreen.HomeScreenViewModel
import kotlinx.coroutines.coroutineScope

fun NavGraphBuilder.profileScreenNavigation(
    navController: NavHostController,
    tokensViewModel: TokensViewModel
){
    composable(route = LotokScreen.ProfileScreen.name){
        val profileScreenViewModel: ProfileScreenViewModel =
            viewModel(factory = ProfileScreenViewModel.Factory)
        val context = LocalContext.current
        var authorization = "bearer "
        LaunchedEffect(Unit) {
            coroutineScope {
                authorization += tokensViewModel.getAccessToken(context)
                profileScreenViewModel.getProfileInformation(authorization)
            }
        }
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
            profileScreenUiState = profileScreenViewModel.profileScreenUiState,
            retryAction = {}
        )
    }
}