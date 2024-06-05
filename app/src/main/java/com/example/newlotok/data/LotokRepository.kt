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
package com.example.newlotok.data

import com.example.newlotok.model.AccessToken
import com.example.newlotok.model.CarPost
import com.example.newlotok.model.Category
import com.example.newlotok.model.MarsPhoto
import com.example.newlotok.model.ProfileInformation
import com.example.newlotok.model.SignIn
import com.example.newlotok.model.SignUp
import com.example.newlotok.model.Tokens
import com.example.newlotok.model.VinResult
import com.example.newlotok.network.LotokApiService

/**
 * Repository that fetch mars photos list from marsApi.
 */
interface LotokRepository {
    /** Fetches list of MarsPhoto from marsApi */

    suspend fun getCarPosts(
        make: String? = null,
        year: Int? = null
    ): List<CarPost>

    suspend fun getCategories(): List<Category>

    suspend fun addCarPost(authorization: String, carPost: CarPost): CarPost

    suspend fun signIn(signInInformation: SignIn): Tokens

    suspend fun signUp(signUpInformation: SignUp)

    suspend fun verifyToken(accessToken: AccessToken)

    suspend fun getProfileInformation(authorization: String): ProfileInformation

    suspend fun getVinDetails(vin : String ) : VinResult

}

/**
 * Network Implementation of Repository that fetch mars photos list from marsApi.
 */
class NetworkLotokRepository(
    private val lotokApiService: LotokApiService
) : LotokRepository {
    /** Fetches list of MarsPhoto from marsApi*/

    //override suspend fun getCarPosts(): List<CarPost> = lotokApiService.getCarPosts()
    override suspend fun getCarPosts(
        make: String?,
        year: Int?
    ): List<CarPost> = lotokApiService.getCarPosts(
        make = make,
        year = year
    )

    override suspend fun getCategories(): List<Category> = lotokApiService.getCategories()

    //override suspend fun addCarPost(carPost: CarPost,authorization: String): CarPost = lotokApiService.addCarPost(authorization = authorization, carPost = carPost)

    override suspend fun signIn(signInInformation: SignIn) = lotokApiService.signIn(signInInformation)

    override suspend fun signUp(signUpInformation: SignUp) = lotokApiService.signUp(signUpInformation)

    override suspend fun verifyToken(accessToken: AccessToken) = lotokApiService.verifyToken(accessToken)

    override suspend fun getProfileInformation(authorization: String): ProfileInformation = lotokApiService.getProfileInformation(authorization)

    override suspend fun getVinDetails(vin: String) = lotokApiService.getVinDetails(vin)

    override suspend fun addCarPost(authorization: String, carPost: CarPost): CarPost = lotokApiService.addCarPost(authorization = authorization, carPost = carPost)



}
