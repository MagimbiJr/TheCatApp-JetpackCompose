package com.tana.thecat.presentation.cat_details

import com.tana.thecat.data.cat_breed.model.Breed

data class CatDetailsUiState(
    val loading: Boolean = false,
    val breed: Breed? = null,
    val message: String = ""
)
