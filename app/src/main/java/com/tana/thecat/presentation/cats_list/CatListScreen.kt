package com.tana.thecat.presentation.cats_list

import android.util.Log
import android.widget.Space
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.google.accompanist.systemuicontroller.SystemUiController
import com.tana.thecat.data.cat_breed.model.Breed
import com.tana.thecat.ui.SearchResult
import com.tana.thecat.ui.app_bars.MainTopAppBar
import com.tana.thecat.ui.text_fields.SearchBar
import com.tana.thecat.ui.theme.TextFieldShape
import com.tana.thecat.utils.TheCatScreens

@Composable
fun CatListScreen(
    modifier: Modifier = Modifier,
    viewModel: CatListViewModel = hiltViewModel(),
    systemUiController: SystemUiController,
    navHostController: NavHostController
) {
    systemUiController.setNavigationBarColor(MaterialTheme.colors.background)
    val uiState = viewModel.uiState.collectAsState().value
    val searchText = viewModel.searchText.collectAsState().value
    val searchBarVisible = viewModel.searchBarVisible
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(12.dp),
        contentAlignment = Alignment.Center
    ) {
        if (uiState.loading) {
            CircularProgressIndicator(
                color = MaterialTheme.colors.secondary
            )
        } else {
            if (uiState.message.isBlank()) {
                Column(
                    modifier = modifier.fillMaxSize()
                ) {
                    CatListContent(
                        modifier = modifier,
                        uiState = uiState,
                        text = searchText,
                        //onSearch = viewModel::searchBreed,
                        onSearchTextChange = viewModel::searchTextChange,
                        navHostController = navHostController
                    )
                }
            } else {
                Text(text = uiState.message)
            }
        }
    }
}

@Composable
fun CatListContent(
    modifier: Modifier,
    uiState: CatListUiState,
    text: String,
    //onSearch: (String) -> Unit,
    onSearchTextChange: (String) -> Unit,
    navHostController: NavHostController

) {
    Column() {
        Spacer(modifier = modifier.height(12.dp))
        SearchBar(
            modifier = modifier,
            text = text,
            //onSearch = onSearch,
            onSearchTextChange = onSearchTextChange
        )
        if (text.isNotBlank()) {
            Spacer(modifier = modifier.height(4.dp))
            SearchResult(modifier = modifier, uiState = uiState)
        }
        Spacer(modifier = modifier.height(24.dp))
        Text(
            text = "Find the brilliant cats to decorate your house",
            style = MaterialTheme.typography.h4
        )
        Spacer(modifier = modifier.height(16.dp))
        Cats(
            modifier = modifier,
            uiState = uiState,
            navHostController = navHostController
        )
    }
}

@Composable
fun Cats(
    modifier: Modifier,
    uiState: CatListUiState,
    navHostController: NavHostController
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(uiState.catsList) { cat ->
            CatDetails(
                modifier = modifier,
                cat = cat,
                onCatClicked = {
                    navHostController.navigate(
                        "${TheCatScreens.CatDetailsScreen.route}/${cat.id}"
                    )
                }
            )
        }
    }
}

@Composable
fun CatDetails(
    modifier: Modifier,
    cat: Breed,
    onCatClicked: () -> Unit
) {
    Column(
        modifier = modifier
            .clickable { onCatClicked() }
    ) {
        AsyncImage(
            model = cat.image?.url,
            contentDescription = cat.name,
            modifier = modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = modifier.height(12.dp))
        cat.name?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.h6
            )
        }
        Spacer(modifier = modifier.height(4.dp))
        cat.description?.let {
            Text(
                text = it,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colors.onBackground.copy(alpha = 0.3f)
            )
        }
    }
}
