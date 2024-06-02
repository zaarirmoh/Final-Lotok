package com.example.newlotok.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Tokens(
    @SerialName("access")
    val accessToken: String,
    @SerialName("refresh")
    val refreshToken: String,
)
