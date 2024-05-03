package com.example.newlotok.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.newlotok.model.Data
import com.example.newlotok.model.Data.profileInformation
import com.example.newlotok.ui.screens.homeScreen.HomeScreenViewModel
import com.example.newlotok.ui.components.navigationBar.MyNavigationBar
import com.example.newlotok.ui.screens.carDetailsScreen.CarDetailsScreen
import com.example.newlotok.ui.screens.homeScreen.HomeScreenWithConnection
import com.example.newlotok.ui.screens.profileDetailsScreens.editProfileScreen.EditProfileScreen
import com.example.newlotok.ui.screens.profileDetailsScreens.profileDetailsScreen.ProfileDetailsScreen
import com.example.newlotok.ui.screens.profileScreen.ProfileScreen
import com.example.newlotok.ui.screens.selectACarScreen.SelectACarScreen
import com.example.newlotok.ui.screens.selectBrandScreen.SelectBrandScreen
import com.example.newlotok.ui.screens.settingsScreens.mainSettingsScreen.MainSettingsScreen
import com.example.newlotok.ui.screens.signInUpScreens.forgotPasswordScreen.ForgotPasswordScreen
import com.example.newlotok.ui.screens.signInUpScreens.otpVerificationScreen.OtpVerificationScreen
import com.example.newlotok.ui.screens.signInUpScreens.signInScreen.SignInScreen
import com.example.newlotok.ui.screens.signInUpScreens.singUpScreen.SignUpScreen
import com.example.newlotok.ui.screens.welcomeScreen.WelcomeScreen

// ToDo: Try to Extract the scaffold out so all the screen have like one topAppBar and one NavigationBar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LotokNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    onWelcomeScreenButtonClicked: () -> Unit = {},
    showWelcomeScreen: Boolean = true,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    scrollBehavior: TopAppBarScrollBehavior,
    startDestination: String = LotokScreen.WelcomeScreen.name
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val expandedMenu = remember { mutableStateOf(false)}
    val openDialog = remember { mutableStateOf(false)}
    val newFirstName = remember { mutableStateOf(profileInformation.firstName) }
    val newLastName = remember{ mutableStateOf(profileInformation.lastName) }
    val newEmail = remember { mutableStateOf(profileInformation.email) }
    val newLocation = remember { mutableStateOf(profileInformation.location) }
    val newMobileNumber = remember { mutableStateOf(profileInformation.mobileNumber) }
    // Get the name of the current screen
    val currentScreen = LotokScreen.valueOf(
        backStackEntry?.destination?.route ?: LotokScreen.HomeScreen.name
    )
    Scaffold(
        /**
         * topBar = {
         *                  AllTopBars(currentScreen = currentScreen)
         *         },
         */
        bottomBar = {
            // Get current back stack entry

            if(currentScreen.hasNavigationBar) MyNavigationBar(navController = navController)
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = modifier.padding(it)
        ) {
            composable(route = LotokScreen.WelcomeScreen.name){
                WelcomeScreen(
                    onButtonClicked = {
                        onWelcomeScreenButtonClicked()
                        navController.navigate(LotokScreen.HomeScreen.name) {
                            // Empty the back stack
                            popUpTo(navController.graph.startDestinationId) {
                                inclusive = true
                            }
                        }
                    }
                )
            }
            composable(route = LotokScreen.HomeScreen.name){
                val homeScreenViewModel: HomeScreenViewModel =
                    viewModel(factory = HomeScreenViewModel.Factory)
                HomeScreenWithConnection(
                    homeScreenUiState = homeScreenViewModel.homeScreenUiState,
                    retryAction = homeScreenViewModel::getCarPosts,
                    scrollBehavior = scrollBehavior
                )
                /*
                HomeScreen(
                    onNotificationIconClicked = {
                    },
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
                    expendedMenu = expandedMenu
                )
                 */
            }
            composable(route = LotokScreen.SelectACarScreen.name){
                SelectACarScreen(
                    onProfileIconClicked = {
                    },
                    onGoBackIconClicked = {
                        navController.navigateUp()
                    },
                    onHomeIconClicked = {
                        navController.navigateUp()
                    }
                )
            }
            composable(route = LotokScreen.SelectBrandScreen.name){
                SelectBrandScreen(
                    carBrandsList = Data.carBrandsList,
                    onGoBackIconClicked = {
                        navController.navigateUp()
                    },
                    onLogoClicked ={ navController.navigate(LotokScreen.CarDetailsScreen.name)}
                )
            }
            composable(route = LotokScreen.ProfileScreen.name){
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
                )
            }
            composable(route = LotokScreen.MainSettingsScreen.name){
                MainSettingsScreen(
                    onGoBackButtonClicked = {
                        navController.navigateUp()
                    }
                )
            }
            composable(route = LotokScreen.ProfileDetailsScreen.name){
                ProfileDetailsScreen(
                    onGoBackButtonClicked = {
                        navController.navigateUp()
                    },
                    onEditButtonClicked = {
                        navController.navigate(LotokScreen.EditProfileScreen.name)
                    }
                )
            }
            composable(route = LotokScreen.EditProfileScreen.name){
                EditProfileScreen(
                    onGoBackButtonClicked = {
                        newFirstName.value = profileInformation.firstName
                        newLastName.value = profileInformation.lastName
                        newEmail.value = profileInformation.email
                        newLocation.value = profileInformation.location
                        newMobileNumber.value = profileInformation.mobileNumber
                        navController.navigateUp()
                    },
                    onDoneButtonClicked = {
                        profileInformation.firstName = newFirstName.value
                        profileInformation.lastName = newLastName.value
                        profileInformation.email = newEmail.value
                        profileInformation.location = newLocation.value
                        profileInformation.mobileNumber = newMobileNumber.value
                        navController.navigateUp()
                    },
                    newFirstName = newFirstName,
                    newLastName = newLastName,
                    newEmail = newEmail,
                    newLocation = newLocation,
                    newMobileNumber = newMobileNumber
                )
            }
            composable(route = LotokScreen.SignInScreen.name){
                SignInScreen(
                    onSignInTextClicked = {
                        navController.navigate(LotokScreen.SignUpScreen.name)
                    },
                    onForgotPasswordTextClicked = {
                        navController.navigate(LotokScreen.ForgotPasswordScreen.name)
                    },
                    onGoBackButtonClicked = {
                        navController.navigateUp()
                    }
                )
            }
            composable(route = LotokScreen.SignUpScreen.name){
                SignUpScreen(
                    onSignUPTextClicked = {
                        navController.navigate(LotokScreen.SignInScreen.name)
                    },
                    onGoBackButtonClicked = {
                        navController.navigateUp()
                    }
                )
            }
            composable(route = LotokScreen.ForgotPasswordScreen.name){
                ForgotPasswordScreen(
                    onGoBackButtonClicked = {
                        navController.navigateUp()
                    },
                    onForgotPasswordButtonClicked = {
                        navController.navigate(LotokScreen.OtpVerificationScreen.name)
                    }
                )
            }
            composable(route = LotokScreen.OtpVerificationScreen.name){
                OtpVerificationScreen()
            }
            composable(route = LotokScreen.CarDetailsScreen.name){
                 CarDetailsScreen(Data.carPostsList[0])
            }
        }
    }
}

@Composable
fun NavGraphBuilder.NewFunction(

){
}
