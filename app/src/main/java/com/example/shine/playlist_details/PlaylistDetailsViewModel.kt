package com.example.shine.playlist_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shine.Constants.RECOMMENDATION_PLAYLIST_ID
import com.example.shine.data.HistoryRepository
import com.example.shine.songs.Song
import com.example.shine.songs.SongsViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.security.PrivateKey
import javax.inject.Inject

@HiltViewModel
class PlaylistDetailsViewModel @Inject constructor(
    private val historyRepository: HistoryRepository,
) : ViewModel() {

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    private val _songs = MutableStateFlow<List<Song>>(emptyList())
    val songs = _songs.asStateFlow()

    fun getSongs(playlistId: Long) {
        if (playlistId == RECOMMENDATION_PLAYLIST_ID) {
            getRecommendations()
        }
    }

    private fun getRecommendations() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = historyRepository.getSong()
            _songs.value = result
        }
        _isLoading.value = false
    }

    fun onSongClicked(song: Song) {
        changeSongLoadingState(song)

        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                historyRepository.downloadSong(song)
            }.onFailure {
                it.printStackTrace()
            }.onSuccess {
                //TODO PLAY TRACK
            }
            changeSongLoadingState(song)
        }
    }

    private fun changeSongLoadingState(song: Song) {
        _songs.value = _songs.value.map {
            if (it.id == song.id) {
                it.copy(isDownloading = it.isDownloading.not())
            } else {
                it
            }
        }
    }
}