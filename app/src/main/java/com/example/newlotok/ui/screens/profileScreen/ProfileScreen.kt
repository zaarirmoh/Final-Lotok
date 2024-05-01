package com.example.lotok.ui.screens.profileScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.newlotok.ui.components.topBar.EndIconEdit
import com.example.newlotok.ui.components.topBar.TopBar
import com.example.newlotok.ui.components.topBar.TopBarCenterText

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    onEditIconClicked: () -> Unit,
    onProfileCardClicked: () -> Unit,
    onCarsPostedCardClicked: () -> Unit,
    onSettingsCardClicked: () -> Unit,
    onVersionCardClicked: () -> Unit,
){
    Scaffold(
        topBar = {
            TopBar(
                topBarCenter = { TopBarCenterText(text = "Profile") },
                endIcon = { EndIconEdit(onButtonClicked = onEditIconClicked) }
            )
        }
    ) {
        Column(
            modifier = modifier.padding(it),
        ) {
            Spacer(modifier = modifier.height(28.dp))
            ProfilePictureAndName()
            Spacer(modifier = modifier.height(30.dp))
            ProfileStatistics()
            Spacer(modifier = modifier.height(30.dp))
            ProfileChoices(
                onProfileCardClicked = onProfileCardClicked,
                onCarsPostedCardClicked = onCarsPostedCardClicked,
                onSettingsCardClicked = onSettingsCardClicked,
                onVersionCardClicked = onVersionCardClicked
            )
        }
    }
}