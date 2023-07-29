package com.example.roomflowlistadapter.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class], version = 1)
abstract class UserDB : RoomDatabase() {
    abstract fun userDAO() : UserDAO

    companion object {
        @Volatile
        private var INSTANCE: UserDB? = null

        fun getDB(context: Context): UserDB {

            return INSTANCE?: synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext, UserDB::class.java,"user_table")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}