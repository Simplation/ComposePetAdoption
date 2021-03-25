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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Pet
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun PetList(pets: List<Pet>, onPetClick: (Pet) -> Unit = {}) {
    LazyColumn(
        modifier = Modifier.background(MaterialTheme.colors.secondary),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(pets) { pet ->
            PetItem(
                pet,
                Modifier
                    .clickable { onPetClick(pet) }
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun PetItem(pet: Pet, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Row {
            Image(
                painter = painterResource(pet.image),
                contentDescription = "Image of Pet: ${pet.name}",
                modifier = Modifier.size(120.dp),
                contentScale = ContentScale.Crop
            )
            Column(Modifier.padding(8.dp)) {
                Text(
                    text = pet.name,
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(text = pet.gender, modifier = Modifier.padding(bottom = 8.dp))
                Text(text = pet.category, modifier = Modifier.padding(bottom = 8.dp))
            }
        }
    }
}

@Preview
@Composable
fun PetListPreview() {
    val pets = listOf(
        Pet(
            "Pikachu",
            "Electricity",
            "Static electricity",
            "Mouse Pokémon",
            "Female",
            R.drawable.ic_pikachu
        ),
        Pet(
            "Squirtle",
            "Water",
            "Torrent",
            "Little Turtle Pokémon",
            "Female",
            R.drawable.ic_squirtle
        ),
        Pet(
            "Charizard",
            "Fire / flight",
            "Fierce fire",
            "Fire Pokémon",
            "Male",
            R.drawable.ic_charizard
        )
    )
    MyTheme {
        PetList(pets = pets)
    }
}

@Preview
@Composable
fun PetListPreviewDark() {
    val pets = listOf(
        Pet(
            "Togepi",
            "Goblin",
            "Vitality / Heavenly Grace",
            "Pinball Pokémon",
            "Male",
            R.drawable.ic_togepi
        ),
        Pet(
            "Ambipom",
            "General",
            "Technical master / picking up",
            "Long Tail Pokémon",
            "Female",
            R.drawable.ic_ambipom
        ),
        Pet(
            "Croagunk",
            "Drug Fight",
            "Risk prediction / dry skin",
            "Poison Strike Pokémon",
            "Male",
            R.drawable.ic_croagunk
        )
    )

    MyTheme(darkTheme = true) {
        PetList(pets = pets)
    }
}

@Preview
@Composable
fun PetItemPreview() {
    MyTheme {
        PetItem(
            pet = Pet(
                "Dedenne",
                "Electric / Fairy",
                "Cheek pouch / pick up",
                "Antenna Pokémon",
                "Male",
                R.drawable.ic_dedenne
            )
        )
    }
}

@Preview
@Composable
fun PetItemPreviewDark() {
    MyTheme(darkTheme = true) {
        PetItem(
            pet = Pet(
                "Pikachu",
                "Electricity",
                "Static electricity",
                "Mouse Pokémon",
                "Female",
                R.drawable.ic_pikachu
            )
        )
    }
}
