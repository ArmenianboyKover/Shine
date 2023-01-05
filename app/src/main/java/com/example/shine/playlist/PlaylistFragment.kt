package com.example.shine.playlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.shine.R
import kotlinx.coroutines.launch

class PlaylistFragment : Fragment(R.layout.fragment_playlists) {

    private val viewModel by viewModels<PlayListViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = PlaylistAdapter()
        recycler.adapter = adapter

        lifecycleScope.launch {
            viewModel.playLists.collect { playLists ->
                adapter.submitList(playLists)
            }
        }
    }
}