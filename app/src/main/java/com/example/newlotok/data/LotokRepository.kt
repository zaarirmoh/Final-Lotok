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

import com.example.newlotok.model.CarPost
import com.example.newlotok.model.Category
import com.example.newlotok.model.MarsPhoto
import com.example.newlotok.network.LotokApiService

/**
 * Repository that fetch mars photos list from marsApi.
 */
interface LotokRepository {
    /** Fetches list of MarsPhoto from marsApi */

    suspend fun getCarPosts(): List<CarPost>

    suspend fun getCategories(): List<Category>

    suspend fun addCarPost(carPost: CarPost)

}

/**
 * Network Implementation of Repository that fetch mars photos list from marsApi.
 */
class NetworkLotokRepository(
    private val lotokApiService: LotokApiService
) : LotokRepository {
    /** Fetches list of MarsPhoto from marsApi*/

    override suspend fun getCarPosts(): List<CarPost> = lotokApiService.getCarPosts()

    override suspend fun getCategories(): List<Category> = lotokApiService.getCategories()

    override suspend fun addCarPost(carPost: CarPost) = lotokApiService.addCarPost(carPost)

}
