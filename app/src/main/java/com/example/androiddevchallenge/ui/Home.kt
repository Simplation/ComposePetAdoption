/*
 * Copyright 2021 The Android Open Source Project
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
package com.example.androiddevchallenge.ui

import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.PetAdoptionViewModel
import com.example.androiddevchallenge.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun Home() {
    val snackBarHostState = SnackbarHostState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_title))
                }
            )
        },
        snackbarHost = { SnackbarHost(snackBarHostState) }
    ) {
        BodyContent(coroutineScope, snackBarHostState)
    }
}

@Composable
fun BodyContent(
    coroutineScope: CoroutineScope,
    snackBarHostState: SnackbarHostState
) {
    val viewModel: PetAdoptionViewModel = viewModel()
    val currentPet = viewModel.currentPet
    PetList(pets = viewModel.pets) { pet ->
        if (currentPet == null) {
            viewModel.showPet(pet)
        }
    }

    if (currentPet != null) {
        PetDetail(pet = currentPet) {
            coroutineScope.launch {
                snackBarHostState.showSnackbar("You have adopted ${currentPet.name}")
            }
        }
    }
}
