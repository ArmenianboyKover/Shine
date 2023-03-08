package com.example.shine.songs

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shine.R

class SongViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val name: TextView = view.findViewById(R.id.title)
    val description: TextView = view.findViewById(R.id.description)
    val image: ImageView = view.findViewById(R.id.image)
    val songProgressBar: ProgressBar = view.findViewById(R.id.song_progress_bar)
}