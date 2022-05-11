package com.tana.thecat.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.tana.thecat.presentation.cats_list.CatListUiState

@Composable
fun SearchResult(
    modifier: Modifier,
    uiState: CatListUiState
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.surface)
    ) {
//        if (uiState.searchResultMessage.isNotBlank()) {
//            Text(
//                text = uiState.searchResultMessage,
//                modifier = modifier
//                    .padding(start = 16.dp, bottom = 16.dp)
//            )
//        } else {
//            LazyColumn(
//                verticalArrangement = Arrangement.spacedBy(16.dp)
//            ) {
//                items(uiState.searchResult) {
//                    it.name?.let { name ->
//                        Text(
//                            text = name,
//                            modifier = modifier
//                                .padding(start = 16.dp)
//                        )
//                    }
//                }
//            }
//            uiState.searchResult?.let { cat ->
//                cat.name?.let { name -> Text(text = name) }
//            }
        }
//    }
}