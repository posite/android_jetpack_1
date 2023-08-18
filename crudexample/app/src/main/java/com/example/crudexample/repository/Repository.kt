package com.example.crudexample.repository

import com.example.crudexample.MyApp
import com.example.crudexample.db.RandomNumberDB
import com.example.crudexample.db.entity.RandomNumberEntity

class Repository {

    private val context = MyApp.context()

    private val db = RandomNumberDB.getDB(context)

    fun create(numberEntity: RandomNumberEntity) = db.numberDAO().insertNumber(numberEntity)

    fun read() = db.numberDAO().getAllNumberFlow()

    fun update(numberEntity: RandomNumberEntity) = db.numberDAO().updateNumber(numberEntity)

    fun delete(numberEntity: RandomNumberEntity) = db.numberDAO().deleteNumber(numberEntity)
}