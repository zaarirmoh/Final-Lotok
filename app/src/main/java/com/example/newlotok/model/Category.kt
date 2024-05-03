package com.example.newlotok.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Category(
    val id: Int,
    @SerialName(value = "img_src") val imgSrc: String
)
