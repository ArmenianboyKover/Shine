package com.example.shine.songs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.shine.R
import kotlinx.coroutines.launch

class SongsFragment : Fragment(R.layout.fragment_songs) {

    private val viewModel by viewModels<SongsViewModel>()

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