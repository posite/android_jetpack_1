package com.example.crudexample.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.crudexample.db.entity.RandomNumberEntity
import com.example.crudexample.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val repository = Repository()

    lateinit var numberEntityList: LiveData<List<RandomNumberEntity>>

    fun create(numberEntity: RandomNumberEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.create(numberEntity)
    }

    fun read() {
        numberEntityList = repository.read().asLiveData()
    }

    fun update(numberEntity: RandomNumberEntity) = viewModelScope.launch(Dispatchers.IO)  {
        val number = (0..100).random()
        numberEntity.number = "updated: $number"

        repository.update(numberEntity)
    }

    fun delete(numberEntity: RandomNumberEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(numberEntity)
    }
}