package com.example.shine.playlist_details

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.shine.R
import com.example.shine.songs.SongsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PlaylistDetailsFragment : Fragment(R.layout.fragment_playlist_details) {

    private val viewModel by viewModels<PlaylistDetailsViewModel>()

    private val playlistId by lazy {
        arguments?.getLong(PLAYLIST_ID_ARG) ?: error("THIS FRAGMENT NEEDS PLAYLIST ID ARG")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recyclerView)
        val progressBar = view.findViewById<ProgressBar>(R.id.progress_bar)

        lifecycleScope.launch {
            viewModel.isLoading.collect {
                progressBar.visibility = if (it) View.VISIBLE else View.GONE
            }
        }
        val adapter = SongsAdapter {
            viewModel.onSongClicked(it)
        }

        recycler.adapter = adapter

        lifecycleScope.launch {
            viewModel.songs.collect { songs ->
                adapter.submitList(songs)
            }
        }
        viewModel.fetchSongs(playlistId)
    }

    companion object {
        private const val PLAYLIST_ID_ARG = "playlist_id_arg"

        fun newInstance(playlistId: Long): PlaylistDetailsFragment {
            return PlaylistDetailsFragment().apply {
                arguments = bundleOf(PLAYLIST_ID_ARG to playlistId)
            }
        }
    }
}