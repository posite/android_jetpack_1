package com.example.roomflowlistadapter.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDAO {
    @Query("SELECT * FROM user_table")
    fun getAllUserFlow(): Flow<List<UserEntity>>

    @Query("SELECT * FROM user_table")
    fun getAllUser(): List<UserEntity>

    @Query("SELECT * FROM user_table WHERE id= :id")
    fun getUser(id: Int): UserEntity

    @Query("SELECT * FROM user_table WHERE id= :id")
    fun getUserFlow(id: Int): Flow<UserEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(user: UserEntity)

    @Update
    fun updateUser(user: UserEntity)

    @Delete
    fun deleteUser(user: UserEntity)
}