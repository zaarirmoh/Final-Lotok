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

import com.example.newlotok.model.CarPost
import com.example.newlotok.model.Category
import com.example.newlotok.model.MarsPhoto
import com.example.newlotok.model.SignIn
import com.example.newlotok.model.SignUp
import com.example.newlotok.model.Tokens
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * A public interface that exposes the [getPhotos] method
 */
interface LotokApiService {

    @GET("api/listings/")
    suspend fun getCarPosts(): List<CarPost>

    @POST("api/listings/")
    suspend fun addCarPost(
        @Body carPost: CarPost
    )

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

}
