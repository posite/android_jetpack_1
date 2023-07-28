package com.example.bindingadapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewmodel : ViewModel() {
    private val _point = MutableLiveData(0)

    val point: LiveData<Int> = _point

    val pointType: LiveData<PointType> = Transformations.map(_point) {
        when {
            it > 75 -> {
                PointType.Big
            }
            it > 50 -> {
                PointType.MIDDLE
            }
            it > 25 -> {
                PointType.SMALL
            }
            else -> {
                PointType.TINY
            }
        }
    }

    fun plusPoint() {
        _point.value = _point.value?.plus(5)
    }
}

enum class PointType {
    Big, MIDDLE, SMALL, TINY
}