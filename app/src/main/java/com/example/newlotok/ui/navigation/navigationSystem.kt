package com.example.newlotok.ui.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.example.newlotok.ui.screens.carDetailsScreen.carDetailsScreenNavigation
import com.example.newlotok.ui.screens.homeScreen.homeScreenNavigation
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
){
    welcomeScreenNavigation(
        navController = navController,
        onWelcomeScreenButtonClicked = onWelcomeScreenButtonClicked,
    )
    homeScreenNavigation(navController = navController, scrollBehavior = scrollBehavior)
    selectACarScreenNavigation(navController = navController)
    selectBrandScreenNavigation(navController = navController)
    profileScreenNavigation(navController = navController)
    mainSettingsScreenNavigation(navController = navController)
    profileDetailsScreenNavigation(navController = navController)
    editProfileScreenNavigation(navController = navController)
    signInScreenNavigation(navController = navController)
    signUpScreenNavigation(navController = navController)
    forgotPasswordScreenNavigation(navController = navController)
    otpVerificationScreenNavigation(navController = navController)
    carDetailsScreenNavigation(navController = navController)
}