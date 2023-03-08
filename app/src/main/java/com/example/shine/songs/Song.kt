package com.example.shine.songs

import com.example.shine.data.database.history.SongEntity

data class Song(
    val id: String,
    val name: String,
    val description: String,
    val imageUrl: String,
    val trackLink: String,
    val isDownloading: Boolean = false,
)

fun List<Song>.mapToEntity(): List<SongEntity> {
    return this.map {
        SongEntity(
            id = it.id,
            description = it.description,
            name = it.name,
            imageUrl = it.imageUrl,
            trackLink = it.trackLink,
        )
    }
}