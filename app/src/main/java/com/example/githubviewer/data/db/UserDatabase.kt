package com.example.githubviewer.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.githubviewer.data.model.users.UsersItem


@Database(
    entities = [UsersItem::class],
    version = 1,
    exportSchema = false
)

abstract class UserDatabase: RoomDatabase(){
    abstract fun getUserDAO():UserDAO
}