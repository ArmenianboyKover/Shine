package com.example.shine.songs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.shine.R
import com.example.shine.databinding.FragmentSongsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SongsFragment : Fragment(R.layout.fragment_songs) {

    private val viewBinding by viewBinding(FragmentSongsBinding::bind)

    private val viewModel by viewModels<SongsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = SongsAdapter {
            viewModel.onSongClicked(it)
        }

        viewBinding.recyclerView.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.songs.collect { songs ->
                adapter.submitList(songs)
            }
        }
    }
}