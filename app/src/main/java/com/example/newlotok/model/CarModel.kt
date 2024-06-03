package com.example.newlotok.model

import com.example.newlotok.R

data class CarModel(
    val id: Int,
    val model: String ,
    val pic : Int
)

val fakeModels = listOf(
    CarModel(
        id = 1,
        model = "M4 Competition",
        pic = R.drawable.red_car,
    ),
    CarModel(
        id = 2,
        model = "M4 Competition",
        pic = R.drawable.red_car,
    ),
    CarModel(
        id = 3,
        model = "M4 Competition",
        pic = R.drawable.red_car,
    ),
    CarModel(
        id = 4,
        model = "M4 Competition",
        pic = R.drawable.red_car,
    ),
    CarModel(
        id = 5,
        model = "M4 Competition",
        pic = R.drawable.red_car,
    ),
    CarModel(
        id = 6,
        model = "M4 Competition",
        pic = R.drawable.red_car,
    ),
)
