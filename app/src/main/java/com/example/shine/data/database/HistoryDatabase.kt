package com.example.shine.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.shine.data.database.history.SongEntity
import com.example.shine.data.database.history.SongsDao

@Database(entities = [SongEntity::class], version = 1)
abstract class HistoryDatabase : RoomDatabase() {
    abstract fun songsDao(): SongsDao
}