package com.example.shine.songs

import androidx.lifecycle.ViewModel
import com.example.shine.data.HistoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class SongsViewModel @Inject constructor(
    private val historyRepository: HistoryRepository,
) : ViewModel() {

    private val _songs = MutableStateFlow<List<Song>>(emptyList())
    val songs = _songs.asStateFlow()

    init {
        _songs.value = getSongs()
    }

    private fun getSongs(): List<Song> {
        //TODO mocked data
        return listOf(
            Song(
                id = Random.nextLong().toString(),
                name = "In The End",
                imageUrl = "https://i.ytimg.com/vi/uXBzIPz9osY/maxresdefault.jpg",
                description = "AniMe",
                trackLink = "vwd",
                songState = SongState.IS_READY_TO_PLAY,
            ),
            Song(
                id = Random.nextLong().toString(),
                name = "SPIT IN MY FACE!",
                imageUrl = "https://i1.sndcdn.com/artworks-z0FB3yokl3VW-0-t500x500.jpg",
                description = "ThxSoMch",
                trackLink = "vwd",
                songState = SongState.IS_READY_TO_PLAY,
            ),
            Song(
                id = Random.nextLong().toString(),
                name = "Komarovo",
                imageUrl = "https://i1.sndcdn.com/artworks-kwDEHZIPV22QrVOz-5E5lkg-t500x500.jpg",
                description = "(DVRST Phonk Remix)",
                trackLink = "vwd",
                songState = SongState.IS_READY_TO_PLAY,
            ),
            Song(
                id = Random.nextLong().toString(),
                name = "This Is Japan",
                imageUrl = "https://avatars.yandex.net/get-music-content/5966316/476b306e.a.22439911-1/m1000x1000",
                description = "FREE FLOW FLAVA",
                trackLink = "vwd",
                songState = SongState.IS_READY_TO_PLAY,
            ),
            Song(
                id = Random.nextLong().toString(),
                name = "HAARPER",
                imageUrl = "https://i1.sndcdn.com/artworks-gpB8SXqsvcyKjECS-a1gZOQ-t500x500.jpg",
                description = "THE ALCHEMIST (PROD. RiCh LoSeR)",
                trackLink = "vwd",
                songState = SongState.IS_READY_TO_PLAY,
            ),
            Song(
                id = Random.nextLong().toString(),
                name = "Oliver Tree",
                imageUrl = "https://i.ytimg.com/vi/NqpnbSFprB4/maxresdefault.jpg",
                description = "Hurt",
                trackLink = "vwd",
                songState = SongState.IS_READY_TO_PLAY,
            ),
            Song(
                id = Random.nextLong().toString(),
                name = "NIGHTMORSS",
                imageUrl = "https://avatars.yandex.net/get-music-content/5413882/394ecbca.a.18990711-1/m1000x1000",
                description = "SECRET",
                trackLink = "vwd",
                songState = SongState.IS_READY_TO_PLAY,
            ),
            Song(
                id = Random.nextLong().toString(),
                name = "Jincheng Zhang",
                imageUrl = "https://i.ytimg.com/vi/yg251GkBVyo/sddefault.jpg",
                description = "Buy Betray",
                trackLink = "vwd",
                songState = SongState.IS_READY_TO_PLAY,
            ),
            Song(
                id = Random.nextLong().toString(),
                name = "Skrillex & Diplo feat. Kai",
                imageUrl = "https://i.ytimg.com/vi/fDrTbLXHKu8/maxresdefault.jpg",
                description = "Mind",
                trackLink = "vwd",
                songState = SongState.IS_READY_TO_PLAY,
            ),
            Song(
                id = Random.nextLong().toString(),
                name = "PAIN",
                imageUrl = "https://i.ytimg.com/vi/B1GTk-FX7Ww/hqdefault.jpg",
                description = "Shut Your Mouth",
                trackLink = "vwd",
                songState = SongState.IS_READY_TO_PLAY,
            ),
            Song(
                id = Random.nextLong().toString(),
                name = "SKRILLEX",
                imageUrl = "https://i1.sndcdn.com/artworks-000080856811-txh7cq-t500x500.jpg",
                description = "KYOTO",
                trackLink = "vwd",
                songState = SongState.IS_READY_TO_PLAY,
            ),
            Song(
                id = Random.nextLong().toString(),
                name = "Eva Simons",
                imageUrl = "https://i.ytimg.com/vi/ZsmTKrqpxdg/maxresdefault.jpg",
                description = "Bludfire",
                trackLink = "vwd",
                songState = SongState.IS_READY_TO_PLAY,
            ),
            Song(
                id = Random.nextLong().toString(),
                name = "Хаски",
                imageUrl = "https://i1.sndcdn.com/artworks-000242733230-xo3fnx-t500x500.jpg",
                description = "Бит шатает голову",
                trackLink = "vwd",
                songState = SongState.IS_READY_TO_PLAY,
            ),
            Song(
                id = Random.nextLong().toString(),
                name = "Bones",
                imageUrl = "https://i.ytimg.com/vi/OQTImQ0RQNg/maxresdefault.jpg",
                description = "Sodium",
                trackLink = "vwd",
                songState = SongState.IS_READY_TO_PLAY,
            ),
            Song(
                id = Random.nextLong().toString(),
                name = "Celldweller",
                imageUrl = "https://i1.sndcdn.com/artworks-000009265892-m7solj-t500x500.jpg",
                description = "Frozen",
                trackLink = "vwd",
                songState = SongState.IS_READY_TO_PLAY,
            ),
            Song(
                id = Random.nextLong().toString(),
                name = "Celldweller",
                imageUrl = "https://i.ytimg.com/vi/y5yw3yMfP5E/maxresdefault.jpg",
                description = "Switchback",
                trackLink = "vwd",
                songState = SongState.IS_READY_TO_PLAY,
            ),
            Song(
                id = Random.nextLong().toString(),
                name = "Kordhell",
                imageUrl = "https://i1.sndcdn.com/artworks-xIKYFG7WxtMucLZg-WXHkEw-t500x500.jpg",
                description = "Live Another Day",
                trackLink = "vwd",
                songState = SongState.IS_READY_TO_PLAY,
            ),
            Song(
                id = Random.nextLong().toString(),
                name = "RAM",
                imageUrl = "https://images.genius.com/8592d8b104e57d04077b0e6afd02f3a8.1000x1000x1.jpg",
                description = "В книге всё было по-другому (4 раунд 17 Независимый Баттл)",
                trackLink = "vwd",
                songState = SongState.IS_READY_TO_PLAY,
            ),
            Song(
                id = Random.nextLong().toString(),
                name = "Перемотка",
                imageUrl = "https://i.ytimg.com/vi/nv5jicnN9_Q/maxresdefault.jpg",
                description = "Старое кино",
                trackLink = "vwd",
                songState = SongState.IS_READY_TO_PLAY,
            ),
            Song(
                id = Random.nextLong().toString(),
                name = "LIZER",
                imageUrl = "https://i.ytimg.com/vi/c_tSDJD1Jf8/maxresdefault.jpg",
                description = "Пачка Сигарет",
                trackLink = "vwd",
                songState = SongState.IS_READY_TO_PLAY,
            ),
            Song(
                id = Random.nextLong().toString(),
                name = "CHERNOBURKV X CRASPORE",
                imageUrl = "https://i.ytimg.com/vi/YySxrJJd9GM/maxresdefault.jpg",
                description = "ASФIXIA",
                trackLink = "vwd",
                songState = SongState.IS_READY_TO_PLAY,
            ),
        )
    }
}