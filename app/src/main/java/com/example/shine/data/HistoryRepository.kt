package com.example.shine.data

import android.util.Log
import com.example.shine.Constants.API_KEY_HEADER
import com.example.shine.Constants.HOST_NAME_HEADER
import com.example.shine.data.database.history.SongsDao
import com.example.shine.data.database.history.mapToPresentation
import com.example.shine.playlist_details.ShazamApi
import com.example.shine.songs.Song
import com.example.shine.songs.mapToEntity
import javax.inject.Inject

class HistoryRepository @Inject constructor(
    private val songsDao: SongsDao,
    private val shazamApi: ShazamApi
) {

    suspend fun getSong(): List<Song> {

        val cache = songsDao.getSongs()

        if (cache.isNotEmpty()) {
            Log.i("SONGS", "Cashed songs returned")
            return cache.mapToPresentation()
        }

        Log.i("SONGS", "The song cache is empty")

        val result = shazamApi.getRecommendations(API_KEY_HEADER, HOST_NAME_HEADER).body()

        val songs = result?.tracks?.map {
            Song(
                id = it.key.orEmpty(),
                name = it.title.orEmpty(),
                imageUrl = it.images?.background.orEmpty(),
                description = it.subtitle.orEmpty()
            )
        }.orEmpty()

        songsDao.insertAll(songs.mapToEntity())

        return songs
    }
}