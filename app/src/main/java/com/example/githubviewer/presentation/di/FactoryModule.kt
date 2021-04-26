package com.example.githubviewer.presentation.di

import android.app.Application
import com.example.githubviewer.domain.usecase.*
import com.example.githubviewer.presentation.viewmodel.GithubViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class FactoryModule {

    @Singleton
    @Provides
    fun provideGithubViewModelFactory(
        getUsersUseCase: GetUsersUseCase,
        getSearchUseCase: GetSearchUseCase,
        getUserUseCase: GetUserUseCase,
        saveUserUseCase: SaveUserUseCase,
        deleteUserUseCase: DeleteUserUseCase
    ):GithubViewModelFactory{
      return GithubViewModelFactory(
          getUsersUseCase,
          getSearchUseCase,
          getUserUseCase,
          saveUserUseCase,
          deleteUserUseCase
      )
    }
}