package com.eerick.pokedex.di

import com.eerick.pokedex.data.remote.PokeApi
import com.eerick.pokedex.repository.PokemonRepository
import com.eerick.pokedex.util.Constants.BASE_URL
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
    fun providePokemonRepository(
        api: PokeApi
    ) : PokemonRepository = PokemonRepository(api)

    @Provides
    @Singleton
    fun providePokemonApi() : PokeApi =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PokeApi::class.java)
}