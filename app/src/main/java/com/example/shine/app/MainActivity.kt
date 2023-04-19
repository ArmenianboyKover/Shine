package com.example.shine.app

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.shine.R
import com.example.shine.history.HistoryFragment
import com.example.shine.playlist.PlaylistFragment
import com.example.shine.songs.SongsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (viewModel.isFirstLaunch) {
            loadFragment(SongsFragment())
            viewModel.onActivityFirstLaunch()
        }

        val navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        navigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.songs -> {
                    loadFragment(SongsFragment())
                    true
                }
                R.id.playlists -> {
                    loadFragment(PlaylistFragment())
                    true
                }
                R.id.history -> {
                    loadFragment(HistoryFragment())
                    true
                }
                else -> false
            }
        }
    }

    fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}