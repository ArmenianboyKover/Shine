package com.example.shine.playlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.shine.R

class PlaylistAdapter(
    private val onItemClicked: (Playlist) -> Unit
) : ListAdapter<Playlist, PlaylistViewHolder>(PlaylistDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_playlist,
            parent,
            false
        )
        return PlaylistViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        val playlist = currentList[position]
        holder.title.text = playlist.title
        holder.description.text = playlist.description
        holder.image.load(playlist.url) {
            transformations(RoundedCornersTransformation(20f))
        }
        holder.itemView.setOnClickListener { onItemClicked(playlist) }
    }
}

class PlaylistDiffUtil : DiffUtil.ItemCallback<Playlist>() {
    override fun areItemsTheSame(oldItem: Playlist, newItem: Playlist): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Playlist, newItem: Playlist): Boolean {
        return oldItem == newItem
    }
}
