package com.example.newlotok.model


data class CarPost(
    val id: Int,
    val imgSrc: List<Int>,
    val model: String,
    val year: Int,
    val make: String,
    val engine: String,
    val power: String,
    val body: String,
    val fuel: String,
    val transmission: String,
    val dayPrice: Int,
    val weekPrice: Int,
    val rating: Double,
    val description: String? = null,
    val location: String ,
    val comments : List<Comment> = listOf()
)