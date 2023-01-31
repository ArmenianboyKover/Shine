package com.example.shine.history

import androidx.recyclerview.widget.DiffUtil

class HistoryDiffUtil : DiffUtil.ItemCallback<HistoryItem>() {
    override fun areItemsTheSame(oldItem: HistoryItem, newItem: HistoryItem): Boolean {
        return when {
            oldItem is HistoryItem.Song && newItem is HistoryItem.Song -> {
                oldItem.id == newItem.id
            }
            oldItem is HistoryItem.ShowList && newItem is HistoryItem.ShowList -> {
                oldItem.text == newItem.text
            }
            oldItem is HistoryItem.Title && newItem is HistoryItem.Title -> {
                oldItem.text == newItem.text
            }
            else -> false
        }
    }

    override fun areContentsTheSame(oldItem: HistoryItem, newItem: HistoryItem): Boolean =
        oldItem == newItem
}