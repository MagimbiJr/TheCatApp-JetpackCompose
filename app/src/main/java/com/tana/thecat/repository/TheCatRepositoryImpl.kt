package com.tana.thecat.repository

import com.tana.thecat.data.cat_breed.model.Breed
import com.tana.thecat.data.cat_breed.toBreed
import com.tana.thecat.data.remote.TheCatApi
import com.tana.thecat.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class TheCatRepositoryImpl @Inject constructor(
    private val theCatApi: TheCatApi
) : TheCatRepository {

    override fun getCatBreeds(): Flow<Resource<List<Breed>>> = flow {
        try {
            emit(Resource.Loading())
            val breeds = theCatApi.getCatBreeds().map { it.toBreed() }
            emit(Resource.Success(breeds))
        } catch (e: Exception) {
            emit(Resource.Failure(e.localizedMessage ?: "An unknown error occurred"))
        } catch (e: HttpException) {
            emit(Resource.Failure(e.localizedMessage ?: "An unknown http error occurred"))
        }
    }

//    override fun searchBreed(breedId: String): Flow<Resource<Breed>> = flow {
//        try {
//            val breed = theCatApi.searchBreed(breedId = breedId).toBreed()
//            emit(Resource.Success(breed))
//        } catch (e: Exception) {
//            emit(Resource.Failure(e.localizedMessage ?: "An unknown error occurred"))
//        } catch (e: HttpException) {
//            emit(Resource.Failure(e.localizedMessage ?: "An unknown http error occurred"))
//        }
//    }

    override fun searchBreed(breedId: String): Flow<Resource<List<Breed>>> = flow {
        try {
            val breeds = theCatApi.searchBreed(breedId = breedId).map { it.toBreed() }
            emit(Resource.Success(breeds))
        } catch (e: Exception) {
            emit(Resource.Failure(e.localizedMessage ?: "An unknown error occurred"))
        } catch (e: HttpException) {
            emit(Resource.Failure(e.localizedMessage ?: "An unknown http error occurred"))
        }
    }

}