package com.example.myapplication.db

import android.content.Context
import android.util.Log
import androidx.room.*
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.myapplication.db.dao.TextDAO
import com.example.myapplication.db.dao.TextDAO2
import com.example.myapplication.db.entity.BitmapConverter
import com.example.myapplication.db.entity.DateConverter
import com.example.myapplication.db.entity.TextEntity
import com.example.myapplication.db.entity.TextEntity2

//@Database(entities = [TextEntity::class, TextEntity2::class], version = 3)
//@Database(entities = [TextEntity::class], version = 2, autoMigrations = [AutoMigration(from = 1, to = 2)])
@Database(entities = [TextEntity::class], version = 1)
//@TypeConverters(DateConverter::class)
@TypeConverters(BitmapConverter::class)
abstract class TextDB: RoomDatabase() {

    abstract fun textDAO() : TextDAO
//    abstract fun textDAO2() : TextDAO2

    companion object {
        @Volatile
        private var INSTANCE: TextDB? = null

        fun getDB(context: Context): TextDB {

            return INSTANCE?: synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext, TextDB::class.java,"text_db")
//                    .fallbackToDestructiveMigration()
//                    .addMigrations(MIGRATION_1_2)
//                    .addMigrations(MIGRATION_2_3)
                    .build()
                INSTANCE = instance
                instance
            }
        }

//        val MIGRATION_1_2 = object : Migration(1,2) {
//            override fun migrate(database: SupportSQLiteDatabase) {
//                Log.d("migrate", "migrate 1, 2")
//                database.execSQL("CREATE TABLE `text_table2` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `text2` TEXT NOT NULL)")
//            }
//
//        }
//
//        val MIGRATION_2_3 = object : Migration(2,3) {
//            override fun migrate(database: SupportSQLiteDatabase) {
//                Log.d("migrate", "migrate 2, 3")
//                database.execSQL("ALTER TABLE `text_table2` ADD COLUMN `newText` TEXT NOT NULL DEFAULT `new`")
//            }
//
//        }
    }
}