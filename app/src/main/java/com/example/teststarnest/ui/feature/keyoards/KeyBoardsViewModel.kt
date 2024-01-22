package com.example.teststarnest.ui.feature.keyoards

import androidx.lifecycle.ViewModel
import com.example.teststarnest.data.repository.keyboard.*
import com.example.teststarnest.data.repository.keyboardcategory.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by tuyen.dang on 1/22/2024.
 */

@HiltViewModel
class KeyBoardsViewModel @Inject constructor(
    private val categoryRepository: KeyBoardCategoryRepository,
    private val keyBoardRepository: KeyBoardRepository
) : ViewModel() {

}