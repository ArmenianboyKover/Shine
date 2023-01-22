package com.example.shine.playlist_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shine.songs.RecommendationResponse
import com.example.shine.songs.Song
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header

class PlaylistDetailsViewModel : ViewModel() {

    private val _songs = MutableStateFlow<List<Song>>(emptyList())
    val songs = _songs.asStateFlow()

    init {
        getSongs()
    }

    private fun getSongs() {

        val client = Retrofit.Builder()
            .baseUrl("https://shazam.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val shazamApi = client.create(ShazamApi::class.java)

        viewModelScope.launch(Dispatchers.IO) {
            val result = shazamApi.getRecommendations(
                apiKey = Constants.API_KEY_HEADER,
                hostName = Constants.HOST_NAME_HEADER
            ).body()

            _songs.value = result?.tracks?.map {
                Song(
                    id = it.key.orEmpty(),
                    name = it.title.orEmpty(),
                    imageUrl = it.images?.background.orEmpty()
                )
            }.orEmpty()
        }
    }
}

interface ShazamApi {

    @GET("/songs/list-recommendations?key=484129036&locale=en-US")
    suspend fun getRecommendations(
        @Header("X-RapidAPI-Key") apiKey: String,
        @Header("X-RapidAPI-Host") hostName: String
    ): Response<RecommendationResponse>
}

object Constants {
    const val API_KEY_HEADER = "4187d483dfmsh82812e0db7e8bc9p15e684jsn2b173c87b7de"
    const val HOST_NAME_HEADER = "shazam.p.rapidapi.com"
}