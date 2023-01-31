package com.example.shine.history

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.shine.databinding.ItemHistoryDayBinding
import com.example.shine.databinding.ItemHistorySeeAllBinding
import com.example.shine.databinding.ItemHistorySongBinding

sealed class HistoryViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class TitleViewHolder(private val binding: ItemHistoryDayBinding) : HistoryViewHolder(binding) {

        fun bind(title: HistoryItem.Title) {
            binding.textDay.text = title.text
        }
    }

    class ShowListViewHolder(private val binding: ItemHistorySeeAllBinding) :
        HistoryViewHolder(binding) {

        fun bind(showList: HistoryItem.ShowList) {
            binding.textHistory.text = showList.text
        }
    }

    class SongViewHolder(private val binding: ItemHistorySongBinding) : HistoryViewHolder(binding) {

        fun bind(song: HistoryItem.Song) {
            binding.historySongName.text = song.name
            binding.historyTitle.text = song.title
            binding.historyImage.load(song.imageUrl) {
                transformations(RoundedCornersTransformation(20f))
            }
        }
    }
}