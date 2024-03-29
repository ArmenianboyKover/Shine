package com.example.shine.playlist

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.shine.utils.Constants
import com.example.shine.app.MainActivity
import com.example.shine.R
import com.example.shine.playlist_details.PlaylistDetailsFragment
import kotlinx.coroutines.launch

class PlaylistFragment : Fragment(R.layout.fragment_playlists) {

    private val viewModel by viewModels<PlaylistViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = PlaylistAdapter {
            if (it.id == Constants.RECOMMENDATION_PLAYLIST_ID) {
                (activity as MainActivity).loadFragment(PlaylistDetailsFragment.newInstance(it.id))
            } else {
                Toast.makeText(context, "Not implemented yet", Toast.LENGTH_SHORT).show()
            }
        }
        recycler.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.playLists.collect { playLists ->
                adapter.submitList(playLists)
            }
        }
    }
}