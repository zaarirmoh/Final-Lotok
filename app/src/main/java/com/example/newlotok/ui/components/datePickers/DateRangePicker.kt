package com.example.newlotok.ui.components.datePickers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateRangePicker(
    modifier: Modifier = Modifier,
    openDialog: MutableState<Boolean>
){
    val snackState = remember { SnackbarHostState() }
    val snackScope = rememberCoroutineScope()
    SnackbarHost(hostState = snackState, Modifier)

    // TODO demo how to read the selected date from the state.
    if (openDialog.value) {
        val datePickerState = rememberDateRangePickerState()
        DatePickerDialog(
            onDismissRequest = {
                // Dismiss the dialog when the user clicks outside the dialog or on the back
                // button. If you want to disable that functionality, simply use an empty
                // onDismissRequest.
                openDialog.value = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    },
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Cancel")
                }
            }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, end = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = { openDialog.value = !openDialog.value }) {
                    Icon(Icons.Filled.Close, contentDescription = "Localized description")
                }
                TextButton(
                    onClick = {
                        snackScope.launch {
                            openDialog.value = !openDialog.value
                            val range =
                                datePickerState.selectedStartDateMillis!!..datePickerState.selectedEndDateMillis!!
                            snackState.showSnackbar("Saved range (timestamps): $range")
                        }
                    },
                    enabled = datePickerState.selectedEndDateMillis != null
                ) {
                    Text(text = "Save")
                }
            }
            androidx.compose.material3.DateRangePicker(state = datePickerState)
        }
    }
}