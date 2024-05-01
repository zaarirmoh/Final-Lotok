package com.example.newlotok.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class CarPost(
    val id: Int,
    @SerialName(value = "img_src")
    val imgSrc: String,
    val model: String,
    val year: Int,
    val make: String,
    val engine: String,
    val power: String,
    val body: String,
    val fuel: String,
    val transmission: String,
    @SerialName(value = "day_price")
    val dayPrice: Int,
    @SerialName(value = "week_price")
    val weekPrice: Int,
    val rating: Double,
    val description: String? = null,
    val location: String ,
)