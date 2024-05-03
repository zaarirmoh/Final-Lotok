package com.example.newlotok.ui.screens.profileDetailsScreens.editProfileScreen

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.newlotok.model.Data
import com.example.newlotok.ui.navigation.LotokScreen
import androidx.navigation.NavHostController


fun NavGraphBuilder.editProfileScreenNavigation(
    navController: NavHostController
){
    composable(route = LotokScreen.EditProfileScreen.name){
        val newFirstName = remember { mutableStateOf(Data.profileInformation.firstName) }
        val newLastName = remember{ mutableStateOf(Data.profileInformation.lastName) }
        val newEmail = remember { mutableStateOf(Data.profileInformation.email) }
        val newLocation = remember { mutableStateOf(Data.profileInformation.location) }
        val newMobileNumber = remember { mutableStateOf(Data.profileInformation.mobileNumber) }
        EditProfileScreen(
            onGoBackButtonClicked = {
                newFirstName.value = Data.profileInformation.firstName
                newLastName.value = Data.profileInformation.lastName
                newEmail.value = Data.profileInformation.email
                newLocation.value = Data.profileInformation.location
                newMobileNumber.value = Data.profileInformation.mobileNumber
                navController.navigateUp()
            },
            onDoneButtonClicked = {
                Data.profileInformation.firstName = newFirstName.value
                Data.profileInformation.lastName = newLastName.value
                Data.profileInformation.email = newEmail.value
                Data.profileInformation.location = newLocation.value
                Data.profileInformation.mobileNumber = newMobileNumber.value
                navController.navigateUp()
            },
            newFirstName = newFirstName,
            newLastName = newLastName,
            newEmail = newEmail,
            newLocation = newLocation,
            newMobileNumber = newMobileNumber
        )
    }
}