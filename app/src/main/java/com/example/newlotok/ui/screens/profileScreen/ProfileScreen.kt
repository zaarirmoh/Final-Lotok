package com.example.newlotok.ui.screens.profileScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.example.newlotok.model.ProfileInformation
import com.example.newlotok.ui.components.topBar.EndIconEdit
import com.example.newlotok.ui.components.topBar.TopBar
import com.example.newlotok.ui.components.topBar.TopBarCenterText
import com.example.newlotok.ui.screens.homeScreen.ErrorScreen
import com.example.newlotok.ui.screens.homeScreen.LoadingScreen
import com.example.newlotok.ui.screens.signInUpScreens.signInUpComponents.SignInUpButton
import kotlinx.coroutines.launch

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
    profileScreenViewModel: ProfileScreenViewModel,
    onSignInButtonClicked: () -> Unit,
){
    Scaffold(
        topBar = {
            TopBar(
                topBarCenter = { TopBarCenterText(text = "Profile") },
                endIcon = { EndIconEdit(onButtonClicked = onEditIconClicked) }
            )
        }
    ) {
        val context = LocalContext.current
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
                LaunchedEffect(Unit) {
                    profileScreenViewModel.setID(
                        context = context,
                        id = profileScreenUiState.profileInformation.id
                    )
                }
            }
            is ProfileScreenUiState.Error -> {
                Column(
                    modifier = modifier.padding(it),
                ) {
                    Spacer(modifier = modifier.height(28.dp))
                    ProfilePictureAndName(
                        profilePicture = "https://t4.ftcdn.net/jpg/00/64/67/63/360_F_64676383_LdbmhiNM6Ypzb3FM4PPuFP9rHe7ri8Ju.jpg",
                        profileName = "Gueeeeeeeeeest" ,
                        secondTextComposable = { ProfileSecondText(secondText = "log in log in") }
                    )
                    Spacer(modifier = modifier.height(30.dp))
                    ProfileStatistics(
                        carsPosted = 0,
                        postsSaved = 0,
                        bookings = 0
                    )
                    Spacer(modifier = modifier.height(30.dp))
                    ProfileChoices(
                        onProfileCardClicked = {},
                        onCarsPostedCardClicked = {},
                        onSettingsCardClicked = onSettingsCardClicked,
                        onVersionCardClicked = onVersionCardClicked
                    )
                    Spacer(modifier = modifier.height(25.dp))
                    SignInUpButton(
                        text = "Sign In",
                        onSignInButtonClicked = onSignInButtonClicked
                    )
                }
            }
        }
    }
}