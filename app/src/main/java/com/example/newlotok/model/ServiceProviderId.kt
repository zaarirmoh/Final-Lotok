package com.example.newlotok.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ServiceProviderId(
    @SerialName(value = "front_id")
    val frontId: String,
    @SerialName(value = "back_id")
    val backId: String,
)
