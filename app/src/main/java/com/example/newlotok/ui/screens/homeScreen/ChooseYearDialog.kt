package com.example.newlotok.ui.screens.homeScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.util.Calendar

@Composable
fun ChooseYearDialog(
    openDialog: MutableState<Boolean>,
    onYearSelected: (Int) -> Unit
) {
    if(openDialog.value){
        AlertDialog(
            onDismissRequest = {},
            title = { Text(text = "Choose a Year") },
            text = {
                val currentYear = Calendar.getInstance().get(Calendar.YEAR)
                val years = (1900..currentYear).toList().reversed()

                LazyColumn {
                    items(years) { year ->
                        Text(
                            text = year.toString(),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .clickable {
                                    onYearSelected(year)
                                }
                        )
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = {openDialog.value = false}) {
                    Text("Cancel")
                }
            }
        )
    }
}