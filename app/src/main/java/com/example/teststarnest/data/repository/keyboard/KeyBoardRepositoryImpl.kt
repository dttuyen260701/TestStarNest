package com.example.teststarnest.data.repository.keyboard

import com.example.teststarnest.data.dao.*
import com.example.teststarnest.data.model.*
import com.example.teststarnest.until.*
import javax.inject.Inject

/**
 * Created by tuyen.dang on 1/22/2024.
 */

class KeyBoardRepositoryImpl @Inject constructor(
    private val keyBoardDao: KeyBoardDao
) : KeyBoardRepository {
    override suspend fun insertKeyBoards(vararg keyBoards: KeyBoard) {
        keyBoardDao.insertKeyBoards(*keyBoards)
    }

    override suspend fun getKeyBoards(categoryId: Long): List<KeyBoard> {
        return keyBoardDao.run {
            if (categoryId == Constant.DefaultValue.DEFAULT_ALL_TYPE_ID) {
                getKeyBoards()
            } else {
                getKeyBoardsByCategoryId(categoryId)
            }
        }
    }
}