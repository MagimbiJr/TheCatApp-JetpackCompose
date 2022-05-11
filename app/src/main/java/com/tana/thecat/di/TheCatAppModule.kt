package com.tana.thecat.di

import com.tana.thecat.data.remote.TheCatApi
import com.tana.thecat.repository.TheCatRepository
import com.tana.thecat.repository.TheCatRepositoryImpl
import com.tana.thecat.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object TheCatAppModule {

    @Provides
    @Singleton
    fun provideTheCatApi(): TheCatApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(TheCatApi::class.java)
    }

    @Provides
    @Singleton
    fun provideTheCatRepository(theCatApi: TheCatApi): TheCatRepository =
        TheCatRepositoryImpl(theCatApi = theCatApi)
}