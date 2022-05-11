package com.tana.thecat.presentation.cat_details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CatDetailsScreen(
    modifier: Modifier = Modifier,
    viewModel: CatDetailsViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsState().value

    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (uiState.loading) {
            CircularProgressIndicator()
        } else {
            uiState.breed?.let { cat ->
                Column() {
                    cat.name?.let { name ->
                        Text(text = name)
                    }
                }
            }
        }
    }
}