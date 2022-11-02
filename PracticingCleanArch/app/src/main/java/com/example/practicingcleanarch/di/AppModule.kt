package com.example.practicingcleanarch.di

import com.example.practicingcleanarch.data.data_source.remote.DogsAPI
import com.example.practicingcleanarch.data.repository.DogRepositoryImp
import com.example.practicingcleanarch.domain.repository.DogRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideInterceptor(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun provideDogsAPI(client: OkHttpClient): DogsAPI =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://dog.ceo/")
            .client(client)
            .build()
            .create(DogsAPI::class.java)

    @Provides
    @Singleton
    fun provideDefaultDogRepository(
        dogsAPI: DogsAPI
    ) = DogRepositoryImp(dogsAPI) as DogRepository
}