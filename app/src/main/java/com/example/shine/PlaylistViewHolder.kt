package com.example.shine

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlaylistViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val title: TextView = view.findViewById(R.id.title)
    val description: TextView = view.findViewById(R.id.description)
    val liked: ImageView = view.findViewById(R.id.liked)
}