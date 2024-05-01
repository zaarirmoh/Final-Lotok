package com.example.newlotok.ui.screens.signInUpScreens.signInUpComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lotok.ui.theme.SignInUpCardShapes
import com.example.newlotok.R

@Preview
@Composable
fun SignInGoogleFacebook(
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        SignInCard(signInCardIcon = R.drawable.google_icon)
        Spacer(modifier = modifier.width(20.dp))
        SignInCard(signInCardIcon = R.drawable.facebook_icon)
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInCard(
    modifier: Modifier = Modifier,
    signInCardIcon: Int
){
    ElevatedCard(
        onClick = {},
        shape = SignInUpCardShapes.medium,
        elevation = CardDefaults.elevatedCardElevation(),
        modifier = modifier
            .size(width = 92.dp, height = 64.dp),
    ) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Box(
                modifier = modifier.size(24.dp)
            ) {
                Image(
                    painter = painterResource(id = signInCardIcon),
                    contentDescription = null,
                    modifier = modifier
                        .fillMaxSize()
                )
            }
        }
    }
}