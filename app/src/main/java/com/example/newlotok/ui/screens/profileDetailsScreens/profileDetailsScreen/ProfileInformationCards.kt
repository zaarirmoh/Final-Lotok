package com.example.lotok.ui.screens.profileDetailsScreens.profileDetailsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newlotok.model.profileInformation

@Composable
fun ProfileInformationCards(
    modifier: Modifier = Modifier
){
    Column {
        ProfileInformationCard(
            profileDetailTitle = "First name",
            profileDetail = profileInformation.firstName
        )
        Spacer(modifier = modifier.height(16.dp))
        ProfileInformationCard(
            profileDetailTitle = "Last name",
            profileDetail = profileInformation.lastName
        )
        Spacer(modifier = modifier.height(16.dp))
        ProfileInformationCard(
            profileDetailTitle = "Email",
            profileDetail = profileInformation.email
        )
        Spacer(modifier = modifier.height(16.dp))
        ProfileInformationCard(
            profileDetailTitle = "Location",
            profileDetail = profileInformation.location
        )
        Spacer(modifier = modifier.height(16.dp))
        ProfileInformationCard(
            profileDetailTitle = "Mobile number",
            profileDetail = profileInformation.mobileNumber
        )
    }
}
@Composable
fun ProfileInformationCard(
    modifier: Modifier = Modifier,
    profileDetail: String?,
    profileDetailTitle: String
){
    Column {
        Text(
            text = profileDetailTitle,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(start = 25.dp)
        )
        Spacer(modifier = modifier.height(12.dp))
        InformationCard(profileDetail = profileDetail)
    }
}
@Composable
fun InformationCard(
    modifier: Modifier = Modifier,
    profileDetail: String?
){
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F7F9)),
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(start = 25.dp, end = 25.dp)
    ) {
        Spacer(modifier = modifier.height(18.dp))
        if (profileDetail != null) {
            Text(
                text = profileDetail,
                fontSize = 16.sp,
                modifier = modifier.padding(start = 16.dp)
            )
        }
    }
}