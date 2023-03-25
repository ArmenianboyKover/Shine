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
                name = "In The End",
                title = "In The End",
                imageUrl = "https://i.ytimg.com/vi/uXBzIPz9osY/maxresdefault.jpg"
            ), HistoryItem.Song(
                id = Random.nextLong().toString(),
                name = "HAARPER",
                title = "THE ALCHEMIST (PROD. RiCh LoSeR)",
                imageUrl = "https://i1.sndcdn.com/artworks-gpB8SXqsvcyKjECS-a1gZOQ-t500x500.jpg"
            ), HistoryItem.Song(
                id = Random.nextLong().toString(),
                name = "Oliver Tree",
                title = "Hurt",
                imageUrl = "https://i.ytimg.com/vi/NqpnbSFprB4/maxresdefault.jpg"
            ),
            HistoryItem.Title(
                text = "Yesterday"
            ),
            HistoryItem.Song(
                id = Random.nextLong().toString(),
                name = "PAIN",
                title = "Shut Your Mouth",
                imageUrl = "https://i.ytimg.com/vi/B1GTk-FX7Ww/hqdefault.jpg"
            ), HistoryItem.Song(
                id = Random.nextLong().toString(),
                name = "Eva Simons",
                title = "Bludfire",
                imageUrl = "https://i.ytimg.com/vi/ZsmTKrqpxdg/maxresdefault.jpg"
            ), HistoryItem.Song(
                id = Random.nextLong().toString(),
                name = "Хаски",
                title = "Бит шатает голову",
                imageUrl = "https://i1.sndcdn.com/artworks-000242733230-xo3fnx-t500x500.jpg"
            ), HistoryItem.Song(
                id = Random.nextLong().toString(),
                name = "Kordhell",
                title = "Live Another Day",
                imageUrl = "https://i1.sndcdn.com/artworks-xIKYFG7WxtMucLZg-WXHkEw-t500x500.jpg"
            ), HistoryItem.Song(
                id = Random.nextLong().toString(),
                name = "RAM",
                title = "В книге всё было по-другому (4 раунд 17 Независимый Баттл)",
                imageUrl = "https://images.genius.com/8592d8b104e57d04077b0e6afd02f3a8.1000x1000x1.jpg"
            ),
            HistoryItem.ShowList(
                text = "See all 13 played"
            )
        )
    }
}