package com.example.newlotok.model

import android.net.Uri
import androidx.compose.runtime.Immutable

@Immutable
data class CarPostFirst(
    val vin : String = "",
    val wilaya: Int = 0,
    val address: String = "",
    val description: String = "",
    val dailyPrice: Double = 0.0,
    val weeklyPrice: Double = 0.0,
    val carPictures : List<Uri> = listOf(),
    val carteGrisePic :List<Uri> = listOf(),
    val assurancePic : List<Uri> = listOf(),
    val technicalControlPic : List<Uri> = listOf(),
    val make: String = "",
    val model: String = "",
    val year: Int = 0,
    val fuel: String = "",
    val engine: String = "",
    val power: Int = 0,
    val body: String = "",
    val transmission: String = "",
    val category :Int = 0,
)
