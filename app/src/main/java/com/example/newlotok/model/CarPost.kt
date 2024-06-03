package com.example.newlotok.model

import androidx.compose.runtime.Immutable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Immutable
@Serializable
data class CarPost(
    val vin: String,
    val id: Int,
    @SerialName(value = "main_image_url")
    val imgSrc: String,
    val model: String,
    val year: Int,
    val make: String,
    val engine: String,
    @SerialName(value= "horse_power")
    val power: Int,
    val body: String,
    val fuel: String,
    val transmission: String,
    @SerialName(value = "day_price")
    val dayPrice: Double,
    @SerialName(value = "week_price")
    val weekPrice: Double,
    val rating: Double,
    val description: String? = null,
    @SerialName(value = "wilaya")
    val location: Int ,
    @SerialName(value = "user")
    val userId: Int,
    val category: Int,
    @SerialName(value = "is_verified")
    val isVerified: Boolean,
    // to be removed
    val fakeImgSrc: List<Int> = listOf()
)