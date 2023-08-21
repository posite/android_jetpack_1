package com.example.datastoreexample

import android.app.Application
import androidx.datastore.dataStoreFile
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {
    private val dataStore = StrDataStore(application)

    fun insert(str: String) = viewModelScope.launch {
        dataStore.insertStr(str)
    }

    val read = dataStore.getStr.asLiveData()
}