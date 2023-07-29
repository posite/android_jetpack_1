package com.example.roomflow.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TextEntity::class], version = 1)
abstract class TextDB: RoomDatabase() {
    abstract fun dao(): TextDAO

    companion object {
        @Volatile
        private var INSTANCE: TextDB? = null

        fun getDatabase(context: Context): TextDB {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext, TextDB::class.java, "text_table")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}