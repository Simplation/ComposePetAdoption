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

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Pet

@Composable
fun PetDetail(pet: Pet, onAdoption: (Pet) -> Unit = {}) {
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Box {
            Image(
                painter = painterResource(pet.image),
                contentDescription = "Pet img: ${pet.name}",
                modifier = Modifier.aspectRatio(1f),
                contentScale = ContentScale.Crop
            )

            Button(
                onClick = { onAdoption(pet) },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Text(text = "Adoption")
            }
        }

        Column(Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
            Text(text = pet.name, style = MaterialTheme.typography.h3)
            ProvideTextStyle(value = MaterialTheme.typography.h5) {
                Text("Attributes: ${pet.attributes}")
                Text("Feature: ${pet.feature}")
                Text("Category: ${pet.category}")
                Text("Gender: ${pet.gender}")
            }
        }
    }
}

@Preview
@Composable
fun PetDetailPreview() {
    PetDetail(
        Pet(
            "Pikachu",
            "Electricity",
            "Static electricity",
            "Mouse Pokémon",
            "Female",
            R.drawable.ic_pikachu
        )
    )
}
