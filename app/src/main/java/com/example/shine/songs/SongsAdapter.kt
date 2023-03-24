package com.example.shine.songs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.shine.R

class SongsAdapter(
    private val onItemClicked: (Song) -> Unit
) : ListAdapter<Song, SongViewHolder>(SongDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_song, parent, false)
        return SongViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = currentList[position]
        holder.description.text = song.description
        holder.name.text = song.name
        holder.image.load(song.imageUrl) {
            transformations(RoundedCornersTransformation(20f))
        }
        holder.itemView.setOnClickListener { onItemClicked(song) }
        holder.songProgressBar.isVisible = song.songState == SongState.IS_DOWNLOADING
        holder.musicBar.isVisible = song.songState == SongState.IS_PLAYING
        holder.pauseImage.isVisible = song.songState == SongState.IS_PAUSE
    }
}

class SongDiffUtil : DiffUtil.ItemCallback<Song>() {
    override fun areItemsTheSame(oldItem: Song, newItem: Song): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Song, newItem: Song): Boolean {
        return oldItem == newItem
    }
}