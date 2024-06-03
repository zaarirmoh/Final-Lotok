package com.example.newlotok.model

import com.example.newlotok.R


private const val id: Int = 0
object Data{
    val carPostsList: List<CarPost> = listOf(
        CarPost(
            id = id,
            imgSrc = "",
            fakeImgSrc = listOf(
                R.drawable.car_picture,
                R.drawable.car2_pic,
                R.drawable.car3_pic,
                R.drawable.car4_pic
            ),
            /*
            listOf(
                R.drawable.car_picture,
                R.drawable.car2_pic,
                R.drawable.car3_pic,
                R.drawable.car4_pic
            ),
             */
            model = "M4 Competition",
            make = "BMW",
            year = 2000,
            engine = "V8",
            dayPrice = 4000.0,
            weekPrice = 12000.0,
            rating = 3.5,
            body = "",
            fuel = "",
            power = 4,
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore  .Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore  .Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore  .",
            transmission = "",
            location = 25,
            category = 1,
            isVerified = true,
            userId = 1,
            vin = "",
        )
    )
    val fakeImages: List<Int> = listOf(
        R.drawable.car_picture,
        R.drawable.car2_pic,
        R.drawable.car3_pic,
        R.drawable.car4_pic
    )
    val carBrandsList: List<CarBrand> = listOf(
        CarBrand(
            id = 1,
            brandPic = R.drawable.bmw_logo2_logo_svg_vector,
        ),
        CarBrand(
            id = 2,
            brandPic = R.drawable.fiat_3_logo_svg_vector),
        CarBrand(
            id = 3,
            brandPic = R.drawable.audi_14_logo_svg_vector,
        ),
        CarBrand(
            4,
            R.drawable.ford_8_logo_svg_vector,
        ),
        CarBrand(
            5,
            R.drawable.honda_11_logo_svg_vector,
        ),
        CarBrand(
            6,
            R.drawable.infiniti_1_logo_svg_vector,
        ),
        CarBrand(
            7,
            R.drawable.jaguar_cars_logo_svg_vector,
        ),
        CarBrand(
            8,
            R.drawable.jeep_7_logo_svg_vector,
        ),
        CarBrand(
            9,
            R.drawable.lamborghini_logo_svg_vector,
        ),
        CarBrand(
            10,
            R.drawable.rolls_royce_logo_svg_vector,
        ),
        CarBrand(
            11,
            R.drawable.mercedes_benz_6_logo_svg_vector,
        ),
        CarBrand(
            12,
            R.drawable.chevrolet,
        ),
        CarBrand(
            id = 1,
            brandPic = R.drawable.camry_logo_svg_vector,
        ),
        CarBrand(
            id = 2,
            brandPic = R.drawable.nissan_6_logo_svg_vector),
        CarBrand(
            id = 3,
            brandPic = R.drawable.porsche_6_logo_svg_vector,
        ),
        CarBrand(
            4,
            R.drawable.toyota_logo_svg_vector,
        ),
        CarBrand(
            5,
            R.drawable.bentley_logo_svg_vector,
        ),
        CarBrand(
            id = 1,
            brandPic = R.drawable.bmw_logo2_logo_svg_vector,
        ),
        CarBrand(
            id = 2,
            brandPic = R.drawable.fiat_3_logo_svg_vector),
        CarBrand(
            id = 3,
            brandPic = R.drawable.audi_14_logo_svg_vector,
        ),
        CarBrand(
            4,
            R.drawable.ford_8_logo_svg_vector,
        ),
        CarBrand(
            5,
            R.drawable.honda_11_logo_svg_vector,
        ),
        CarBrand(
            6,
            R.drawable.infiniti_1_logo_svg_vector,
        ),
        CarBrand(
            7,
            R.drawable.jaguar_cars_logo_svg_vector,
        ),
        CarBrand(
            8,
            R.drawable.jeep_7_logo_svg_vector,
        ),
        CarBrand(
            9,
            R.drawable.lamborghini_logo_svg_vector,
        ),
        CarBrand(
            10,
            R.drawable.rolls_royce_logo_svg_vector,
        ),
        CarBrand(
            11,
            R.drawable.mercedes_benz_6_logo_svg_vector,
        ),
        CarBrand(
            12,
            R.drawable.chevrolet,
        ),
        CarBrand(
            id = 1,
            brandPic = R.drawable.camry_logo_svg_vector,
        ),
        CarBrand(
            id = 2,
            brandPic = R.drawable.nissan_6_logo_svg_vector),
        CarBrand(
            id = 3,
            brandPic = R.drawable.porsche_6_logo_svg_vector,
        ),
        CarBrand(
            4,
            R.drawable.toyota_logo_svg_vector,
        ),
        CarBrand(
            5,
            R.drawable.bentley_logo_svg_vector,
        ),
    )
    val comments: List<Comment> = listOf(
        Comment(
            profilePic = R.drawable.profile_picture,
            title = "El Bench",
            date = "June 5, 2019",
            review = "good. but I prefer Atos.",
        ),
        Comment(
            profilePic = R.drawable.profile_picture,
            title = "El Bench",
            date = "June 5, 2019",
            review = "good. but I prefer Atos.",
        ),
        Comment(
            profilePic = R.drawable.profile_picture,
            title = "El Bench",
            date = "June 5, 2019",
            review = "good. but I prefer Atos.",
        ),
        Comment(
            profilePic = R.drawable.profile_picture,
            title = "El Bench",
            date = "June 5, 2019",
            review = "good. but I prefer Atos.",
        ),
        Comment(
            profilePic = R.drawable.profile_picture,
            title = "El Bench",
            date = "June 5, 2019",
            review = "good. but I prefer Atos.",
        ),
        Comment(
            profilePic = R.drawable.profile_picture,
            title = "El Bench",
            date = "June 5, 2019",
            review = "good. but I prefer Atos.",
        )
    )
    val profileInformation: ProfileInformation = ProfileInformation(
        name = "Mohamed Zaarir",
        firstName = "Mohamed",
        picture = R.drawable.profile_picture,
        email = "zaarirmo07@gmail.com",
        location = "Soumaa Blida",
        lastName = "Zaarir",
        carsPosted = 424,
        postsSaved = 785,
        bookings = 123,
        mobileNumber = "0776325625"
    )
}