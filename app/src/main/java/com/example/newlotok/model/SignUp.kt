package com.example.newlotok.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignUp(
    @SerialName("first_name")
    val firstName: String,
    @SerialName("last_name")
    val lastName: String,

    val email: String,

    val password: String,
    @SerialName("re_password")
    val confirmPassword: String
)
