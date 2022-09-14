package com.eerick.doggosmvvm.di

import android.content.Context
import com.eerick.doggosmvvm.domain.data.network.ConnectivityInterceptor
import com.eerick.doggosmvvm.domain.data.network.DogApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofit(@ApplicationContext context: Context) : Retrofit =
        Retrofit.Builder()
            .baseUrl("https://jsonblob.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().addInterceptor(ConnectivityInterceptor(context)).build())
            .build()

    @Singleton
    @Provides
    fun provideDogApiClient(retrofit: Retrofit): DogApiClient =
        retrofit.create(DogApiClient::class.java)
}