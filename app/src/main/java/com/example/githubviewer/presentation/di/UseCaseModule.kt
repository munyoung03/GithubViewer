package com.example.githubviewer.presentation.di

import com.example.githubviewer.domain.repository.UsersRepository
import com.example.githubviewer.domain.usecase.GetSearchUseCase
import com.example.githubviewer.domain.usecase.GetUsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetUsersUseCase(
        usersRepository: UsersRepository
    ):GetUsersUseCase{
        return GetUsersUseCase(usersRepository)
    }

    @Provides
    @Singleton
    fun provideGetSearchUseCase(
        usersRepository: UsersRepository
    ):GetSearchUseCase{
        return GetSearchUseCase(usersRepository)
    }
}