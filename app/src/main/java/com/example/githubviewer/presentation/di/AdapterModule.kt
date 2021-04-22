package com.example.githubviewer.presentation.di

import com.example.githubviewer.presentation.adapter.GitAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AdapterModule {

    @Provides
    @Singleton
    fun provideGitAdapter() : GitAdapter{
        return GitAdapter()
    }
}