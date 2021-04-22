package com.example.githubviewer.domain.usecase

import com.example.githubviewer.data.model.Users
import com.example.githubviewer.domain.repository.UsersRepository

class GetUsersUseCase(private val usersRepository: UsersRepository) {
    suspend fun execute()= usersRepository.getUsers()
}