package com.example.shine

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SongAdapter : RecyclerView.Adapter<SongViewHolder>() {
    private var songs = listOf<Song>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_song, parent, false)
        return SongViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = songs[position]
        holder.title.text = song.title
        holder.description.text = song.description
    }

    fun updateSongs(list: List<Song>) {
        songs = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = songs.size
}

class SongViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val title = view.findViewById<TextView>(R.id.title)
    val description = view.findViewById<TextView>(R.id.description)

}

data class Song(
    val title: String,
    val description: String
)