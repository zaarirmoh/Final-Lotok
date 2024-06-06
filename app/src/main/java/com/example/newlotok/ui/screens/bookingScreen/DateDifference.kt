package com.example.newlotok.ui.screens.bookingScreen

import androidx.compose.runtime.Composable
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.concurrent.TimeUnit

@Composable
fun DateDifference(
    firstDate: String,
    secondDate: String
) : Int {
    if (!((firstDate == "dd/mm/yyyy") || (secondDate == "dd/mm/yyyy"))){
        var parts = firstDate.split("-")
        val dateFirst = parts[2] + "/" + parts[1] + "/" + parts[0]
        parts = secondDate.split("-")
        val dateSecond = parts[2] + "/" + parts[1] + "/" + parts[0]
        if (dateFirst.isEmpty() || dateSecond.isEmpty() || dateFirst == "dd/mm/yyyy" || dateSecond == "dd/mm/yyyy" )  return 0

        val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val date1 = format.parse(dateFirst) // Replace with your first date
        val date2 = format.parse(dateSecond) // Replace with your second date

        val diff: Long = date2?.time?.minus(date1?.time!!) ?: 0
        val diffDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)

        return diffDays.toInt()
    }
    return 0
}