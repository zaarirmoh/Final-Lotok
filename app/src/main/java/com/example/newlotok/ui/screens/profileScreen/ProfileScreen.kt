package com.example.newlotok.ui.screens.profileScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.newlotok.model.ProfileInformation
import com.example.newlotok.ui.components.topBar.EndIconEdit
import com.example.newlotok.ui.components.topBar.TopBar
import com.example.newlotok.ui.components.topBar.TopBarCenterText
import com.example.newlotok.ui.screens.homeScreen.ErrorScreen
import com.example.newlotok.ui.screens.homeScreen.LoadingScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    onEditIconClicked: () -> Unit,
    onProfileCardClicked: () -> Unit,
    onCarsPostedCardClicked: () -> Unit,
    onSettingsCardClicked: () -> Unit,
    onVersionCardClicked: () -> Unit,
    profileScreenUiState: ProfileScreenUiState,
    retryAction: () -> Unit
){
    Scaffold(
        topBar = {
            TopBar(
                topBarCenter = { TopBarCenterText(text = "Profile") },
                endIcon = { EndIconEdit(onButtonClicked = onEditIconClicked) }
            )
        }
    ) {
        when (profileScreenUiState) {
            is ProfileScreenUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
            is ProfileScreenUiState.Success -> {
                Column(
                    modifier = modifier.padding(it),
                ) {
                    Spacer(modifier = modifier.height(28.dp))
                    ProfilePictureAndName(
                        profilePicture = profileScreenUiState.profileInformation.picture,
                        profileName = profileScreenUiState.profileInformation.firstName + " " + profileScreenUiState.profileInformation.lastName,
                        secondTextComposable = { ProfileSecondText(secondText = profileScreenUiState.profileInformation.email) }
                    )
                    Spacer(modifier = modifier.height(30.dp))
                    ProfileStatistics(
                        carsPosted = profileScreenUiState.profileInformation.carsPosted,
                        postsSaved = profileScreenUiState.profileInformation.postsSaved,
                        bookings = profileScreenUiState.profileInformation.bookings
                    )
                    Spacer(modifier = modifier.height(30.dp))
                    ProfileChoices(
                        onProfileCardClicked = onProfileCardClicked,
                        onCarsPostedCardClicked = onCarsPostedCardClicked,
                        onSettingsCardClicked = onSettingsCardClicked,
                        onVersionCardClicked = onVersionCardClicked
                    )
                }
            }
            is ProfileScreenUiState.Error -> ErrorScreen(retryAction = retryAction)
        }
    }
}