package com.example.displayingimages.display_images.di

import com.example.displayingimages.display_images.data.remote.DogsAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DisplayImagesModule {

    @Provides
    @Singleton
    fun provideDogsAPI(): DogsAPI =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://dog.ceo")
            .build()
            .create(DogsAPI::class.java)
}