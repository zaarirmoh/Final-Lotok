package com.example.lotok.ui.screens.profileDetailsScreens.profileDetailsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.newlotok.ui.components.topBar.EndIconEdit
import com.example.newlotok.ui.components.topBar.StartIconGoBack
import com.example.newlotok.ui.components.topBar.TopBar
import com.example.newlotok.ui.components.topBar.TopBarCenterText
import com.example.lotok.ui.screens.profileScreen.ProfilePictureAndName

@Composable
fun ProfileDetailsScreen(
    modifier: Modifier = Modifier,
    onGoBackButtonClicked: () -> Unit = {},
    onEditButtonClicked: () -> Unit = {}
){
    Scaffold(
        topBar = {
            TopBar(
                topBarCenter = { TopBarCenterText(text = "Profile") },
                endIcon = { EndIconEdit(onButtonClicked = onEditButtonClicked) },
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
            ProfilePictureAndName()
            Spacer(modifier = modifier.height(25.dp))
            ProfileInformationCards()
        }
    }

}