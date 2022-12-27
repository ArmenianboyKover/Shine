package com.example.shine.songs

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shine.R

class SongViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val songs: TextView = view.findViewById(R.id.songs)
    val playlist: TextView = view.findViewById(R.id.playlists)
    val image: ImageView = view.findViewById(R.id.image)
}