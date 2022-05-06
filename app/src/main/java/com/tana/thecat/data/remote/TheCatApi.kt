package com.tana.thecat.data.remote

import com.tana.thecat.data.cat_breed.BreedDto
import com.tana.thecat.data.cat_breed.model.CatBreeds
import com.tana.thecat.utils.Constants.API_KEY
import com.tana.thecat.utils.Resource
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface TheCatApi {

    @GET("/v1/breeds")
    @Headers(API_KEY)
    suspend fun getCatBreeds(): CatBreeds

    @GET("/v1/images/search?breed_ids={breed-id}")
    suspend fun getBreed(
        @Query("breed_id") breedId: String
    ): BreedDto

}