package com.example.shine.songs

import com.example.shine.data.database.SongEntity

data class Song(
    val id: String,
    val name: String,
    val description: String,
    val imageUrl: String,
    val trackLink: String,
    var songState: SongState
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

enum class SongState {
    IS_PLAYING,
    IS_DOWNLOADING,
    IS_PAUSE,
    IS_READY_TO_PLAY,
}