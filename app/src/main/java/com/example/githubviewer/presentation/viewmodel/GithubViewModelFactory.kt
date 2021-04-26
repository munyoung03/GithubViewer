package com.example.githubviewer.presentation.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubviewer.domain.usecase.*

class GithubViewModelFactory(
    private val getUsersUseCase: GetUsersUseCase,
    private val getSearchUseCase: GetSearchUseCase,
    private val getUserUseCase: GetUserUseCase,
    private val saveUserUseCase: SaveUserUseCase,
    private val deleteUserUseCase: DeleteUserUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        Log.d("factory", "init factory")
        return GithubViewModel(
            getUsersUseCase,
            getSearchUseCase,
            getUserUseCase,
            saveUserUseCase,
            deleteUserUseCase
        ) as T
    }

}