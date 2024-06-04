package com.example.newlotok.model

import kotlinx.serialization.Serializable

@Serializable
data class VinResult(
    val year: Int = 0,
    val make: String = "",
    val model: String = "",
    val engine :String = "",
    val horsePower :Int = 0,
    val fuel : String = "",
)
