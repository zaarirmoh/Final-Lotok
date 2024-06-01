package com.example.newlotok.ui.screens.bookingScreen

import androidx.compose.runtime.Composable
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.concurrent.TimeUnit

@Composable
fun DateDifference(firstDate: String, secondDate: String) : Int {
    if (firstDate.isEmpty() || secondDate.isEmpty() || firstDate == "dd/mm/yyyy" || secondDate == "dd/mm/yyyy" )  return 0

    val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val date1 = format.parse(firstDate) // Replace with your first date
    val date2 = format.parse(secondDate) // Replace with your second date

    val diff: Long = date2?.time?.minus(date1?.time!!) ?: 0
    val diffDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)

    return diffDays.toInt()
}