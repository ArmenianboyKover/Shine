package com.example.shine.playlist

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.random.Random

class PlayListViewModel : ViewModel() {

    private val _playLists = MutableStateFlow<List<Playlist>>(emptyList())
    val playLists = _playLists.asStateFlow() // Инкапсуляция

    init {
        _playLists.value = getPLayLists()
    }

    private fun getPLayLists(): List<Playlist> {
        return listOf(
            Playlist(
                id = Random.nextLong(),
                title = "Favorite",
                description = "111 Songs",
                url = "https://preview.redd.it/rnqa7yhv4il71.jpg?width=640&crop=smart&auto=webp&s=819eb2bda1b35c7729065035a16e81824132e2f1"
            ),
            Playlist(
                id = Random.nextLong(),
                title = "Party",
                description = "45 Songs",
                url = "https://images.pexels.com/photos/1190298/pexels-photo-1190298.jpeg?cs=srgb&dl=pexels-wendy-wei-1190298.jpg&fm=jpg"
            ),
            Playlist(
                id = Random.nextLong(),
                title = "Freedom",
                description = "12 Songs",
                url = "https://jami.net/content/images/2019/11/mohamed-nohassi-odxB5oIG_iA-unsplash.jpg"
            ),
            Playlist(
                id = Random.nextLong(),
                title = "Sadness",
                description = "1 Song",
                url = "https://media.istockphoto.com/id/1277138645/photo/young-worried-woman-looking-out-of-the-window.jpg?s=612x612&w=0&k=20&c=o7HRsCNi6sYg5E8rzlMUl28mRqDKCakb_J4V6zhTj2A="
            ),
            Playlist(
                id = Random.nextLong(),
                title = "Birthday",
                description = "34 Songs",
                url = "https://media.istockphoto.com/photos/birthday-cake-decorated-with-colorful-sprinkles-and-ten-candles-picture-id1136810581?b=1&k=20&m=1136810581&s=612x612&w=0&h=UJhs0Z0ptVRCQCrQZ17ONEZvumyAIFp8pryXzZQR3Mk="
            ),
        )
    }
}