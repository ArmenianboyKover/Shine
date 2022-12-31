package com.example.shine.songs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.shine.R
import kotlin.random.Random

class SongsFragment : Fragment(R.layout.fragment_songs) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = SongsAdapter()
        recycler.adapter = adapter
        adapter.submitList(getSongs())
    }

    fun getSongs(): List<Song> {
        return listOf(
            Song(
                id = Random.nextLong(),
                song = "vasya",
                playlist = "leha",
                image = "https://incrussia.ru/upload/resized/572c151849d7cadfd7cbccb840a84c4a.jpg"
            ),
            Song(
                id = Random.nextLong(),
                song = "Leha",
                playlist = "arbsuz",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlthFAPI9r1bCPSHXz3Cz0dCvMGtdgypv18Q&usqp=CAU"
            ),
            Song(
                id = Random.nextLong(),
                song = "Leha",
                playlist = "arbsuz",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlthFAPI9r1bCPSHXz3Cz0dCvMGtdgypv18Q&usqp=CAU"
            ),
            Song(
                id = Random.nextLong(),
                song = "Leha",
                playlist = "arbssduz",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlthFAPI9r1bCPSHXz3Cz0dCvMGtdgypv18Q&usqp=CAU"
            ),
            Song(
                id = Random.nextLong(),
                song = "Lesdha",
                playlist = "arsdsbsuz",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlthFAPI9r1bCPSHXz3Cz0dCvMGtdgypv18Q&usqp=CAU"
            ),
            Song(
                id = Random.nextLong(),
                song = "Lesdsha",
                playlist = "arbsdsdsuz",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlthFAPI9r1bCPSHXz3Cz0dCvMGtdgypv18Q&usqp=CAU"
            ),
        )
    }
}