package com.example.jetpackexmaple

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var _wordData = MutableLiveData<String>()
    val wordData : LiveData<String>
        get() = _wordData

    fun setWord(word: String) {
        Log.d("inputs", "input: $word")
        val sb = StringBuilder()
        if(_wordData.value != null) {
            sb.append(_wordData.value)
            sb.append("\n$word")
        } else {
            sb.append(word)
        }

        _wordData.value = sb.toString()
    }
}