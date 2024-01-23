package com.example.teststarnest.ui.feature.keyoards

/**
 * Created by tuyen.dang on 1/23/2024.
 */

sealed interface KeyBoardsEvent {
    data class ChoiceCategory(val categoryId: Long) : KeyBoardsEvent
}