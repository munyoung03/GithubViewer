package com.example.githubviewer.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.load.engine.Resource
import com.example.githubviewer.data.api.GithubAPIService
import com.example.githubviewer.domain.usecase.GetUsersUseCase

class GithubViewModel(
    private val app: Application,
    getUsersUseCase: GetUsersUseCase
) : AndroidViewModel(app) {

    val usersLists: MutableLiveData<Resource<GithubAPIService>> = MutableLiveData()

}