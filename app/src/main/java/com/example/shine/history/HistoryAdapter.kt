package com.example.shine.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.shine.R
import com.example.shine.databinding.ItemHistoryDayBinding
import com.example.shine.databinding.ItemHistorySeeAllBinding
import com.example.shine.databinding.ItemHistorySongBinding

class HistoryAdapter() : ListAdapter<HistoryItem, HistoryViewHolder>(HistoryDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return when (viewType) {
            R.layout.item_history_song -> HistoryViewHolder.SongViewHolder(
                ItemHistorySongBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            R.layout.item_history_day -> HistoryViewHolder.TitleViewHolder(
                ItemHistoryDayBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            R.layout.item_history_see_all -> HistoryViewHolder.ShowListViewHolder(
                ItemHistorySeeAllBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            else -> throw IllegalArgumentException("Invalid ViewType Provided")
        }
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        when (holder) {
            is HistoryViewHolder.SongViewHolder -> holder.bind(currentList[position] as HistoryItem.Song)
            is HistoryViewHolder.TitleViewHolder -> holder.bind(currentList[position] as HistoryItem.Title)
            is HistoryViewHolder.ShowListViewHolder -> holder.bind(currentList[position] as HistoryItem.ShowList)
        }
    }

    override fun getItemCount(): Int = currentList.size

    override fun getItemViewType(position: Int): Int {
        return when (currentList[position]) {
            is HistoryItem.Song -> R.layout.item_history_song
            is HistoryItem.Title -> R.layout.item_history_day
            is HistoryItem.ShowList -> R.layout.item_history_see_all
        }
    }
}