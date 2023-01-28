package com.diegochancafe.pokedex.di

import com.diegochancafe.pokedex.data.model.singleton.PokemonSingleton
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module // -- Provide dependencies
@InstallIn(SingletonComponent::class)
object PokemonModule {
    // --
    @Singleton
    @Provides
    fun providePokemonSingleton() = PokemonSingleton

}