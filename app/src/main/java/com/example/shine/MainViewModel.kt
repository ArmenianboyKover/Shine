package com.example.shine

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var isFirstLaunch = true
        private set

    fun onActivityFirstLaunch() {
        isFirstLaunch = false
    }
}