package com.example.shine.app

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var isFirstLaunch = true
        private set

    fun onActivityFirstLaunch() {
        isFirstLaunch = false
    }
}