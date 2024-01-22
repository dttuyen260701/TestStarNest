package com.example.teststarnest.data.repository.keyboardcategory

import com.example.teststarnest.data.model.*

/**
 * Created by tuyen.dang on 1/22/2024.
 */

interface KeyBoardCategoryRepository {
    suspend fun insertCategories(vararg categories: KeyBoardCategory)

    suspend fun getKeyBoardCategories(): List<KeyBoardCategory>
}