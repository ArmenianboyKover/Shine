package com.example.shine.playlist_details

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import com.example.shine.songs.Song
import java.io.File
import javax.inject.Inject

class SongPlayer @Inject constructor(
    private val context: Context,
) {
    private val mediaPlayer = MediaPlayer()
    private var currentSongId: String? = null

    fun pausePlayTrack(song: Song): SongClickedState {
        return when {
            currentSongId == null -> SongClickedState.FIRST_TRACK_CLICKED
            song.id == currentSongId -> {
                if (mediaPlayer.isPlaying) mediaPlayer.pause() else mediaPlayer.start()
                SongClickedState.SAME_TRACK_CLICKED
            }
            else -> {
                mediaPlayer.stop()
                mediaPlayer.reset()
                currentSongId = null
                SongClickedState.ANOTHER_TRACK_CLICKED
            }
        }
    }

    fun setupAndRunSong(song: Song, file: File) {
        mediaPlayer.setDataSource(context, Uri.fromFile(file))
        currentSongId = song.id
        mediaPlayer.prepare()
        mediaPlayer.start()
    }

    enum class SongClickedState {
        SAME_TRACK_CLICKED,
        ANOTHER_TRACK_CLICKED,
        FIRST_TRACK_CLICKED,
    }
}
