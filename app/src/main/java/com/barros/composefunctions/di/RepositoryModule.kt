package com.barros.composefunctions.di

import com.barros.composefunctions.data.repository.UserPreferencesRepositoryImpl
import com.barros.composefunctions.domain.repository.UserPreferencesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal class RepositoryModule {

    @Provides
    @Singleton
    fun provideUserPreferencesRepository(repository: UserPreferencesRepositoryImpl): UserPreferencesRepository =
        repository

}