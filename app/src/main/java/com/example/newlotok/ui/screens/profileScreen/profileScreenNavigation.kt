package com.example.newlotok.ui.screens.profileScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.newlotok.ui.GetCarPostsUiState
import com.example.newlotok.ui.TokensViewModel
import com.example.newlotok.ui.navigation.LotokScreen
import com.example.newlotok.ui.screens.homeScreen.ErrorScreen
import com.example.newlotok.ui.screens.homeScreen.HomeScreen
import com.example.newlotok.ui.screens.homeScreen.HomeScreenUiState
import com.example.newlotok.ui.screens.homeScreen.HomeScreenViewModel
import com.example.newlotok.ui.screens.homeScreen.LoadingScreen
import com.example.newlotok.ui.screens.homeScreen.PopularCars
import kotlinx.coroutines.coroutineScope

fun NavGraphBuilder.profileScreenNavigation(
    navController: NavHostController,
    tokensViewModel: TokensViewModel
){

    composable(route = LotokScreen.ProfileScreen.name){
        val profileScreenViewModel: ProfileScreenViewModel =
            viewModel(factory = ProfileScreenViewModel.Factory)
        val context = LocalContext.current
        var authorization = "Bearer "
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
            onCarsPostedCardClicked = {
                navController.navigate(LotokScreen.UserPostsScreen.name)
            },
            onSettingsCardClicked = {
                navController.navigate(LotokScreen.MainSettingsScreen.name)
            },
            onVersionCardClicked = {},
            profileScreenUiState = profileScreenViewModel.profileScreenUiState,
            onSignInButtonClicked = {
                navController.navigate(LotokScreen.SignInScreen.name)
            },
            profileScreenViewModel = profileScreenViewModel
        )
    }

}