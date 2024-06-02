package com.example.newlotok.model

data class CarPostFirst(
    val vin : String = "",
    val wilaya: Int = 0,
    val address: String = "",
    val description: String = "",
    val dailyPrice: Double = 0.0,
    val weeklyPrice: Double = 0.0,
)
