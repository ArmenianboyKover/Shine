package com.example.shine.playlist_details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.shine.R
import com.example.shine.songs.SongsAdapter
import kotlinx.coroutines.launch

class PlaylistDetailsFragment : Fragment(R.layout.fragment_playlist_details) {

    private val viewModel by viewModels<PlaylistDetailsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = SongsAdapter()
        recycler.adapter = adapter

        lifecycleScope.launch {
            viewModel.songs.collect { songs ->
                adapter.submitList(songs)
            }
        }
    }
}