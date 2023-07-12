package com.example.jetpackexmaple

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class MainViewModel: ViewModel() {
    private var _wordData = MutableLiveData<String>()
    val wordData : LiveData<String>
        get() = _wordData

    private var number = 0

    val mapLiveData = _wordData.map { it + it }
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

    fun clickWord() {
        Log.d("inputs", "click: $number")
        val sb = StringBuilder()
        if(_wordData.value != null) {
            sb.append(_wordData.value)
            sb.append("\n${number}")
        } else {
            sb.append(number.toString())
        }
        number++
        _wordData.value = sb.toString()
    }
}