package com.diegochancafe.pokedex.di

import android.content.Context
import androidx.room.Room
import com.diegochancafe.pokedex.data.database.AppDatabase
import com.diegochancafe.pokedex.data.model.singleton.PokemonSingleton
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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