package com.diegochancafe.pokedex.di

import com.diegochancafe.pokedex.data.network.IRetrofitApi
import com.diegochancafe.pokedex.util.Config
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module // -- Provide dependencies
@InstallIn(SingletonComponent::class) // -- Scopes
object NetworkModule {
    // --
    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        // --
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        // --
        val timeout = (60 * 1000)    // -- 60 segundos
        // --
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(timeout.toLong(), TimeUnit.SECONDS)
            .readTimeout(timeout.toLong(), TimeUnit.SECONDS)
            .writeTimeout(timeout.toLong(), TimeUnit.SECONDS)
            .build()
    }

    // --
    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        // --
        return Retrofit.Builder()
            .baseUrl(Config.WEBSERVICE)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // --
    @Singleton
    @Provides
    fun provideApiClient(retrofit: Retrofit): IRetrofitApi {
        // --
        return retrofit.create(IRetrofitApi::class.java)
    }
}