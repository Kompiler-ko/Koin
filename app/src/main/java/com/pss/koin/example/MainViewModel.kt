package com.pss.koin.example

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(
    private val giphyApi: GiphyApi
) : ViewModel() {

    fun getApi() = viewModelScope.launch {
        Log.d("로그",giphyApi.getGiphyGifs(offset = 20).body().toString())
    }
}