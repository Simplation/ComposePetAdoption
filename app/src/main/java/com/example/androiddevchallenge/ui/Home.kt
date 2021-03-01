package com.example.androiddevchallenge.ui

import androidx.compose.material.*
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
    PetList(pets = viewModel.pets) { pet ->
        viewModel.showPet(pet)
    }

    val pet = viewModel.currentPet
    if (pet != null) {
        PetDetail(pet = pet) {
            coroutineScope.launch {
                snackBarHostState.showSnackbar("You have adopted ${pet.name}")
            }
        }
    }
}