package com.example.shine.songs

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.random.Random

class SongsViewModel : ViewModel() {

    private val _songs = MutableStateFlow<List<Song>>(emptyList())
    val songs = _songs.asStateFlow()

    init {
        _songs.value = getSongs()
//        viewModelScope.launch { coroutineExample() }
    }

    private suspend fun coroutineExample() {
        repeat(_songs.value.size) {
            delay(1000)
            _songs.emit(_songs.value.dropLast(1))
        }
    }

    private fun getSongs(): List<Song> {
        return listOf(
            Song(
                id = Random.nextLong().toString(),
                name = "vasya",
                imageUrl = "https://incrussia.ru/upload/resized/572c151849d7cadfd7cbccb840a84c4a.jpg"
            ),
        )
    }
}