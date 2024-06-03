package com.example.newlotok.ui.screens.bookingScreen

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import java.util.Calendar

@Composable
fun DatePickerButton(date : String , onDateChanged : (String) -> Unit ,modifier: Modifier = Modifier) {
    var selectedDate by remember { mutableStateOf(date) }
    val context = LocalContext.current

    OutlinedButton(
        onClick = {
            showDatePicker(context) { year, month, day ->
                selectedDate = "$day/$month/$year"
                onDateChanged(selectedDate)
            }

        },
        shape = RoundedCornerShape(4.dp), // This makes the button round
        border = BorderStroke(1.dp, Color.Gray), // This adds a border
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color.Black,
        ),
        modifier = modifier
            .fillMaxSize()
            .height(52.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text= selectedDate,
                color = if (selectedDate == "mm/dd/yyyy") Color.Gray else Color.Black
            )

            Icon(
                Icons.Default.CalendarMonth,
                contentDescription = "Calender"
            )
        }
    }
}


@SuppressLint("NewApi")
fun showDatePicker(context: Context, dateSetListener: (Int, Int, Int) -> Unit) {
    val now = Calendar.getInstance()
    val datePicker = DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            dateSetListener(year, month + 1, dayOfMonth)
        },
        now.get(Calendar.YEAR),
        now.get(Calendar.MONTH),
        now.get(Calendar.DAY_OF_MONTH)
    )
    datePicker.show()
}