package com.example.githubviewer.presentation.di

import com.example.githubviewer.data.api.GithubAPIService
import com.example.githubviewer.data.repository.datasource.UserRemoteDataSource
import com.example.githubviewer.data.repository.datasourceImpl.UserRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideUsersRemoteDataSource(
        githubAPIService: GithubAPIService
    ):UserRemoteDataSource{
        return UserRemoteDataSourceImpl(githubAPIService)
    }
}