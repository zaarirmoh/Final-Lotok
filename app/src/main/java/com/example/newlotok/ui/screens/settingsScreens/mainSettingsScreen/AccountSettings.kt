package com.example.lotok.ui.screens.settingsScreens.mainSettingsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Logout
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Payment
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AccountSettings(
    modifier: Modifier = Modifier
){
    Column {
        Text(
            text = "Account settings",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(start = 20.dp)
        )
        Spacer(modifier = modifier.height(15.dp))
        Setting(
            firstElement = { FirstElement(icon = Icons.Outlined.Notifications) },
            secondElement = { SecondElement(text = "Notification Setting") },
            lastElement = { LastElementIcon() },
            onSettingClicked = {}
        )
        Divider(
            color = Color(0xFFF7F7F9),
            modifier = modifier.padding(start = 20.dp, end = 20.dp)
        )
        Setting(
            firstElement = { FirstElement(icon = Icons.Outlined.ShoppingCart) },
            secondElement = { SecondElement(text = "Shipping adress") },
            lastElement = { LastElementIcon() },
            onSettingClicked = {}
        )
        Divider(
            color = Color(0xFFF7F7F9),
            modifier = modifier.padding(start = 20.dp, end = 20.dp)
        )
        Setting(
            firstElement = { FirstElement(icon = Icons.Outlined.Payment) },
            secondElement = { SecondElement(text = "Payment information") },
            lastElement = { LastElementIcon() },
            onSettingClicked = {}
        )
        Divider(
            color = Color(0xFFF7F7F9),
            modifier = modifier.padding(start = 20.dp, end = 20.dp)
        )
        Setting(
            firstElement = { FirstElement(icon = Icons.Outlined.Logout) },
            secondElement = { SecondElement(text = "Log Out") },
            lastElement = {},
            onSettingClicked = {}
        )
        Divider(
            color = Color(0xFFF7F7F9),
            modifier = modifier.padding(start = 20.dp, end = 20.dp)
        )
        Setting(
            firstElement = { FirstElement(icon = Icons.Outlined.Delete) },
            secondElement = { SecondElement(text = "Delete account") },
            lastElement = {},
            onSettingClicked = {}
        )
        Divider(
            color = Color(0xFFF7F7F9),
            modifier = modifier.padding(start = 20.dp, end = 20.dp)
        )
    }
}