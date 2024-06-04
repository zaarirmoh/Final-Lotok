package com.example.newlotok.ui.navigation

import android.content.Context
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.example.newlotok.model.CarPostFirst
import com.example.newlotok.model.OrderDetails
import com.example.newlotok.ui.TokensViewModel
import com.example.newlotok.ui.screens.addPostScreen.AddPostScreenViewModel
import com.example.newlotok.ui.screens.addPostScreen.addPostScreenNavigation
import com.example.newlotok.ui.screens.bookingScreen.BookingSharedViewModel
import com.example.newlotok.ui.screens.bookingScreen.bookingScreenNavigation
import com.example.newlotok.ui.screens.carDetailsScreen.carDetailsScreenNavigation
import com.example.newlotok.ui.screens.homeScreen.homeScreenNavigation
import com.example.newlotok.ui.screens.orderDetailsScreen.orderDetailsScreenNavigation
import com.example.newlotok.ui.screens.profileDetailsScreens.editProfileScreen.editProfileScreenNavigation
import com.example.newlotok.ui.screens.profileDetailsScreens.profileDetailsScreen.profileDetailsScreenNavigation
import com.example.newlotok.ui.screens.profileScreen.profileScreenNavigation
import com.example.newlotok.ui.screens.selectACarScreen.selectACarScreenNavigation
import com.example.newlotok.ui.screens.selectBrandScreen.selectBrandScreenNavigation
import com.example.newlotok.ui.screens.settingsScreens.mainSettingsScreen.mainSettingsScreenNavigation
import com.example.newlotok.ui.screens.signInUpScreens.forgotPasswordScreen.forgotPasswordScreenNavigation
import com.example.newlotok.ui.screens.signInUpScreens.otpVerificationScreen.otpVerificationScreenNavigation
import com.example.newlotok.ui.screens.signInUpScreens.signInScreen.signInScreenNavigation
import com.example.newlotok.ui.screens.signInUpScreens.singUpScreen.signUpScreenNavigation
import com.example.newlotok.ui.screens.welcomeScreen.welcomeScreenNavigation

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.navigationSystem(
    navController: NavHostController,
    onWelcomeScreenButtonClicked: () -> Unit = {},
    scrollBehavior: TopAppBarScrollBehavior,
    context: Context,
    bookingSharedViewModel: BookingSharedViewModel,
    uiState: OrderDetails,
    addPostScreenViewModel: AddPostScreenViewModel,
    tokensViewModel: TokensViewModel
){
    welcomeScreenNavigation(
        navController = navController,
        onWelcomeScreenButtonClicked = onWelcomeScreenButtonClicked,
    )
    homeScreenNavigation(
        navController = navController,
        scrollBehavior = scrollBehavior,
        tokensViewModel = tokensViewModel,
    )
    selectACarScreenNavigation(navController = navController)
    selectBrandScreenNavigation(navController = navController)
    profileScreenNavigation(
        navController = navController,
        tokensViewModel = tokensViewModel,
    )
    mainSettingsScreenNavigation(navController = navController)
    profileDetailsScreenNavigation(navController = navController)
    editProfileScreenNavigation(navController = navController)
    signInScreenNavigation(
        navController = navController,
        tokensViewModel = tokensViewModel,
    )
    signUpScreenNavigation(
        navController = navController,
        scrollBehavior = scrollBehavior,
    )
    forgotPasswordScreenNavigation(navController = navController)
    otpVerificationScreenNavigation(navController = navController)
    carDetailsScreenNavigation(
        navController = navController,
        tokensViewModel = tokensViewModel,
    )
    bookingScreenNavigation(
        navController = navController,
        bookingSharedViewModel = bookingSharedViewModel,
    )
    orderDetailsScreenNavigation(
        navController = navController,
        uiState = uiState,
        context = context,
    )
    addPostScreenNavigation(
        navController = navController,
        addPostScreenViewModel = addPostScreenViewModel,
    )

}