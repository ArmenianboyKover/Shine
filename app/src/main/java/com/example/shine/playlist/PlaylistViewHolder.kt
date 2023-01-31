package com.example.shine.playlist

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shine.R

class PlaylistViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val title: TextView = view.findViewById(R.id.title)
    val description: TextView = view.findViewById(R.id.description)
    val image: ImageView = view.findViewById(R.id.image)
}