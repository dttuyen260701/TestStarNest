package com.example.teststarnest.data.repository.keyboardcategory

import com.example.teststarnest.data.dao.*
import com.example.teststarnest.data.model.*
import javax.inject.*

/**
 * Created by tuyen.dang on 1/22/2024.
 */

class KeyBoardCategoryRepositoryImpl @Inject constructor(
    private val keyBoardCategoryDao: KeyBoardCategoryDao
): KeyBoardCategoryRepository {
    override suspend fun insertCategories(vararg categories: KeyBoardCategory) {
        keyBoardCategoryDao.insertCategories(*categories)
    }

    override suspend fun getKeyBoardCategories(): List<KeyBoardCategory> {
        return keyBoardCategoryDao.getKeyBoardCategories()
    }
}