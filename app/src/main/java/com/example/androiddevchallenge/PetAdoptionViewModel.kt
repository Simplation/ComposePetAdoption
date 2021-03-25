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
package com.example.androiddevchallenge

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.Pet

class PetAdoptionViewModel : ViewModel() {
    val pets by mutableStateOf(
        listOf(
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
            ),
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
            ),
            Pet(
                "Eevee",
                "General",
                "Escape/Adaptability",
                "Evolution Pokémon",
                "Male",
                R.drawable.ic_eevee
            ),
            Pet(
                "Vulpix",
                "Fire",
                "Characteristics",
                "Fox Pokémon",
                "Female",
                R.drawable.ic_vulpix
            ),
            Pet(
                "Dedenne",
                "Electric / Fairy",
                "Cheek pouch / pick up",
                "Antenna Pokémon",
                "Male",
                R.drawable.ic_dedenne
            ),
            Pet(
                "Axew",
                "Long",
                "Struggle / Out of Style",
                "Tooth Pokémon",
                "Male",
                R.drawable.ic_axew
            ),
            Pet(
                "Shaymin",
                "Grass",
                "Natural recovery",
                "Thanks Pokémon",
                "Female",
                R.drawable.ic_shaymin
            ),
        )
    )

    var currentPet: Pet? by mutableStateOf(null)

    fun showPet(pet: Pet) {
        currentPet = pet
    }

    fun closePet() {
        currentPet = null
    }
}
