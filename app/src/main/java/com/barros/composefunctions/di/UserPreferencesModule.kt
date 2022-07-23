package com.barros.composefunctions.di

import com.barros.composefunctions.data.UserPreferencesRepositoryImpl
import com.barros.composefunctions.domain.repositories.UserPreferencesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UserPreferencesModule {

    @Provides
    @Singleton
    fun provideUserPreferencesRepository(repository: UserPreferencesRepositoryImpl): UserPreferencesRepository {
        return repository
    }

}