package com.example.githubviewer.presentation.di

import android.app.Application
import com.example.githubviewer.domain.usecase.GetSearchUseCase
import com.example.githubviewer.domain.usecase.GetUsersUseCase
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
        getSearchUseCase: GetSearchUseCase
    ):GithubViewModelFactory{
      return GithubViewModelFactory(
          getUsersUseCase,
          getSearchUseCase
      )
    }
}