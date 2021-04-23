package com.example.githubviewer.domain.usecase

import com.example.githubviewer.domain.repository.UsersRepository

class GetUsersUseCase(private val usersRepository: UsersRepository) {
    suspend fun execute()= usersRepository.getUsers()
}