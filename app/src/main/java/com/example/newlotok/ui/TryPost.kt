package com.example.newlotok.ui

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TryPost(){
    val tryScreenViewModel: TryScreenViewModel =
        viewModel(factory = TryScreenViewModel.Factory)
    Button(onClick = {
        tryScreenViewModel.addCarPost()
    }) {
        Text(text = "post Car")
    }

}