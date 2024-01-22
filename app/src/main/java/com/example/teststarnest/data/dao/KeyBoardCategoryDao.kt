package com.example.teststarnest.data.dao

import androidx.room.*
import com.example.teststarnest.data.model.*

/**
 * Created by tuyen.dang on 1/22/2024.
 */

@Dao
interface KeyBoardCategoryDao {
    @Insert
    fun insertCategories(vararg categories: KeyBoardCategory)

    @Transaction
    @Query("SELECT * FROM KeyBoardCategory")
    fun getKeyBoardCategories(): List<KeyBoardCategory>
}