package com.example.lotok.ui.screens.settingsScreens.mainSettingsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppSettings(
    modifier: Modifier = Modifier
){
    Column {
        Text(
            text = "App settings",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(start = 20.dp)
        )
        Spacer(modifier = modifier.height(15.dp))
        Setting(
            firstElement = { SecondElement(text = "Enable Face ID for Log In") },
            secondElement = { },
            lastElement = { LastElementSwitchButton(check = false) },
            onSettingClicked = {}
        )
        Divider(
            color = Color(0xFFF7F7F9),
            modifier = modifier.padding(start = 20.dp, end = 20.dp)
        )
        Setting(
            firstElement = { SecondElement(text = "Enable push notifications") },
            secondElement = { },
            lastElement = { LastElementSwitchButton(check = true) },
            onSettingClicked = {}
        )
        Divider(
            color = Color(0xFFF7F7F9),
            modifier = modifier.padding(start = 20.dp, end = 20.dp)
        )
        Setting(
            firstElement = { SecondElement(text = "Enable location services") },
            secondElement = { },
            lastElement = { LastElementSwitchButton(check = true) },
            onSettingClicked = {}
        )
        Divider(
            color = Color(0xFFF7F7F9),
            modifier = modifier.padding(start = 20.dp, end = 20.dp)
        )
        Setting(
            firstElement = { SecondElement(text = "Dark mode") },
            secondElement = { },
            lastElement = { LastElementSwitchButton(check = false) },
            onSettingClicked = {}
        )
        Divider(
            color = Color(0xFFF7F7F9),
            modifier = modifier.padding(start = 20.dp, end = 20.dp)
        )
    }
}