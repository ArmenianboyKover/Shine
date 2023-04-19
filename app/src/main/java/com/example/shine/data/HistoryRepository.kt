package com.example.shine.data

import android.content.Context
import android.util.Log
import com.example.shine.utils.Constants.API_KEY_HEADER
import com.example.shine.utils.Constants.HOST_NAME_HEADER
import com.example.shine.data.database.SongsDao
import com.example.shine.data.database.mapToPresentation
import com.example.shine.songs.Song
import com.example.shine.songs.SongState
import com.example.shine.songs.mapToEntity
import java.io.File
import javax.inject.Inject

class HistoryRepository @Inject constructor(
    private val songsDao: SongsDao,
    private val shazamApi: ShazamApi,
    private val context: Context,
) {

    suspend fun downloadSong(song: Song): File {
        val file = File(context.cacheDir, "${song.id}.mp3")
        if (file.exists()) {
            return file
        }
        val result = shazamApi.downloadFile(song.trackLink)
        val songBytes = result.body()!!.bytes()
        file.writeBytes(songBytes)
        return file
    }

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
                description = it.subtitle.orEmpty(),
                trackLink = it.hub?.actions?.firstOrNull { it.uri != null }?.uri.orEmpty(),
                songState = SongState.IS_READY_TO_PLAY,
            )
        }.orEmpty()

        songsDao.insertAll(songs.mapToEntity())

        return songs
    }
}