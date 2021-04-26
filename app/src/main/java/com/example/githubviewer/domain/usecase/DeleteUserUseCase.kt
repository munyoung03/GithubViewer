package com.example.githubviewer.domain.usecase

import com.example.githubviewer.data.model.users.UsersItem
import com.example.githubviewer.domain.repository.UsersRepository

class DeleteUserUseCase(private val usersRepository: UsersRepository) {
    suspend fun execute(usersItem: UsersItem) = usersRepository.deleteUser(usersItem)
}