package com.example.lotok.ui.screens.settingsScreens.mainSettingsScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ChevronRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lotok.ui.theme.Shapes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Setting(
    modifier: Modifier = Modifier,
    firstElement: @Composable () -> Unit,
    secondElement: @Composable () -> Unit,
    lastElement: @Composable () -> Unit,
    onSettingClicked: () -> Unit,
){
    Card(
        shape = Shapes.large,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        onClick = onSettingClicked,
        modifier = modifier.height(50.dp)
    ) {
        Spacer(modifier = modifier.height(15.dp))
        Row(
            modifier = modifier.fillMaxWidth()
        ) {
            Spacer(modifier = modifier.width(34.dp))
            firstElement()
            Spacer(modifier = modifier.width(20.dp))
            secondElement()
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = modifier.fillMaxWidth()
            ) {
                lastElement()
            }
        }
    }
}
@Composable
fun FirstElement(
    modifier: Modifier = Modifier,
    icon: ImageVector
){
    Icon(
        imageVector = icon,
        contentDescription = null,
        tint = Color(0xFF7D848D)
    )
}
@Composable
fun SecondElement(
    modifier: Modifier = Modifier,
    text: String
){
    Text(
        text = text,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium
    )
}
@Composable
fun LastElementIcon(
    modifier: Modifier = Modifier
){
    Icon(
        imageVector = Icons.Rounded.ChevronRight,
        contentDescription = null,
        modifier = modifier.padding(end = 20.dp),
        tint = Color(0xFF7D848D)
    )
}
@Composable
fun LastElementSwitchButton(
    modifier: Modifier = Modifier,
    check: Boolean,
    onSwitchButtonClicked: () -> Unit = {}
){
    var checked by remember { mutableStateOf(check) }
    Switch(
        checked = checked,
        onCheckedChange = {
            checked = !checked
            onSwitchButtonClicked
        },
        modifier = modifier.padding(end = 20.dp)
    )
}