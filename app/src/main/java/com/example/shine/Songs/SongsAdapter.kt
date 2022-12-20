package com.example.shine.Songs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.shine.R

class SongsAdapter : RecyclerView.Adapter<SongsViewHolder>() {
    private var songs = listOf<Songs>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_playlistsongs, parent, false)
        return SongsViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongsViewHolder, position: Int) {
        val song = songs[position]
        holder.songs.text = song.songs
        holder.playlist.text = song.playlist
        holder.image.load(song.image) {
            transformations(RoundedCornersTransformation(20f))
        }
    }

    fun updateSong(list: List<Songs>) {
        songs = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = songs.size

}