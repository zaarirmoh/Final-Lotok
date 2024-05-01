package com.example.lotok.ui.screens.profileDetailsScreens.editProfileScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.HighlightOff
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileInformationTextFieldCards(
    modifier: Modifier = Modifier,
    newFirstName: MutableState<String>,
    newLastName: MutableState<String>,
    newEmail: MutableState<String>,
    newLocation: MutableState<String>,
    newMobileNumber: MutableState<String>
){
    Column {
        ProfileInformationTextFieldCard(
            profileDetailTitle = "First name",
            profileDetail = newFirstName,
        )
        Spacer(modifier = modifier.height(16.dp))
        ProfileInformationTextFieldCard(
            profileDetailTitle = "Last name",
            profileDetail = newLastName
        )
        Spacer(modifier = modifier.height(16.dp))
        ProfileInformationTextFieldCard(
            profileDetailTitle = "Email",
            profileDetail = newEmail
        )
        Spacer(modifier = modifier.height(16.dp))
        ProfileInformationTextFieldCard(
            profileDetailTitle = "Location",
            profileDetail = newLocation
        )
        Spacer(modifier = modifier.height(16.dp))
        ProfileInformationTextFieldCard(
            profileDetailTitle = "Mobile number",
            profileDetail = newMobileNumber
        )
    }
}
@Composable
fun ProfileInformationTextFieldCard(
    modifier: Modifier = Modifier,
    profileDetailTitle: String,
    profileDetail: MutableState<String>
){
    Column {
        Text(
            text = profileDetailTitle,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(start = 25.dp)
        )
        Spacer(modifier = modifier.height(12.dp))
        InformationTextFieldCard(textFieldValue = profileDetail)
    }
}

@Composable
fun InformationTextFieldCard(
    modifier: Modifier = Modifier,
    textFieldValue: MutableState<String>,
    suffix: @Composable () -> Unit = {}
){
    OutlinedTextField(
        value = textFieldValue.value,
        onValueChange = {textFieldValue.value = it},
        trailingIcon = {
            Icon(
                imageVector = Icons.Outlined.HighlightOff,
                contentDescription = null
            )
        },
        suffix = suffix,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 25.dp, end = 25.dp)
    )
}