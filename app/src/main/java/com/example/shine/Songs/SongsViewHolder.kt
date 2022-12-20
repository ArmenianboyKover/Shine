package com.example.shine.Songs

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shine.R

class SongsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val songs: TextView = view.findViewById(R.id.songs)
    val playlist: TextView = view.findViewById(R.id.playlists)
    val image: ImageView = view.findViewById(androidx.appcompat.R.id.image)
}