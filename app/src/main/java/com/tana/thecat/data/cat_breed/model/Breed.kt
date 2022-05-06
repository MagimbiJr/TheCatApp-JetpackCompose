package com.tana.thecat.data.cat_breed.model

import com.tana.thecat.data.cat_breed.Image

data class Breed(
    val id: String,
    val name: String,
    val image: Image,
    val origin: String,
    val description: String,
    val countryCode: String,
)
