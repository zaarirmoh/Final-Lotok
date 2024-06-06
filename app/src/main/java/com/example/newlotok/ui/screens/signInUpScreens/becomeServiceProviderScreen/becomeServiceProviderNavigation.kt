package com.example.newlotok.ui.screens.signInUpScreens.becomeServiceProviderScreen

import android.util.Log
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.newlotok.model.AccessToken
import com.example.newlotok.ui.TokensViewModel
import com.example.newlotok.ui.navigation.LotokScreen
import com.example.newlotok.ui.screens.homeScreen.HomeScreenViewModel
import com.example.newlotok.ui.screens.signInUpScreens.signInScreen.SignInScreenViewModel
import kotlinx.coroutines.launch

fun NavGraphBuilder.becomeServiceProviderNavigation(
    tokensViewModel: TokensViewModel,
    //signInScreenViewModel: SignInScreenViewModel,
    navController: NavHostController,
){
    composable(route = LotokScreen.BecomeServiceProviderScreen.name) {
        val becomeServiceProviderViewModel: BecomeServiceProviderViewModel =
            viewModel(factory = BecomeServiceProviderViewModel.Factory)
        val coroutineScope = rememberCoroutineScope()
        val context = LocalContext.current
        BecomeServiceProviderScreen(
            onGoBackButtonClicked = { /*TODO*/ },
            becomeServiceProviderViewModel = becomeServiceProviderViewModel,
            onBecomeServiceProviderButtonClicked = {}
        )
        /*
        if(signInScreenViewModel.shouldNavigateToHomeScreen){
            LaunchedEffect(Unit) {
                coroutineScope.launch {
                    signInScreenViewModel.postSignInInformation()
                    Log.d("entered", "entered")
                    signInScreenViewModel.setAccessToken(context = context)
                    signInScreenViewModel.setRefreshToken(context = context)
                    navController.navigate(LotokScreen.HomeScreen.name)
                    tokensViewModel.verifyAccessToken(AccessToken(signInScreenViewModel.accessToken))
                }
            }
        }
         */

    }

}