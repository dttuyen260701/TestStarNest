package com.example.teststarnest.data.database

import androidx.room.*
import com.example.teststarnest.data.dao.*
import com.example.teststarnest.data.model.*

/**
 * Created by tuyen.dang on 1/22/2024.
 */

@Database(entities = [KeyBoardCategory::class, KeyBoard::class], version = 1)
abstract class KeyBoardDatabase : RoomDatabase() {
    abstract fun keyBoardDao() : KeyBoardDao

    abstract fun KeyBoardCategoryDao() : KeyBoardCategoryDao
}
