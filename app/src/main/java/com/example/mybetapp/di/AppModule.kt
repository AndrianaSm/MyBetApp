package com.example.mybetapp.di

import com.example.mybetapp.data.remote.SportApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSprotsApi(): SportApi {
        return Retrofit.Builder()
            .baseUrl("https://618d3aa7fe09aa001744060a.mockapi.io/api/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }
}