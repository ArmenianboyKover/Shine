package com.example.shine.playlist

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.random.Random

class PlaylistViewModel : ViewModel() {

    private val _playLists = MutableStateFlow<List<Playlist>>(emptyList())
    val playLists = _playLists.asStateFlow() // Инкапсуляция

    init {
        _playLists.value = getPLayLists()
    }

    private fun getPLayLists(): List<Playlist> {
        return listOf(
            Playlist(
                id = Random.nextLong(),
                title = "Recommendation",
                description = "78 Songs",
                url = "https://avatars.mds.yandex.net/i?id=5607afbea0eba753a275c1bad58b06abdab3fded-5336870-images-thumbs&n=13",
            ),
        )
    }
}