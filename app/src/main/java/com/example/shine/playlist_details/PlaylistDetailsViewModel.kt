package com.example.shine.playlist_details

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shine.Constants.RECOMMENDATION_PLAYLIST_ID
import com.example.shine.data.HistoryRepository
import com.example.shine.songs.Song
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlaylistDetailsViewModel @Inject constructor(
    private val historyRepository: HistoryRepository,
    private val context: Context,
) : ViewModel() {

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    private val _songs = MutableStateFlow<List<Song>>(emptyList())
    val songs = _songs.asStateFlow()

    private var mediaPlayer = MediaPlayer()
    private var currentSongId: String? = null

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

        if (song.id == currentSongId) {
            if (mediaPlayer.isPlaying) mediaPlayer.pause() else mediaPlayer.start()
            return
        } else {
            mediaPlayer.stop()
            currentSongId = null
        }

        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                historyRepository.downloadSong(song)
            }.onFailure {
                it.printStackTrace()
            }.onSuccess {
                mediaPlayer.setDataSource(context, Uri.fromFile(it))
                mediaPlayer.prepare()
                currentSongId = song.id
                mediaPlayer.start()
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