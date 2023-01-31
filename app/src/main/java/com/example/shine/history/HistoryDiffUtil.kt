package com.example.shine.history

import androidx.recyclerview.widget.DiffUtil

class HistoryDiffUtil : DiffUtil.ItemCallback<HistoryItem>() {
    override fun areItemsTheSame(oldItem: HistoryItem, newItem: HistoryItem): Boolean {
        return when {
            oldItem is HistoryItem.Song && newItem is HistoryItem.Song -> {
                oldItem.id == newItem.id
            }
            else -> false
        }
    }

    override fun areContentsTheSame(oldItem: HistoryItem, newItem: HistoryItem): Boolean =
        oldItem == newItem
}