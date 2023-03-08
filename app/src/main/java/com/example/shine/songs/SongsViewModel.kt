package com.example.shine.songs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shine.data.HistoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class SongsViewModel @Inject constructor(
    private val historyRepository: HistoryRepository,
) : ViewModel() {

    private val _songs = MutableStateFlow<List<Song>>(emptyList())
    val songs = _songs.asStateFlow()

    init {
        _songs.value = getSongs()
    }

    private fun getSongs(): List<Song> {
        return listOf(
            Song(
                id = Random.nextLong().toString(),
                name = "vasya",
                imageUrl = "https://incrussia.ru/upload/resized/572c151849d7cadfd7cbccb840a84c4a.jpg",
                description = "AWEKLAWELAW",
                trackLink = "vwd",
                isDownloading = false,
            )
        )
    }

    fun onSongClicked(song: Song) {
        _songs.value = _songs.value.map {
            if (it.id == song.id) {
                it.copy(isDownloading = it.isDownloading.not())
            } else {
                it
            }
        }
        viewModelScope.launch(Dispatchers.IO) {
            val file = historyRepository.downloadSong(song)
        }
    }
}