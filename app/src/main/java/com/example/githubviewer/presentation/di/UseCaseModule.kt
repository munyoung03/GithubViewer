package com.example.githubviewer.presentation.di

import com.example.githubviewer.domain.repository.UsersRepository
import com.example.githubviewer.domain.usecase.*
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

    @Provides
    @Singleton
    fun provideGetUserUseCase(
        usersRepository: UsersRepository
    ):GetUserUseCase{
        return GetUserUseCase(usersRepository)
    }

    @Provides
    @Singleton
    fun provideSaveUserUseCase(
        usersRepository: UsersRepository
    ):SaveUserUseCase{
        return SaveUserUseCase(usersRepository)
    }

    @Provides
    @Singleton
    fun provideDeleteUserUseCase(
        usersRepository: UsersRepository
    ):DeleteUserUseCase{
        return DeleteUserUseCase(usersRepository)
    }
}