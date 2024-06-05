package com.example.newlotok.ui.screens.filterCars

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.newlotok.ui.GetCarPostsUiState
import com.example.newlotok.ui.TokensViewModel
import com.example.newlotok.ui.components.topBar.StartIconGoBack
import com.example.newlotok.ui.components.topBar.TopBar
import com.example.newlotok.ui.navigation.LotokScreen
import com.example.newlotok.ui.screens.homeScreen.ErrorScreen
import com.example.newlotok.ui.screens.homeScreen.LoadingScreen
import com.example.newlotok.ui.screens.homeScreen.PopularCars

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilteredCars(
    tokensViewModel: TokensViewModel,
    navController: NavHostController,
    getCarPostsUiState: GetCarPostsUiState,
    retryAction: () -> Unit
){
    when(val getCarPostsUiState = tokensViewModel.getCarPostsUiState){
        is GetCarPostsUiState.Success -> {
            Scaffold(
                topBar = {
                    TopBar(
                        startIcon = { StartIconGoBack(onButtonClicked = {}) }
                    )
                },
            ){
                Column(
                    modifier = Modifier
                        .padding(it)
                        //.padding(bottom = navigationBarHeight.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Spacer(modifier = Modifier.height(11.dp))
                    PopularCars(
                        onBookNowButtonClicked = {
                            tokensViewModel.carPost = it
                            navController.navigate(LotokScreen.CarDetailsScreen.name)
                        },
                        popularCarsText = "This user's posts :",
                        carPosts = getCarPostsUiState.carPosts,
                    )
                }

            }
        }
        is GetCarPostsUiState.Error -> ErrorScreen(
            retryAction = retryAction, //
        )
        is GetCarPostsUiState.Loading -> LoadingScreen()
    }
}