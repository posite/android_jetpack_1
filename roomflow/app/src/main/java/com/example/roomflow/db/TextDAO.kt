package com.example.roomflow.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TextDAO {
    @Query("SELECT * FROM text_table")
    fun getAllData() : List<TextEntity>

    @Query("SELECT * FROM text_table")
    fun getAllDataFlow() : Flow<List<TextEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertData(entity: TextEntity)

    @Query("DELETE FROM text_table")
    fun deleteData()

}