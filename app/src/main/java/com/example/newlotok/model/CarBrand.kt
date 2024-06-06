package com.example.newlotok.model

import androidx.compose.runtime.Immutable


@Immutable
data class CarBrand(
    val id : Int,
    val brandPic : Int,
    val make: String = "",
)
