/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.newlotok.network

import com.example.newlotok.model.AccessToken
import com.example.newlotok.model.CarPost
import com.example.newlotok.model.Category
import com.example.newlotok.model.MarsPhoto
import com.example.newlotok.model.OrderDetails
import com.example.newlotok.model.OrderDetailsPost
import com.example.newlotok.model.ProfileInformation
import com.example.newlotok.model.SignIn
import com.example.newlotok.model.SignUp
import com.example.newlotok.model.Tokens
import com.example.newlotok.model.VinResult
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * A public interface that exposes the [getPhotos] method
 */
interface LotokApiService {

    @GET("api/listings/")
    suspend fun getCarPosts(
        @Query(value = "make")
        make: String? = null,
        @Query(value = "year")
        year: Int? = null,
        @Query(value = "user")
        user: Int? = null,
        @Query(value = "wilaya")
        location: Int? = null,
        @Query(value = "category")
        category: Int? = null
    ): List<CarPost>

    @POST("api/listings/")
    suspend fun addCarPost(
        @Header(value = "Authorization")
        authorization: String,
        @Body carPost: CarPost
    ): CarPost

    @POST("api/jwt/create")
    suspend fun signIn(
        @Body
        signInInformation: SignIn,
    ): Tokens

    @POST("api/users/")
    suspend fun signUp(
        @Body
        signUpInformation: SignUp
    )


    @GET("api/categorys/")
    suspend fun getCategories(): List<Category>

    @POST("api/jwt/verify")
    suspend fun verifyToken(
        @Body
        accessToken: AccessToken
    )
    // "Bearer access"
    @GET("api/users/me/")
    suspend fun getProfileInformation(
        @Header(value = "Authorization")
        authorization: String
    ): ProfileInformation


    @GET("api/vin/")
    suspend fun getVinDetails(
        @Query(value = "vin")
        vin : String
    ):VinResult

    @POST("api/orders/create/")
    suspend fun postBooking(
        @Body
        orderDetails: OrderDetailsPost
    )


}
