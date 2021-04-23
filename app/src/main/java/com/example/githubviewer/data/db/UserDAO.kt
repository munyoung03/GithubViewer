package com.example.githubviewer.data.db

import androidx.room.*
import com.example.githubviewer.data.model.users.UsersItem
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(usersItem: UsersItem)

    @Query("SELECT * FROM user")
    fun getUsers() : Flow<List<UsersItem>>

    @Delete
    suspend fun deleteUser(usersItem: UsersItem)
}