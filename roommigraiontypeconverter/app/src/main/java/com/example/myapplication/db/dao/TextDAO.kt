package com.example.myapplication.db.dao

import androidx.room.*
import com.example.myapplication.db.entity.TextEntity

@Dao
interface TextDAO {

    @Query("SELECT * FROM text_table")
    fun getAllText(): List<TextEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertText(entity: TextEntity)

    @Query("DELETE FROM text_table")
    fun deleteAllText()

    @Delete
    fun deleteText(entity: TextEntity)
}