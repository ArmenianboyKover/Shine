package com.example.shine.history

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.random.Random

class HistoryViewModel : ViewModel() {

    private val _history = MutableStateFlow<List<HistoryItem>>(emptyList())
    val history = _history.asStateFlow()

    init {
        _history.value = getHistory()
    }

    private fun getHistory(): List<HistoryItem> {
        return listOf(
            HistoryItem.Title(
                text = "Today"
            ),
            HistoryItem.Song(
                id = Random.nextLong().toString(),
                name = "Pasveti u tymani",
                title = "Timati i dj leha",
                imageUrl = "https://incrussia.ru/upload/resized/572c151849d7cadfd7cbccb840a84c4a.jpg"
            ), HistoryItem.Song(
                id = Random.nextLong().toString(),
                name = "Pasveti u tymani",
                title = "Timati i dj leha",
                imageUrl = "https://incrussia.ru/upload/resized/572c151849d7cadfd7cbccb840a84c4a.jpg"
            ), HistoryItem.Song(
                id = Random.nextLong().toString(),
                name = "Pasveti u tymani",
                title = "Timati i dj leha",
                imageUrl = "https://incrussia.ru/upload/resized/572c151849d7cadfd7cbccb840a84c4a.jpg"
            ),
            HistoryItem.ShowList(
                text = "See all 283 played"
            )
        )
    }
}