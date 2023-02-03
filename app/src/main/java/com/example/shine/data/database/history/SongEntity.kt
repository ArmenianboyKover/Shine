package com.example.shine.data.database.history

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.shine.songs.Song

@Entity(tableName = "TABLE_RECOMMENDATIONS")
data class SongEntity(
    @PrimaryKey
    @ColumnInfo(name = "ID")
    val id: String,
    @ColumnInfo(name = "NAME")
    val name: String,
    @ColumnInfo(name = "DESCRIPTION")
    val description: String,
    @ColumnInfo(name = "IMAGE_URL")
    val imageUrl: String
)

fun List<SongEntity>.mapToPresentation(): List<Song> { // map to presentation
    return this.map {
        Song(
            id = it.id,
            name = it.name,
            description = it.description,
            imageUrl = it.imageUrl
        )
    }
}