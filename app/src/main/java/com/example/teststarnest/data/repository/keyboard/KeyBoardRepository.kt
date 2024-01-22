package com.example.teststarnest.data.repository.keyboard

import com.example.teststarnest.data.model.*

/**
 * Created by tuyen.dang on 1/22/2024.
 */

interface KeyBoardRepository {
    suspend fun insertKeyBoards(vararg keyBoards: KeyBoard)

    suspend fun getKeyBoards(categoryId :String? = null): List<KeyBoard>
}