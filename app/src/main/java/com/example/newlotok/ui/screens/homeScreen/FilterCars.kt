package com.example.newlotok.ui.screens.homeScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.EnergySavingsLeaf
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newlotok.R

@Composable
fun FilterCars(
    modifier: Modifier = Modifier,
    onStateButtonClicked: () -> Unit = {},
    onFromToButtonClicked: () -> Unit = {},
    onYearButtonClicked: () -> Unit = {},
    onYearSelected: (Int) -> Unit = {},
    onEnergyButtonClicked: () -> Unit = {},
    expandedYears: MutableState<Boolean>,
    expandedStates: MutableState<Boolean>
){
    Column {
        Row(
            modifier = modifier.fillMaxWidth()
        ) {
            State(expanded = expandedStates)
            Spacer(modifier = modifier.width(18.dp))
            FromTo(onFromToButtonClicked = onFromToButtonClicked)
        }
        Spacer(modifier = modifier.height(22.dp))
        Row(
            modifier = modifier.fillMaxWidth(),
        ) {
            Year(
                expanded = expandedYears,
            )
            Spacer(modifier = modifier.width(34.dp))
            Energy(onEnergyButtonClicked = onEnergyButtonClicked)
        }
    }
}

@Composable
fun State(
    modifier: Modifier = Modifier,
    expanded: MutableState<Boolean>
){
    Box{
        Button(
            onClick = {
                expanded.value = true
            },
            modifier = modifier
                .padding(start = 44.dp)
                .height(34.dp)
                .width(106.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDADADA))

        ) {
            Text(
                text = stringResource(id = R.string.State),
                color = Color.Black
            )
        }
        Icon(
            imageVector = Icons.Outlined.LocationOn,
            contentDescription = null,
            tint = Color(0xFF9B9B9B),
            modifier = modifier
                .align(Alignment.CenterStart)
                .padding(start = 48.dp)

        )
    }
}

@Composable
fun FromTo(
    modifier: Modifier = Modifier,
    onFromToButtonClicked: () -> Unit
){
    Box {
        Button(
            onClick = onFromToButtonClicked,
            modifier = modifier
                //.width(200.dp)
                .fillMaxWidth()
                .height(34.dp)
                .padding(end = 29.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDADADA))
        ) {
            Text(
                text = stringResource(id = R.string.FromTo),
                color = Color.Black
            )
        }
        Icon(
            imageVector = Icons.Outlined.CalendarMonth,
            contentDescription = null,
            tint = Color(0xFF9B9B9B),
            modifier = modifier
                .align(Alignment.CenterStart)
                .padding(start = 5.dp)

        )
    }
}

@Composable
fun Year(
    modifier: Modifier = Modifier,
    expanded: MutableState<Boolean>,
){

    Box {
        Button(
            onClick = {
                expanded.value = true
            },
            modifier = modifier
                .padding(start = 86.dp)
                .width(106.dp)
                .height(34.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDADADA))
        ) {
            Text(
                text = "Year",
                color = Color.Black
            )
        }
        Icon(
            imageVector = Icons.Outlined.AccessTime,
            contentDescription = null,
            tint = Color(0xFF9B9B9B),
            modifier = modifier
                .align(Alignment.CenterStart)
                .padding(start = 90.dp)

        )



    }
}

@Composable
fun Energy(
    modifier: Modifier = Modifier,
    onEnergyButtonClicked: () -> Unit
){
    Box {
        Button(
            onClick = onEnergyButtonClicked,
            modifier = modifier
                .height(34.dp)
                .width(106.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDADADA))
        ) {
            Text(
                text = stringResource(id = R.string.Energy),
                fontSize = 13.sp,
                color = Color.Black,
            )
        }
        Icon(
            imageVector = Icons.Outlined.EnergySavingsLeaf,
            contentDescription = null,
            tint = Color(0xFF9B9B9B),
            modifier = modifier
                .align(Alignment.CenterStart)
                .padding(start = 4.dp)

        )
    }
}