package com.tana.thecat.ui.app_bars

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.ui.unit.dp

@Composable
fun MainTopAppBar(
    text: String,
    searchBarVisible: MutableState<Boolean>
) {
    TopAppBar(
        title = { Text(text = "TheCat") },
        actions = {
            IconButton(onClick = { searchBarVisible.value = true }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "SearchIcon")
            }
        },
        backgroundColor = MaterialTheme.colors.primary,
        elevation = if (text.isBlank()) 5.dp else 0.dp
    )
}