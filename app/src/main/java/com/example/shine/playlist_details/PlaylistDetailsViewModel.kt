package com.example.shine.playlist_details

import androidx.lifecycle.ViewModel
import com.example.shine.songs.Song
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.random.Random

class PlaylistDetailsViewModel : ViewModel() {

    private val _songs = MutableStateFlow<List<Song>>(emptyList())
    val songs = _songs.asStateFlow()

    init {
        _songs.value = getSongs()
    }

    private fun getSongs(): List<Song> {
        return listOf(
            Song(
                id = Random.nextLong(),
                song = "vasya",
                playlist = "leha",
                image = "https://incrussia.ru/upload/resized/572c151849d7cadfd7cbccb840a84c4a.jpg"
            ),
            Song(
                id = Random.nextLong(),
                song = "Leha",
                playlist = "arbsuz",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlthFAPI9r1bCPSHXz3Cz0dCvMGtdgypv18Q&usqp=CAU"
            ),
            Song(
                id = Random.nextLong(),
                song = "Leha",
                playlist = "arbsuz",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlthFAPI9r1bCPSHXz3Cz0dCvMGtdgypv18Q&usqp=CAU"
            ),
            Song(
                id = Random.nextLong(),
                song = "Leha",
                playlist = "arbssduz",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlthFAPI9r1bCPSHXz3Cz0dCvMGtdgypv18Q&usqp=CAU"
            ),
            Song(
                id = Random.nextLong(),
                song = "Lesdha",
                playlist = "arsdsbsuz",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlthFAPI9r1bCPSHXz3Cz0dCvMGtdgypv18Q&usqp=CAU"
            ),
            Song(
                id = Random.nextLong(),
                song = "Lesdsha",
                playlist = "arbsdsdsuz",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlthFAPI9r1bCPSHXz3Cz0dCvMGtdgypv18Q&usqp=CAU"
            ),
        )
    }
}