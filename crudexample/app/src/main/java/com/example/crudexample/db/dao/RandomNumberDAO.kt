package com.example.crudexample.db.dao

import androidx.room.*
import com.example.crudexample.db.entity.RandomNumberEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RandomNumberDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertNumber(number: RandomNumberEntity)

    @Query("SELECT * FROM random_table")
    fun getAllNumberFlow(): Flow<List<RandomNumberEntity>>

    @Update
    fun updateNumber(user: RandomNumberEntity)

    @Delete
    fun deleteNumber(user: RandomNumberEntity)
}