package com.example.shine.songs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.shine.R

class SongsFragment : Fragment(R.layout.fragment_songs) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = SongsAdapter()
        recycler.adapter = adapter
        adapter.updateSong(getSongs())
    }

    fun getSongs(): List<PlayListSong> {
        return listOf(
            PlayListSong(
                song = "vasya",
                playlist = "leha",
                image = "https://incrussia.ru/upload/resized/572c151849d7cadfd7cbccb840a84c4a.jpg"
            ),
            PlayListSong(
                song = "Leha",
                playlist = "arbsuz",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlthFAPI9r1bCPSHXz3Cz0dCvMGtdgypv18Q&usqp=CAU"
            ),
            PlayListSong(
                song = "Leha",
                playlist = "arbsuz",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlthFAPI9r1bCPSHXz3Cz0dCvMGtdgypv18Q&usqp=CAU"
            ),
            PlayListSong(
                song = "Leha",
                playlist = "arbssduz",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlthFAPI9r1bCPSHXz3Cz0dCvMGtdgypv18Q&usqp=CAU"
            ),
            PlayListSong(
                song = "Lesdha",
                playlist = "arsdsbsuz",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlthFAPI9r1bCPSHXz3Cz0dCvMGtdgypv18Q&usqp=CAU"
            ),
            PlayListSong(
                song = "Lesdsha",
                playlist = "arbsdsdsuz",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlthFAPI9r1bCPSHXz3Cz0dCvMGtdgypv18Q&usqp=CAU"
            ),
        )
    }
}