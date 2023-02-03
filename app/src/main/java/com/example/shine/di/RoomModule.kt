package com.example.shine.di

import android.content.Context
import androidx.room.Room
import com.example.shine.data.database.HistoryDatabase
import com.example.shine.data.database.history.SongsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): HistoryDatabase {
        return Room.databaseBuilder(
            context,
            HistoryDatabase::class.java,
            "ROOM_DATABASE_NAME"
        ).build()
    }

    @Provides
    @Singleton
    fun provideSongsDao(database: HistoryDatabase): SongsDao {
        return database.songsDao()
    }
}