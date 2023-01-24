package com.example.shine.songs

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shine.R

class SongViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val songs: TextView = view.findViewById(R.id.songs)
    val subtitle: TextView = view.findViewById(R.id.subtitle)
    val image: ImageView = view.findViewById(R.id.image)
}