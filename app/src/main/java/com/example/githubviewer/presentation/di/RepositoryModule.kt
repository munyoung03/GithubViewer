package com.example.githubviewer.presentation.di

import com.example.githubviewer.data.repository.UsersRepositoryImpl
import com.example.githubviewer.data.repository.datasource.UserRemoteDataSource
import com.example.githubviewer.domain.repository.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideUsersRepository(
        userRemoteDataSource: UserRemoteDataSource
    ):UsersRepository{
        return UsersRepositoryImpl(userRemoteDataSource)
    }
}