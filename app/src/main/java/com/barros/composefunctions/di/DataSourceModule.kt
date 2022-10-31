package com.barros.composefunctions.di

import com.barros.composefunctions.data.datasource.LocalDataSource
import com.barros.composefunctions.data.datasource.LocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal class DataSourceModule {

    @Provides
    @Singleton
    fun provideLocalDataSource(localDataSource: LocalDataSourceImpl): LocalDataSource =
        localDataSource

}