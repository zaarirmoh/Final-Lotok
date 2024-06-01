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

@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.newlotok.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import com.example.newlotok.ui.navigation.LotokNavHost

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LotokApp(
    startDestination: String,
    onWelcomeScreenButtonClicked: () -> Unit = {}
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    //TryPost()

    LotokNavHost(
        scrollBehavior = scrollBehavior,
        startDestination = startDestination,
        onWelcomeScreenButtonClicked = onWelcomeScreenButtonClicked
    )
}
