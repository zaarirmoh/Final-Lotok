package com.example.lotok.ui.screens.profileScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.TravelExplore
import androidx.compose.material.icons.rounded.ChevronRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lotok.ui.theme.Shapes


@Composable
fun ProfileChoices(
    modifier: Modifier = Modifier,
    onProfileCardClicked: () -> Unit,
    onCarsPostedCardClicked: () -> Unit,
    onSettingsCardClicked: () -> Unit,
    onVersionCardClicked: () -> Unit,
){
    Column {
        ProfileChoice(
            profileChoiceIcon = Icons.Outlined.Person,
            profileChoice = "Profile",
            onNextIconClicked = onProfileCardClicked
        )
        Spacer(modifier = modifier.height(5.dp))
        Divider(
            color = Color(0xFFF7F7F9),
            modifier = modifier.padding(start = 20.dp, end = 20.dp)
        )
        Spacer(modifier = modifier.height(5.dp))
        ProfileChoice(
            profileChoiceIcon = Icons.Outlined.Person,
            profileChoice = "Cars posted",
            onNextIconClicked = onCarsPostedCardClicked
        )
        Spacer(modifier = modifier.height(5.dp))
        Divider(
            color = Color(0xFFF7F7F9),
            modifier = modifier.padding(start = 20.dp, end = 20.dp)
        )
        Spacer(modifier = modifier.height(5.dp))
        ProfileChoice(
            profileChoiceIcon = Icons.Outlined.Settings,
            profileChoice = "Settings",
            onNextIconClicked = onSettingsCardClicked
        )
        Spacer(modifier = modifier.height(5.dp))
        Divider(
            color = Color(0xFFF7F7F9),
            modifier = modifier.padding(start = 20.dp, end = 20.dp)
        )
        Spacer(modifier = modifier.height(5.dp))
        ProfileChoice(
            profileChoiceIcon = Icons.Outlined.TravelExplore,
            profileChoice = "Version",
            onNextIconClicked = onVersionCardClicked
        )
        Spacer(modifier = modifier.height(5.dp))
        Divider(
            color = Color(0xFFF7F7F9),
            modifier = modifier.padding(start = 20.dp, end = 20.dp)
        )
        Spacer(modifier = modifier.height(5.dp))
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileChoice(
    modifier: Modifier = Modifier,
    profileChoiceIcon: ImageVector,
    profileChoice: String,
    onNextIconClicked: () -> Unit = {}
){
    Card(
        shape = Shapes.large,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        onClick = onNextIconClicked,
        modifier = modifier.height(50.dp)
    ) {
        Spacer(modifier = modifier.height(15.dp))
        Row(
            modifier = modifier.fillMaxWidth()
        ) {
            Spacer(modifier = modifier.width(34.dp))
            Icon(
                imageVector = profileChoiceIcon,
                contentDescription = null,
                tint = Color(0xFF7D848D)
            )
            Spacer(modifier = modifier.width(14.dp))
            Text(
                text = profileChoice,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = modifier.fillMaxWidth()
            ) {

                Icon(
                    imageVector = Icons.Rounded.ChevronRight,
                    contentDescription = null,
                    modifier = modifier.padding(end = 47.dp),
                    tint = Color(0xFF7D848D)
                )

            }
        }
    }
}