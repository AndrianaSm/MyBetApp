package com.example.mybetapp.di

import com.example.mybetapp.data.repository.SportsRepositoryImpl
import com.example.mybetapp.domain.repository.SportsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindSportsRepository(
        sportsRepositoryImpl: SportsRepositoryImpl
    ): SportsRepository
}