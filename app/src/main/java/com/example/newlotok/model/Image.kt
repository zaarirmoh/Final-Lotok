package com.example.newlotok.model

import android.net.Uri
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.net.URI

@Serializable
data class Image(
    val id : Int,
    @SerialName(value = "listing")
    val carPostId : Int,
    @SerialName(value = "user")
    val userId : Int,
    @Contextual
    @SerialName(value = "image_url")
    val imageUrl : URI,
    @Contextual
    val uploaded_on : Any? = null,
)
