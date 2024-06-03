package com.example.newlotok.model

import android.net.Uri

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
)
