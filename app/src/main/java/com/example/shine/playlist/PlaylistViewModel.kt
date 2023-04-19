package com.example.shine.playlist

import androidx.lifecycle.ViewModel
import com.example.shine.utils.Constants
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.random.Random

class PlaylistViewModel : ViewModel() {

    private val _playLists = MutableStateFlow<List<Playlist>>(emptyList())
    val playLists = _playLists.asStateFlow() // Инкапсуляция

    init {
        _playLists.value = getPLayLists()
    }

    private fun getPLayLists(): List<Playlist> {
        return listOf(
            Playlist(
                id = Constants.RECOMMENDATION_PLAYLIST_ID,
                title = "Recommendation",
                description = "78 Songs",
                url = "https://avatars.mds.yandex.net/i?id=5607afbea0eba753a275c1bad58b06abdab3fded-5336870-images-thumbs&n=13",
            ),
            //TODO mocked data
            Playlist(
                id = Random.nextLong(),
                title = "Favorites",
                description = "1023 Songs",
                url = "https://images.assetsdelivery.com/compings_v2/iconscart/iconscart2104/iconscart210411598.jpg",
            ),
            Playlist(
                id = Random.nextLong(),
                title = "Sadness",
                description = "322 Songs",
                url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSVPxIkv53SKMjCh7f-K3LN6Xll_QOm6Wt7-A&usqp=CAU",
            ),
            Playlist(
                id = Random.nextLong(),
                title = "Party",
                description = "88 Songs",
                url = "https://audiocaptain.com/wp-content/uploads/2021/10/Best-Party-Songs.jpg",
            ),
            Playlist(
                id = Random.nextLong(),
                title = "Birthday",
                description = "13 Songs",
                url = "https://siachenstudios.com/wp-content/uploads/2021/10/birthday.jpg",
            ),
            Playlist(
                id = Random.nextLong(),
                title = "Drive",
                description = "65 Songs",
                url = "https://i.ytimg.com/vi/9oN35tifuOo/maxresdefault.jpg",
            ),
            Playlist(
                id = Random.nextLong(),
                title = "Gym",
                description = "138 Songs",
                url = "https://i.scdn.co/image/ab6761610000e5eb222c50aefee48ac434148281",
            ),
            Playlist(
                id = Random.nextLong(),
                title = "You've got great taste!",
                description = "74 Songs",
                url = "https://media-cldnry.s-nbcnews.com/image/upload/t_social_share_1024x768_scale,f_auto,q_auto:best/newscms/2019_09/2769481/190228-headphones-music-se-152p.jpg",
            ),
            Playlist(
                id = Random.nextLong(),
                title = "DJ Anime",
                description = "84 Songs",
                url = "https://i1.sndcdn.com/artworks-000348975159-kia0yq-t500x500.jpg",
            ),
            Playlist(
                id = Random.nextLong(),
                title = "Adele",
                description = "54 Songs",
                url = "https://sun9-64.userapi.com/impf/c847122/v847122635/1f88a5/949bJnIn3pA.jpg?size=1280x986&quality=96&sign=a14c2b3e8b5dcce06274554500fd9028&c_uniq_tag=vPh7PMpon6_sUjW4DDGwvb_zT8-qViS5hgXJfMgphoo&type=album",
            ),
        )
    }
}