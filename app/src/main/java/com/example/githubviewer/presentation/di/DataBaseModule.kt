package com.example.githubviewer.presentation.di

import android.app.Application
import androidx.room.Room
import com.example.githubviewer.data.db.UserDAO
import com.example.githubviewer.data.db.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Singleton
    @Provides
    fun provideNewsDatabase(app: Application):UserDatabase{
        return Room.databaseBuilder(app,UserDatabase::class.java,"news_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsDao(userDatabase: UserDatabase):UserDAO{
        return userDatabase.getUserDAO()
    }
}