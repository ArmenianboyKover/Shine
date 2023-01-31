package com.example.shine.history

sealed class HistoryItem {

    data class Song(
        val id: String,
        val name: String,
        val title: String,
        val imageUrl: String,
    ) : HistoryItem()

    data class ShowList(
        val text: String,
    ) : HistoryItem()

    data class Title(
        val text: String,
    ) : HistoryItem()
}