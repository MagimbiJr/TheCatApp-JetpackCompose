package com.tana.thecat.repository

import com.tana.thecat.data.cat_breed.model.Breed
import com.tana.thecat.utils.Resource
import kotlinx.coroutines.flow.Flow

interface TheCatRepository {

    fun getCatBreeds(): Flow<Resource<List<Breed>>>

    //fun searchBreeds(breedId: String): Flow<Resource<List<Breed>>>

    fun searchBreed(breedId: String): Flow<Resource<List<Breed>>>
}