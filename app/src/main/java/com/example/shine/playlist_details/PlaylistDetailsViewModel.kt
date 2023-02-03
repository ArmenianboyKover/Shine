package com.example.shine.playlist_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shine.Constants.RECOMMENDATION_PLAYLIST_ID
import com.example.shine.data.HistoryRepository
import com.example.shine.songs.RecommendationResponse
import com.example.shine.songs.Song
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import javax.inject.Inject

@HiltViewModel
class PlaylistDetailsViewModel @Inject constructor(
    private val historyRepository: HistoryRepository
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
}

interface ShazamApi {

    @GET("/songs/list-recommendations?key=484129036&locale=en-US")
    suspend fun getRecommendations(
        @Header("X-RapidAPI-Key") apiKey: String,
        @Header("X-RapidAPI-Host") hostName: String
    ): Response<RecommendationResponse>
}