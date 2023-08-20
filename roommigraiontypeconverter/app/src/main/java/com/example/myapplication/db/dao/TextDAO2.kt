package com.example.myapplication.db.dao

import androidx.room.*
import com.example.myapplication.db.entity.TextEntity
import com.example.myapplication.db.entity.TextEntity2

@Dao
interface TextDAO2 {

    @Query("SELECT * FROM text_table2")
    fun getAllText(): List<TextEntity2>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertText(entity: TextEntity2)

    @Query("DELETE FROM text_table2")
    fun deleteAllText()

    @Delete
    fun deleteText(entity: TextEntity2)
}