package com.example.newlotok.ui.screens.homeScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newlotok.ui.theme.md_theme_light_onPrimary
import com.example.newlotok.R

@Composable
fun SearchForACar(
    modifier: Modifier = Modifier,
    onSearchForACarButtonClicked: () -> Unit
){
    Box {
        Button(
            onClick = onSearchForACarButtonClicked,
            modifier = modifier
                .height(50.dp)
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp)
        ) {
            Text(
                text = stringResource(id = R.string.SearchForACar),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
        }
        Icon(
            imageVector = Icons.Rounded.Search,
            contentDescription = null,
            tint = md_theme_light_onPrimary,
            modifier = modifier
                .align(Alignment.CenterStart)
                .padding(start = 40.dp)

        )
    }
}