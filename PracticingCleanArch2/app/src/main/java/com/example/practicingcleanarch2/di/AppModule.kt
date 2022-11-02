package com.example.practicingcleanarch2.di

import com.example.practicingcleanarch2.data.remote.DogsAPI
import com.example.practicingcleanarch2.data.repository.DogsRepositoryImp
import com.example.practicingcleanarch2.domain.repository.DogsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDogsAPI(): DogsAPI =
        Retrofit.Builder()
            .baseUrl("https://dog.ceo/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DogsAPI::class.java)

    @Provides
    @Singleton
    fun provideDefaultDogsRepository(dogsAPI: DogsAPI): DogsRepository =
        DogsRepositoryImp(dogsAPI)
}
