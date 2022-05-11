package com.tana.thecat.ui.text_fields

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.tana.thecat.ui.theme.Shapes
import com.tana.thecat.ui.theme.TextFieldShape

@Composable
fun SearchBar(
    modifier: Modifier,
    //onSearch: (String) -> Unit,
    onSearchTextChange: (String) -> Unit,
    text: String,
) {
    val searchTextFieldColors = TextFieldDefaults.outlinedTextFieldColors(
        backgroundColor = MaterialTheme.colors.surface,
        cursorColor = MaterialTheme.colors.onBackground,
        focusedBorderColor = Color.Transparent,
        unfocusedBorderColor = Color.Transparent
    )
    OutlinedTextField(
        value = text,
        onValueChange = {
            onSearchTextChange(it)
            //onSearch(it)
        },
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = if (text.isNotBlank()) Shapes.large else TextFieldShape,
        leadingIcon = { Icon(imageVector = Icons.Filled.Search, contentDescription = "Search icon") },
        placeholder = { Text(text = "Search") },
        colors = searchTextFieldColors,
    )
//    if (text.isNotBlank()) {
//        onSearch(text)
//    }
}