package com.example.shine.songs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.shine.R

class SongsAdapter : RecyclerView.Adapter<PlayListSongsViewHolder>() {
    private var songs = listOf<PlayListSongs>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayListSongsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_song, parent, false)
        return PlayListSongsViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayListSongsViewHolder, position: Int) {
        val song = songs[position]
        holder.songs.text = song.song
        holder.playlist.text = song.playlist
        holder.image.load(song.image) {
            transformations(RoundedCornersTransformation(20f))
        }
    }

    fun updateSong(list: List<PlayListSongs>) {
        songs = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = songs.size

}