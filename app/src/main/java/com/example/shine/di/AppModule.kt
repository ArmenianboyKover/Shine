package com.example.shine.di

import com.example.shine.playlist_details.ShazamApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://shazam.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideShazamApi(retrofit: Retrofit): ShazamApi {
        return retrofit.create(ShazamApi::class.java)
    }
}