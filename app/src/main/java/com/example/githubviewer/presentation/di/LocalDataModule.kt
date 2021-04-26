package com.example.githubviewer.presentation.di

import com.example.githubviewer.data.db.UserDAO
import com.example.githubviewer.data.repository.datasource.UserLocalDataSource
import com.example.githubviewer.data.repository.datasourceImpl.UserLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Singleton
    @Provides
    fun provideLocalDataSource(userDAO: UserDAO):UserLocalDataSource{
        return UserLocalDataSourceImpl(userDAO)
    }
}