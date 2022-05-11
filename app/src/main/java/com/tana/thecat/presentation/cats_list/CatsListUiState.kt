package com.tana.thecat.presentation.cats_list

import com.tana.thecat.data.cat_breed.model.Breed

data class CatListUiState(
    var loading: Boolean = false,
    var catsList: List<Breed> = emptyList(),
    var message: String = "",
)
