package com.example.shine

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.shine.playlist.PlaylistFragment
import com.example.shine.songs.SongsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadFragment(SongsFragment())
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
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }
}