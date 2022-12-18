package com.example.shine

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation

class PlaylistAdapter : RecyclerView.Adapter<PlaylistViewHolder>() {
    private var playlists = listOf<Playlist>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_song, parent, false)
        return PlaylistViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        val song = playlists[position]
        holder.title.text = song.title
        holder.description.text = song.description
        holder.liked.load(song.url) {
            transformations(RoundedCornersTransformation(20f))
        }

    }

    fun updateSongs(list: List<Playlist>) {
        playlists = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = playlists.size
}

