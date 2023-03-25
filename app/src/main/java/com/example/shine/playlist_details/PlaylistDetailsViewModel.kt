package com.example.shine.playlist_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shine.Constants.RECOMMENDATION_PLAYLIST_ID
import com.example.shine.data.HistoryRepository
import com.example.shine.songs.Song
import com.example.shine.songs.SongState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlaylistDetailsViewModel @Inject constructor(
    private val historyRepository: HistoryRepository,
    private val songPlayer: SongPlayer,
) : ViewModel() {

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    private val _songs = MutableStateFlow<List<Song>>(emptyList())
    val songs = _songs.asStateFlow()

    fun fetchSongs(playlistId: Long) {
        if (_songs.value.isNotEmpty()) return

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

        when (songPlayer.pausePlayTrack(song)) {
            SongPlayer.SongClickedState.SAME_TRACK_PAUSED -> changeSongState(
                song,
                SongState.IS_PAUSE
            )
            SongPlayer.SongClickedState.SAME_TRACK_PLAYING -> changeSongState(
                song,
                SongState.IS_PLAYING
            )
            else -> fetchAndPlaySong(song)
        }
    }

    private fun changeSongState(song: Song, songState: SongState) {
        _songs.value = _songs.value.map {
            if (it.id == song.id) {
                it.copy(songState = songState)
            } else {
                it.copy(songState = SongState.IS_READY_TO_PLAY)
            }
        }
    }

    private fun fetchAndPlaySong(song: Song) {
        changeSongState(song, SongState.IS_DOWNLOADING)
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                historyRepository.downloadSong(song)
            }.onFailure {
                it.printStackTrace()
                changeSongState(song, SongState.IS_READY_TO_PLAY)
            }.onSuccess {
                songPlayer.setupAndRunSong(song, it)
                changeSongState(song, SongState.IS_PLAYING)
            }
        }
    }
}