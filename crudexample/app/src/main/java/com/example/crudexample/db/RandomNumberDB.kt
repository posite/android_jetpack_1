package com.example.crudexample.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.crudexample.db.dao.RandomNumberDAO
import com.example.crudexample.db.entity.RandomNumberEntity

@Database(entities = [RandomNumberEntity::class], version = 1)
abstract class RandomNumberDB: RoomDatabase() {

    abstract fun numberDAO() : RandomNumberDAO

    companion object {
        @Volatile
        private var INSTANCE: RandomNumberDB? = null

        fun getDB(context: Context): RandomNumberDB {

            return INSTANCE?: synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext, RandomNumberDB::class.java,"user_table")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

}