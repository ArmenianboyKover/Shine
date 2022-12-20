package com.example.shine.Songs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.shine.R

class SongsFragment : Fragment(R.layout.fragment_songsinplaylist) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = SongsAdapter()
        recycler.adapter = adapter
        adapter.updateSong(getSongs())
    }

    fun getSongs(): List<Songs> {
        return listOf(
            Songs(
                songs = "DJ Leha",
                playlist = "arbuz",
                image = "data:image/gif;base64,R0lGODlhAQABAIAAAP///////yH5BAEKAAEALAAAAAABAAEAAAICTAEAOw=="
            ),
            Songs(
                songs = "DJ Leha",
                playlist = "arbuz",
                image = "data:image/gif;base64,R0lGODlhAQABAIAAAP///////yH5BAEKAAEALAAAAAABAAEAAAICTAEAOw=="
            ),
            Songs(
                songs = "DJ Leha",
                playlist = "arbuz",
                image = "data:image/gif;base64,R0lGODlhAQABAIAAAP///////yH5BAEKAAEALAAAAAABAAEAAAICTAEAOw=="
            ),
            Songs(
                songs = "DJ Leha",
                playlist = "arbuz",
                image = "data:image/gif;base64,R0lGODlhAQABAIAAAP///////yH5BAEKAAEALAAAAAABAAEAAAICTAEAOw=="
            ),
            Songs(
                songs = "DJ Leha",
                playlist = "arbuz",
                image = "data:image/gif;base64,R0lGODlhAQABAIAAAP///////yH5BAEKAAEALAAAAAABAAEAAAICTAEAOw=="
            ),
            Songs(
                songs = "DJ Leha",
                playlist = "arbuz",
                image = "data:image/gif;base64,R0lGODlhAQABAIAAAP///////yH5BAEKAAEALAAAAAABAAEAAAICTAEAOw=="
            ),
        )
    }

}