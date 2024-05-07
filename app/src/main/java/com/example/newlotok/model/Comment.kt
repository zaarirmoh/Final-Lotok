package com.example.newlotok.model

import androidx.compose.runtime.Immutable


@Immutable
data class Comment(
    val profilePic: Int,
    val title: String,
    val date: String,
    val review: String
)
