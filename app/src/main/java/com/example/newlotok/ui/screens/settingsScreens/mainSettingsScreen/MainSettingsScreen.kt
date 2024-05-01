package com.example.lotok.ui.screens.settingsScreens.mainSettingsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.newlotok.ui.components.topBar.StartIconGoBack
import com.example.newlotok.ui.components.topBar.TopBar
import com.example.newlotok.ui.components.topBar.TopBarCenterText

@Composable
fun MainSettingsScreen(
    modifier: Modifier = Modifier,
    onGoBackButtonClicked: () -> Unit = {}
){
    Scaffold(
        topBar = {
            TopBar(
                startIcon = { StartIconGoBack(onButtonClicked = onGoBackButtonClicked) },
                topBarCenter = { TopBarCenterText(text = "Account & Settings") },
            )
        }
    ) {
        Column(
            modifier = modifier.padding(it)
        ) {
            Spacer(modifier = modifier.height(23.dp))
            AccountSettings()
            Spacer(modifier = modifier.height(23.dp))
            AppSettings()
        }
    }

}



