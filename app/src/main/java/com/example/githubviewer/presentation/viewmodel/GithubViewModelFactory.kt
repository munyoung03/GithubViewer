package com.example.githubviewer.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubviewer.domain.usecase.GetUsersUseCase

class GithubViewModelFactory(
    private val app:Application,
    private val getUsersUseCase: GetUsersUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GithubViewModel(
            app,
            getUsersUseCase,
        ) as T
    }

}