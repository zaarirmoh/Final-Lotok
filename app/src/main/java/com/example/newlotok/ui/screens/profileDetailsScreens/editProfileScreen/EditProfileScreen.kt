package com.example.lotok.ui.screens.profileDetailsScreens.editProfileScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.newlotok.ui.components.topBar.EndIconDone
import com.example.newlotok.ui.components.topBar.StartIconGoBack
import com.example.newlotok.ui.components.topBar.TopBar
import com.example.newlotok.ui.components.topBar.TopBarCenterText
import com.example.lotok.ui.screens.profileScreen.ProfilePictureAndName
import com.example.lotok.ui.screens.profileScreen.ProfileSecondText

@Composable
fun EditProfileScreen(
    modifier: Modifier = Modifier,
    onGoBackButtonClicked: () -> Unit = {},
    onDoneButtonClicked: () -> Unit = {},
    onChangeProfilePictureTextClicked: () -> Unit = {},
    newFirstName: MutableState<String>,
    newLastName: MutableState<String>,
    newEmail: MutableState<String>,
    newLocation: MutableState<String>,
    newMobileNumber: MutableState<String>
){
    Scaffold(
        topBar = {
            TopBar(
                topBarCenter = { TopBarCenterText(text = "Edit profile") },
                endIcon = { EndIconDone(onButtonClicked = onDoneButtonClicked) },
                startIcon = { StartIconGoBack(onButtonClicked = onGoBackButtonClicked) }
            )
        }
    ) {
        Column(
            modifier = modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = modifier.height(28.dp))
            ProfilePictureAndName(
                secondTextComposable = {
                    ProfileSecondText(
                        secondText = "Change profile picture",
                        secondTextColor = MaterialTheme.colorScheme.primary,
                        secondTextFontWeight = FontWeight.Medium,
                        modifier = modifier.clickable(onClick = onChangeProfilePictureTextClicked)
                    )
                }
            )
            Spacer(modifier = modifier.height(25.dp))
            ProfileInformationTextFieldCards(
                newFirstName = newFirstName,
                newLastName = newLastName,
                newEmail = newEmail,
                newLocation = newLocation,
                newMobileNumber = newMobileNumber
            )
        }
    }
}