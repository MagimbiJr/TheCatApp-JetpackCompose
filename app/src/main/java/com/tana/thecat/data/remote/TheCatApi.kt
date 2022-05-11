package com.tana.thecat.data.remote

import com.tana.thecat.data.cat_breed.BreedDto
import com.tana.thecat.data.cat_breed.model.CatBreeds
import com.tana.thecat.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface TheCatApi {

    @GET("/v1/breeds")
    @Headers("x-api-key: $API_KEY")
    suspend fun getCatBreeds(): List<BreedDto>

//    @GET("/v1/images/search?breed_ids")
//    @Headers("x-api-key: $API_KEY")
//    suspend fun searchBreed(
//        @Query("breed_id") breedId: String
//    ): List<BreedDto>

    @GET("/v1/breeds/search?breed_id")
    @Headers("x-api-key: $API_KEY")
    suspend fun searchBreed(
        @Query("breed_id") breedId: String
    ): List<BreedDto>

}