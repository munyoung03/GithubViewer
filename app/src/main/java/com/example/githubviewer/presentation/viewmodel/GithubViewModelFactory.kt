package com.example.githubviewer.presentation.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubviewer.domain.usecase.GetUsersUseCase

class GithubViewModelFactory(
    private val getUsersUseCase: GetUsersUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        Log.d("factory", "init factory")
        return GithubViewModel(
            getUsersUseCase
        ) as T
    }

}