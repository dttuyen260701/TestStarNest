package com.example.teststarnest.data.dao

import androidx.room.*
import com.example.teststarnest.data.model.*

/**
 * Created by tuyen.dang on 1/22/2024.
 */

@Dao
interface KeyBoardDao {
    @Insert
    suspend fun insertKeyBoards(vararg keyBoards: KeyBoard)

    @Transaction
    @Query("SELECT * FROM KeyBoard")
    suspend fun getKeyBoards(): List<KeyBoard>

    @Transaction
    @Query("SELECT * FROM KeyBoard WHERE categoryId = :categoryId")
    suspend fun getKeyBoardsByCategoryId(categoryId :Long): List<KeyBoard>
}
