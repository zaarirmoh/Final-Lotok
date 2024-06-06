package com.example.newlotok.ui.screens.homeScreen

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.newlotok.ui.TokensViewModel
import com.example.newlotok.ui.navigation.LotokScreen

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.homeScreenNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    scrollBehavior: TopAppBarScrollBehavior,
    tokensViewModel: TokensViewModel
){
    composable(route = LotokScreen.HomeScreen.name){
        val homeScreenViewModel: HomeScreenViewModel =
            viewModel(factory = HomeScreenViewModel.Factory)
        val expandedMenu = remember { mutableStateOf(false) }
        val openDialog = remember { mutableStateOf(false) }
        HomeScreenWithConnection(
            homeScreenUiState = homeScreenViewModel.homeScreenUiState,
            retryAction = homeScreenViewModel::getCarPosts,
            scrollBehavior = scrollBehavior,
            onMenuIconClicked = {
                expandedMenu.value = true
            },
            onSearchForACarButtonClicked = {
                navController.navigate(LotokScreen.SelectBrandScreen.name)
            },
            onSettingsClicked = {
                expandedMenu.value = false
                navController.navigate(LotokScreen.MainSettingsScreen.name)
            },
            openDialog = openDialog,
            expendedMenu = expandedMenu,
            onBookNowButtonClicked = {
                tokensViewModel.carPost = it
                navController.navigate(LotokScreen.CarDetailsScreen.name)
            },
            onYearSelected = {
                homeScreenViewModel.year = it
                homeScreenViewModel.getCarPosts(year = homeScreenViewModel.year) },
            onStateSelected = {
                homeScreenViewModel.state = it
                homeScreenViewModel.getCarPosts(state = homeScreenViewModel.state)
            }

        )
    }
}