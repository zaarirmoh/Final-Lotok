package com.example.newlotok.model

import androidx.compose.runtime.Immutable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Immutable
@Serializable
data class Category(
    val id: Int,
    @SerialName(value = "img_src") val imgSrc: String
)
