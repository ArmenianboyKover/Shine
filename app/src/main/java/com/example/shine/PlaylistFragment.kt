package com.example.shine

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class PlaylistFragment : Fragment(R.layout.fragment_playlist) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = SongAdapter()
        recycler.adapter = adapter
        adapter.updateSongs(getSongs())
    }

    fun getSongs(): List<Song> {
        return listOf(
            Song(title = "favorite", description = "wadaweaw"),
            Song(title = "favorite", description = "awd"),
            Song(title = "favorite", description = "awd"),
            Song("favorite", "waascdaweaw"),
            Song("favorite", "daxa"),
            Song("favorite", "wadascweaw"),
            Song("favorite", "wadascsweaw"),
            Song("favorite", "wawedaweaw"),
            Song("favorite", "wadawdewweaw"),
            Song("favorite", "wadaxzcweaw"),
            Song("favorite", "wadaxzczweaw"),
            )
    }
}